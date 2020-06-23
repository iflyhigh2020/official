<template>
    <div id="timeline">
        <el-divider>上传背景图</el-divider>
        <div class="upload-container">
            <Upload @getImgUrl5="initImgUrl" :source="this.$options.name"  ref="upload"></Upload>
        </div>
        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
            <el-form-item label="标题" prop="title">
                <el-input v-model="ruleForm.title"></el-input>
            </el-form-item>
            <el-form-item label="英文标题" prop="titleEn">
                <el-input v-model="ruleForm.titleEn"></el-input>
            </el-form-item>
            <el-form-item label="背景色" prop="bgColor">
<!--                <el-input v-model="ruleForm.bgColor"></el-input>-->
                <el-color-picker v-model="ruleForm.bgColor" size="medium"></el-color-picker>

            </el-form-item>
            <el-divider>添加时间轴信息</el-divider>

            <div id="dynamicForm">
                <el-form-item
                        v-for="(detail, index) in ruleForm.detailList"
                        :label="'节点' + index"
                        :key="detail.key"
                        :prop="'detailList.' + index + '.value'">
                    <div class="single-container">
                        <div class="block">
                            <!--                        <span class="demonstration">日期</span>-->
                            <el-date-picker
                                    v-model="detail.dateNode"
                                    type="date"
                                    placeholder="选择日期">
                            </el-date-picker>
                        </div>
                        <div class="block">
                            <el-input v-model="detail.title" placeholder="标题"></el-input>
                        </div>
                        <div class="block">
                            <el-input type="textarea" v-model="detail.content" placeholder="内容"></el-input>
                        </div>
                        <div class="block">
                            <el-button @click.prevent="removeDomain(detail)">删除</el-button>
                        </div>
                    </div>

                </el-form-item>
            </div>

            <el-form-item>
                <el-button @click="addDomain">新增节点</el-button>
                <el-button type="primary" @click="submit('ruleForm')">提交</el-button>
                <el-button @click="resetForm('ruleForm')">重置</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
    import Upload from '../components/Upload';

    export default {
        name: 'Timeline',
        components: {Upload},
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
                    activeFlag: 1,
                    pageType:0,
                    groupId: 0,
                    detailList: [
                        {
                            dateNode: null,
                            title: '',
                            content:''
                        }
                    ],
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
                const url = this.commRouter + '/timeline/save';
                this.ruleForm.pageType = this.pageType;
                this.ruleForm.groupId = this.groupId;
                const data= this.ruleForm
/*                if (!!!this.ruleForm.imgUrl) {
                    alert("请上传图片");
                    return false;
                }*/
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
            },
            removeDomain(item) {
                var index = this.ruleForm.detailList.indexOf(item)
                if (index !== -1) {
                    this.ruleForm.detailList.splice(index, 1)
                }
            },
            addDomain() {
                this.ruleForm.detailList.push({
                    value: '',
                    key: Date.now()
                });
            }
        }
    };
</script>

<style scoped>
    #timeline .upload-container {
        margin-bottom: 10px;
        display: flex;
        justify-content: center;
    }


    #dynamicForm .single-container {
        border: 1px solid #409eff;
        border-radius: 5px;
        padding: 10px;
    }

    #dynamicForm .block {
        margin-top: 10px;
    }
</style>