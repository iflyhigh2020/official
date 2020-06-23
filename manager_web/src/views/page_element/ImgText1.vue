<template>
    <div id="imgText1">
        <div class="upload-container">
            <Upload @getImgUrl2="initImgUrl" :source="this.$options.name"  ref="upload"></Upload>
        </div>
        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">

            <el-form-item label="高度" prop="height">
                <el-input v-model="ruleForm.height" placeholder="请输入数字"></el-input>
            </el-form-item>
            <el-form-item label="宽度百分比" prop="width" >
                <el-input v-model="ruleForm.width" placeholder="请输入0-100之间的数字"></el-input>
            </el-form-item>

            <el-form-item label="标题" prop="title">
                <el-input v-model="ruleForm.title"></el-input>
            </el-form-item>
            <el-form-item label="内容" prop="content">
                <SelfTinymceEditor
                        style="margin-top: 10px"
                        ref="editor"
                        v-model="ruleForm.content"
                        :disabled="tinymceFields.disabled">
                </SelfTinymceEditor>
            </el-form-item>
            <el-form-item label="是否禁用" prop="targetUrl">
                <el-radio-group v-model="ruleForm.activeFlag">
                    <el-radio border :label="1">激活</el-radio>
                    <el-radio border :label="0">禁用</el-radio>
                </el-radio-group>
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
    import SelfTinymceEditor from "../../components/tinymce/SelfTinymceEditor";

    export default {
        name: 'ImgText1',
        components: {
            Upload, SelfTinymceEditor
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
                tinymceFields: {
                    disabled: false
                },
                ruleForm: {
                    imgUrl:'',
                    title: '',
                    content: '',
                    activeFlag: 1,
                    pageType:0,
                    groupId: 0
                },
                rules: {
                    title: [
                        {max: 50, message: '不能超过50个字符' ,trigger: 'blur' }
                    ],
                    targetUrl: [
                        {max: 100, message: '不能超过100个字符' ,trigger: 'blur' }
                    ],
                    content: [
                        {max: 250, message: '不能超过250个字符' ,trigger: 'blur' }
                    ]
                }
            }
        },
        methods: {
            initImgUrl(data) {
                this.ruleForm.imgUrl = data;
            },
            submit() {
                const url = this.commRouter + '/imgText/save';
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
    #imgText1 .upload-container {
        margin-bottom: 10px;
        display: flex;
        justify-content: center;
    }
</style>