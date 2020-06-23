<template>
    <div id="Banner">
        <div class="upload-container">
            <Upload @getImgUrl4="initImgUrl" :source="this.$options.name"  ref="upload"></Upload>
        </div>
        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
            <el-form-item label="高度" prop="height">
                <el-input placeholder="请填写数字" v-model="ruleForm.height"></el-input>
            </el-form-item>
            <el-form-item label="内容" prop="content">
<!--                <el-input type="textarea" v-model="ruleForm.content"></el-input>-->
                <SelfTinymceEditor
                        style="margin-top: 10px"
                        ref="editor"
                        v-model="ruleForm.content">
                </SelfTinymceEditor>

            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="submit('ruleForm')">提交</el-button>
                <el-button @click="resetForm('ruleForm')">重置</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
    import Upload from '../components/Upload';
    import SelfTinymceEditor from '../../components/tinymce/SelfTinymceEditor'

    export default {
        name: 'Banner',
        components: {
            Upload,SelfTinymceEditor
        },
        props: {
            pageType: {
                type: Number
            },
            groupId: {
                type: Number
            }
        },
        data() {
            return {
                ruleForm: {
                    imgUrl:'',
                    height: 300,
                    content: '',
                    activeFlag: 1,
                    pageType:0,
                    groupId: 0
                },
                // rules: {
                //     height: [
                //         {trigger: 'blur', type: 'number' }
                //     ]
                // }
            }
        },
        methods: {
            initImgUrl(data) {
                this.ruleForm.imgUrl = data;
                console.log(this.ruleForm.imgUrl)
            },
            submit() {
                const url = this.commRouter + '/banner/save';
                this.ruleForm.pageType = this.pageType;
                this.ruleForm.groupId = this.groupId;
                const data= this.ruleForm
                if (!!!this.ruleForm.imgUrl) {
                    alert("请上传图片");
                    return false;
                }
                this.httpPost(url, data, true, true)
                    .then((response) => {
                        this.resetForm('ruleForm');
                    }).catch((error) => {
                    console.log(error)
                });
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
                this.clearImg();
            },
            clearImg() {
                this.$refs.upload.clear();
                this.ruleForm.imgUrl = '';
            }
        }
    };
</script>

<style scoped>
    #Banner .upload-container {
        margin-bottom: 10px;
        display: flex;
        justify-content: center;
    }
</style>