<template>
    <div id="article">
        <el-form :model="ruleForm"  ref="ruleForm" label-width="100px" class="demo-ruleForm">
            <el-form-item label="标题" prop="articleTitle">
                <el-input placeholder="此处可以暂时不填" v-model="ruleForm.articleTitle"></el-input>
            </el-form-item>
            <el-form-item label="内容" prop="content">
                <SelfTinymceEditor
                        style="margin-top: 10px"
                        ref="editor"
                        v-model="ruleForm.content"
                        :disabled="tinymceFields.disabled">
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
    import SelfTinymceEditor from "../../components/tinymce/SelfTinymceEditor";

    export default {
        name: 'Article',
        components: {
            SelfTinymceEditor
        },
        props: {
            submitUrl: {
                type: String
            },
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
                    articleTitle: '',
                    content: '',
                    pageType:0,
                    groupId:0
                }
            };

        },
        methods: {
            submit() {
                const url = this.commRouter + this.submitUrl;
                this.ruleForm.pageType = this.pageType;
                this.ruleForm.groupId = this.groupId;
                const data= this.ruleForm

                this.httpPost(url, data, true, true)
                    .then((response) => {
                        this.resetForm('ruleForm');
                    }).catch((error) => {
                    console.log(error)
                });
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            }
        }
    };
</script>

<style scoped>

    #article {
        padding-top: 20px;
    }

</style>