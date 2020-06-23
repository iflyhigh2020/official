<template>
    <div id="footer">
        <el-collapse :accordion="true">
            <el-collapse-item class="collapse-header" title="Logo设置" name="1">
                <div style="height:20px"></div>
                <Logo></Logo>
            </el-collapse-item>
            <el-collapse-item class="collapse-header" title="底部Footer" name="2">
                <div style="height:20px"></div>
                <el-form :model="ruleForm" ref="ruleForm" label-width="100px" class="demo-ruleForm">
                    <el-form-item label="标题" prop="title">
                        <el-input v-model="ruleForm.title"></el-input>
                    </el-form-item>
                    <el-form-item label="背景色" prop="bgColor">
                        <el-color-picker v-model="ruleForm.bgColor" size="medium"></el-color-picker>
                    </el-form-item>
                    <el-form-item label="第1行" prop="text1">
                        <el-input v-model="ruleForm.text1"></el-input>
                    </el-form-item>
                    <el-form-item label="第2行" prop="text2">
                        <el-input v-model="ruleForm.text2"></el-input>
                    </el-form-item>
                    <el-form-item label="第3行" prop="text3">
                        <el-input v-model="ruleForm.text3"></el-input>
                    </el-form-item>
                    <el-form-item label="第4行" prop="text4">
                        <el-input v-model="ruleForm.text4"></el-input>
                    </el-form-item>
                    <el-form-item label="第5行" prop="text5">
                        <el-input v-model="ruleForm.text5"></el-input>
                    </el-form-item>
                    <el-form-item>
                        <el-button type="primary" @click="submit('/footer/save','ruleForm')">提交</el-button>
                        <el-button @click="resetForm('ruleForm')">重置</el-button>
                    </el-form-item>
                </el-form>
            </el-collapse-item>
            <el-collapse-item class="collapse-header" title="右侧Footer" name="3">
                <div style="height:20px"></div>
                <el-form :model="rightFooterForm" ref="rightFooterForm" label-width="100px" class="demo-rightForm">
                    <el-form-item label="淘宝地址" prop="col1">
                        <el-input v-model="rightFooterForm.col1" placeholder="请输入url（需要带上http://或者https://）">
                        </el-input>
                    </el-form-item>
                    <el-form-item label="京东地址" prop="col2">
                        <el-input v-model="rightFooterForm.col2" placeholder="请输入url（需要带上http://或者https://）">
                        </el-input>
                    </el-form-item>
                    <el-form-item label="微信" prop="col3">
                        <Upload @getImgUrl6="initImgUrl" :source="this.$options.name" ref="upload"></Upload>
                    </el-form-item>
                    <el-form-item label="微博" prop="col4">
                        <el-input v-model="rightFooterForm.col4" placeholder="请输入url（需要带上http://或者https://）">
                        </el-input>
                    </el-form-item>
                    <el-form-item label="输入QQ号" prop="col2">
                        <el-input v-model="rightFooterForm.col5" placeholder="访客点击后弹出聊天对象的QQ">
                        </el-input>
                    </el-form-item>
                    <el-form-item>
                        <el-button type="primary" @click="submit('/rightFooter/save','rightFooterForm')">提交</el-button>
                        <el-button @click="resetForm('rightFooterForm')">重置</el-button>
                    </el-form-item>
                </el-form>
            </el-collapse-item>
            <el-collapse-item class="collapse-header" title="密码设置" name="4">
                <div style="height:20px"></div>
                <el-form :model="userForm" ref="userForm" label-width="100px" class="demo-userForm">
                    <el-form-item label="旧密码" prop="password">
                        <el-input type="password" v-model="userForm.password" placeholder="输入旧密码">
                        </el-input>
                    </el-form-item>
                    <el-form-item label="新密码" prop="newPwd">
                        <el-input type="password" v-model="userForm.newPwd" placeholder="输入新密码">
                        </el-input>
                    </el-form-item>
                    <el-form-item label="确认新密码" prop="reNewPwd">
                        <el-input type="password" v-model="userForm.reNewPwd" placeholder="再次输入新密码">
                        </el-input>
                    </el-form-item>
                    <el-form-item>
                        <el-button type="primary" @click="modifyPwd()">提交</el-button>
                        <el-button @click="resetForm('userForm')">重置</el-button>
                    </el-form-item>
                </el-form>
            </el-collapse-item>
        </el-collapse>
    </div>
</template>

<script>
    import Upload from './components/Upload'
    import Logo from './page_element/Logo'

    export default {
        name: 'Footer',
        components: {Upload, Logo},
        data() {
            return {
                ruleForm: {
                    title: '',
                    bgColor: '#474747',
                    text1: '',
                    text2: '',
                    text3: '',
                    text4: '',
                    text5: ''
                },
                rightFooterForm: {
                    col1:"",
                    col2:"",
                    col3:"",
                    col4:"",
                    col5:""
                },
                userForm: {
                    password:"",
                    newPwd:"",
                    reNewPwd:""
                }
            };
        },
        methods: {

            modifyPwd() {
                const url = this.commRouter + "/user/modifyPwd";
                let data = this.userForm;

                if (!!!data || !!!data.password || !!!data.newPwd || !!!data.reNewPwd) {
                    this.$notify({title: '警告', message: '请填写内容', type: 'warning'});
                    return false;
                }

                if (data.newPwd !== data.reNewPwd) {
                    this.$notify({title: '警告', message: '两次输入密码不一致', type: 'warning'});
                    return false;
                }
                data.username = this.getLoginName();
                this.httpPost(url, data, true, false)
                    .then((response) => {
                        if (response.data.code == 0) {
                            this.$notify({title: 'Success', message: '密码修改成功！后续操作会自动退出系统，请立即退出重新登录再操作。', type: 'success'});
                            this.resetForm("userForm");
                        } else {
                            this.$notify({title: 'Failure', message: response.data.message, type: 'warning'});
                        }
                    }).catch((error) => {
                       console.log(error)
                });
            },

            submit(submiturl, formName) {
                const url = this.commRouter + submiturl;
                let data = null;
                if (formName === 'ruleForm') {
                    data= this.ruleForm
                } else if (formName === 'rightFooterForm') {
                    data= this.rightFooterForm;
                }
                this.httpPost(url, data, true, true)
                    .then((response) => {
                        this.resetForm(formName);
                    }).catch((error) => {
                    console.log(error)
                });
            },
            initImgUrl(data) {
                this.rightFooterForm.col3 = data;
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
                if (formName === 'rightFooterForm') {
                    this.clearImg();
                }
            },
            clearImg() {
                this.$refs.upload.clear();
                this.ruleForm.imgUrl = '';
            }
        }
    };
</script>

<style scoped>
    .collapse-header >>> .el-collapse-item__header{
        background-color: #324157 !important;
        font-size: 16px;
        padding-left: 10px;
        font-weight: bold;
        color: white;
    }
</style>