package com.leslie.silk.service;

import com.leslie.silk.entity.User;
import com.leslie.silk.mapper.UserMapper;
import com.leslie.silk.util.SecretUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author makejava
 * @since 2020-04-29 13:55:40
 */
@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */

    public User queryById(Integer id) {
        return this.userMapper.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */

    public List<User> queryAllByLimit(int offset, int limit) {
        return this.userMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */

    public User insert(User user) {
        this.userMapper.insert(user);
        return user;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */

    public User update(User user) {
        this.userMapper.update(user);
        return this.queryById(user.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */

    public boolean deleteById(Integer id) {
        return this.userMapper.deleteById(id) > 0;
    }

    /**
     * 简单登录功能，返回一个token
     *
     * @param user
     * @return
     * @throws Exception
     */
    public String login(User user) throws Exception {
        User userDB = userMapper.getByUsername(user.getUsername());
        if (null == userDB || !StringUtils.equals(user.getPassword(), userDB.getPassword())) {
            throw new Exception("登录失败");
        }
        String md5Source = getMD5Source(userDB);
        return SecretUtils.genMD5(md5Source) + "-" + userDB.getId();
    }

    public boolean check(String token) throws Exception {
        if (StringUtils.isBlank(token)) {
            return false;
        }
        String[] tokenArr = StringUtils.split(token, "-");
        if (null == tokenArr || tokenArr.length != 2) {
            return false;
        }
        String md5Str = tokenArr[0];
        String userId = tokenArr[1];

        /*if (StringUtils.equals(md5Str, map.get(userId))) {
            return true;
        }*/

        User user = userMapper.queryById(Integer.valueOf(userId));
        if (null == user) {
            return false;
        }
        String md5Source = getMD5Source(user);
        if (!StringUtils.equals(SecretUtils.genMD5(md5Source), md5Str)) {
            return false;
        }
        /*if (StringUtils.isBlank(map.get(userId))) {
            map.remove(userId);
        }
        map.put(userId, md5Str);*/
        return true;
    }

//    static Map<String, String> map = new ConcurrentHashMap<>();

    private String getMD5Source(User user) {
        return user.getId() + "-" + user.getUsername() + "-" + user.getPassword();
    }


    public void modifyPwd(User user) throws Exception {
        if (null == user || StringUtils.isBlank(user.getUsername())
                || StringUtils.isBlank(user.getNewPwd()) || StringUtils.isBlank(user.getPassword())) {
            throw new Exception("modify password is error.");
        }
        User userDB = userMapper.getByUsername(user.getUsername());
        if (null == userDB) {
            throw new Exception("modify password is error.");
        }
        if (!user.getPassword().equals(userDB.getPassword())) {
            throw new Exception("旧密码输入有误");
        }
        if (user.getNewPwd().equals(userDB.getPassword())) {
            throw new Exception("修改后的密码不能重复");
        }
        if (user.getNewPwd().length() < 6) {
            throw new Exception("密码长度不能小于6位");
        }
        if (containsSpecialChar(user.getNewPwd())) {
            throw new Exception("不能包含特殊字符");
        }

        userDB.setPassword(user.getNewPwd());
        userDB.setUpdateTime(new Date());
        userMapper.update(userDB);
    }

    private boolean containsSpecialChar(String pwd) {
        return pwd.contains("-") || pwd.contains("/") || pwd.contains("~")
                || pwd.contains("？") || pwd.contains("`") || pwd.contains("-");
    }
}