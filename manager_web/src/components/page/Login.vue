<template>
    <div class="login-wrap">
        <div class="ms-login">
            <div class="ms-title">后台管理系统</div>
            <el-form :model="param" :rules="rules" ref="login" label-width="0px" class="ms-content">
                <el-form-item prop="username">
                    <el-input v-model="param.username" placeholder="username">
                        <el-button slot="prepend" icon="el-icon-lx-people"></el-button>
                    </el-input>
                </el-form-item>
                <el-form-item prop="password">
                    <el-input
                        type="password"
                        placeholder="password"
                        v-model="param.password"
                        @keyup.enter.native="submitForm()"
                    >
                        <el-button slot="prepend" icon="el-icon-lx-lock"></el-button>
                    </el-input>
                </el-form-item>
                <div class="login-btn">
                    <el-button type="primary" @click="submitForm()">登录</el-button>
                </div>
            </el-form>
        </div>
    </div>
</template>

<script>
export default {
    data: function() {
        return {
            param: {
                username: '',
                password: '',
            },
            rules: {
                username: [{ required: true, message: '请输入用户名', trigger: 'blur' }],
                password: [{ required: true, message: '请输入密码', trigger: 'blur' }],
            },
        };
    },
    methods: {
        compareDate(date1,date2){
            var oDate1 = new Date(date1);
            var oDate2 = new Date(date2);
            if(oDate1.getTime() > oDate2.getTime()){
                return true; //第一个大
            } else {
                return false; //第二个大
            }
        },
        submitForm() {
            ////////////////////////////////////////

            this.$refs.login.validate(valid => {
                if (valid) {
                    this.axios({
                        method: 'post',
                        url: '/user/login',
                        data: this.param
                    })
                        .then((response) => {
                            if (response.data.code === 0) {
                                this.clearLoginInfo();
                                sessionStorage.setItem(this.LOCAL_AUTH_KEY, response.data.value);
                                sessionStorage.setItem(this.LOGIN_USER_NAME, this.param.username);

                                this.$router.push('/');
                                this.$notify({ title: '登录成功', message: 'Success!', type: 'success'});

                                if (this.compareDate('2020-05-30', new Date())) {
                                    this.$alert(
                                        '<p>1.优化了手机端的显示，修复手机端页面菜单bug</p>' +
                                        '<p>2.手机端图片响应式显示优化</p>' +
                                        '<p>3.关于我们中增加公司信息、品牌信息，移除时间轴</p>' +
                                        '<p>4.修复“关于我们”信息未保存成功的bug</p>' +
                                        '<p>5.化妆品、医用耗材、卫生巾用品中增加一个横幅与图文的展示配置</p>' +
                                        '<p>6.优化右侧淘宝、京东等图标的展示，增加点击弹出QQ聊天的图标</p>' +
                                        '<p>7.回到顶部按钮美化</p>' +
                                        '<p style="color:red">8.页面基础元素中增加修改密码的功能</p>'
                                        , '更新内容（2020-05-22）', {
                                            dangerouslyUseHTMLString: true
                                        });
                                }

                            } else {
                                this.$notify.error({
                                    title: '登录失败',
                                    message: response.data.message
                                });
                                this.clearLoginInfo();
                                return false;
                            }
                        })
                        .catch((error) => {
                            this.$notify.error({
                                title: '登录失败',
                                message: error
                            });
                            this.clearLoginInfo();
                            return false;
                        })
                } else {
                    this.$message.error('请输入账号和密码');
                    console.log('error submit!!');
                    return false;
                }
            });
        },
    },
};
</script>

<style scoped>
.login-wrap {
    position: relative;
    width: 100%;
    height: 100%;
    background-image: url(../../assets/img/login-bg.jpg);
    background-size: 100%;
}
.ms-title {
    width: 100%;
    line-height: 50px;
    text-align: center;
    font-size: 20px;
    color: #fff;
    border-bottom: 1px solid #ddd;
}
.ms-login {
    position: absolute;
    left: 50%;
    top: 50%;
    width: 350px;
    margin: -190px 0 0 -175px;
    border-radius: 5px;
    background: rgba(255, 255, 255, 0.3);
    overflow: hidden;
}
.ms-content {
    padding: 30px 30px;
}
.login-btn {
    text-align: center;
}
.login-btn button {
    width: 100%;
    height: 36px;
    margin-bottom: 10px;
}
.login-tips {
    font-size: 12px;
    line-height: 30px;
    color: #fff;
}
</style>