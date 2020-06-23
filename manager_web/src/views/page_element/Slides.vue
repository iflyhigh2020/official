<template>
    <div id="slides">
        <el-divider>轮播图框架设置</el-divider>
        <div class="slides-block">
            <el-form :model="slidesInfoForm" :rules="rules" ref="slidesInfoForm" label-width="100px" class="demo-ruleForm">
                <el-form-item label="高度" prop="height">
                    <el-input v-model="slidesInfoForm.height" placeholder="请输入数字"></el-input>
                </el-form-item>
                <el-form-item label="宽度百分比" prop="width" >
                    <el-input v-model="slidesInfoForm.width" placeholder="请输入0-100之间的数字"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="submitSlidesInfo('slidesInfoForm')">提交</el-button>
                    <el-button @click="resetForm('slidesInfoForm')">重置</el-button>
                </el-form-item>
            </el-form>
        </div>
        <el-divider>图片信息设置</el-divider>
        <div class="slides-block">
            <div class="upload-container">
                <Upload @getImgUrl="initImgUrl" :source="this.$options.name" ref="upload"></Upload>
            </div>
            <div class="form-container">
                <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
                    <el-form-item label="标题" prop="title">
                        <el-input v-model="ruleForm.title"></el-input>
                    </el-form-item>
                    <el-form-item label="详情" prop="content">
                        <SelfTinymceEditor
                                style="margin-top: 10px"
                                ref="editor"
                                v-model="ruleForm.content">
                        </SelfTinymceEditor>
                    </el-form-item>
                    <el-form-item label="跳转链接" prop="targetUrl">
                        <el-input v-model="ruleForm.targetUrl"></el-input>
                    </el-form-item>
                    <el-form-item label="是否禁用" prop="activeFlag">
                        <el-radio-group v-model="ruleForm.activeFlag">
                            <el-radio border :label="1">激活</el-radio>
                            <el-radio border :label="0">禁用</el-radio>
                        </el-radio-group>
                    </el-form-item>
                    <el-form-item label="顺序" prop="orderNum">
                        <el-input type="number" v-model="ruleForm.orderNum"></el-input>
                    </el-form-item>
                    <el-form-item>
                        <el-button type="primary" @click="submit('ruleForm')">提交</el-button>
                        <el-button @click="resetForm('ruleForm')">重置</el-button>
                    </el-form-item>
                </el-form>
            </div>
            <div class="table">
                <el-divider content-position="left">已添加的轮播图</el-divider>
                <div>
                    <SlidesTable ref="slidesTable" :page-type="pageType" :group-id="groupId"></SlidesTable>
                </div>
            </div>
        </div>

    </div>
</template>

<script>
    import Upload from '../components/Upload';
    import SlidesTable from '../components/SlidesTable'
    import SelfTinymceEditor from '../../components/tinymce/SelfTinymceEditor'
    export default {
        name: 'Slides',
        components: {Upload, SlidesTable, SelfTinymceEditor},
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
                    title: '',
                    content: '',
                    targetUrl: '',
                    activeFlag: 1,
                    orderNum: 0,
                    pageType:0,
                    groupId: 0
                },
                slidesInfoForm: {
                    height:'',
                    width:''
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
                const url = this.commRouter + '/slides/save';
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
                        this.$refs.slidesTable.getData(1);
                    }).catch((error) => {
                    console.log(error)
                });
            },
            submitSlidesInfo() {
                const url = this.commRouter + '/slidesInfo/save';
                this.slidesInfoForm.pageType = this.pageType;
                this.slidesInfoForm.groupId = this.groupId;
                const data= this.slidesInfoForm

                this.httpPost(url, data, true, true)
                    .then((response) => {
                        this.$refs['slidesInfoForm'].resetFields();
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

    #slides {

    }
    #slides .upload-container {
        margin-bottom: 10px;
        display: flex;
        justify-content: center;
    }

    .slides-block {
        padding-top: 10px;
    }

</style>