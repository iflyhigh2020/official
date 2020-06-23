<template>
    <div>
        <el-upload :limit="limit"
                action="/img/imgUpload"
                list-type="picture-card"
                :on-preview="handlePictureCardPreview"
                :on-remove="handleRemove"
                :on-success="uploadSuccess"
                :on-error="uploadError" ref="elUpload">
            <i class="el-icon-plus"></i>
        </el-upload>
        <el-dialog :visible.sync="dialogVisible">
            <img width="100%" :src="dialogImageUrl" alt="">
        </el-dialog>
        <div style="color: #adabab;margin-top: 5px">请上传1M以内的图片,否则无法上传</div>
    </div>
</template>

<script>
    export default {
        name: 'upload',
        props: {
            limit:{
                type:Number,
                default: 1
            },
            source: {//标记父组件
                type: String
            }
        },
        data() {
            return {
                dialogImageUrl: '',
                dialogVisible: false
            };
        },
        methods: {
            handleRemove(file, fileList) {
                // console.log(file, fileList);
            },
            handlePictureCardPreview(file) {
                this.dialogImageUrl = file.url;
                this.dialogVisible = true;
            },
            uploadSuccess(response, file, fileList) {

                //这里换个父组件就不能正常调用了，判断下这个组件是从哪个父组件调用的，区分父组件的方法名。。。
                if (this.source == "Slides") {
                    this.$emit('getImgUrl', response.value)
                } else if (this.source == "ImgText1") {
                    this.$emit('getImgUrl2', response.value)
                } else if (this.source == "ListShow") {
                    this.$emit('getImgUrl3', response.value)
                } else if (this.source == "Banner") {
                    this.$emit('getImgUrl4', response.value)
                } else if (this.source == "Timeline") {
                    this.$emit('getImgUrl5', response.value)
                } else if (this.source == "Footer") {
                    this.$emit('getImgUrl6', response.value)
                } else if (this.source == "Logo") {
                    this.$emit('getImgUrl7', response.value)
                }
            },
            uploadError(err, file, fileList) {

            },
            clear() {
                this.$refs.elUpload.clearFiles();
            }
        }
    }
</script>

<style scoped>
    .content-title{
        font-weight: 400;
        line-height: 50px;
        margin: 10px 0;
        font-size: 22px;
        color: #1f2f3d;
    }
    .pre-img{
        width: 100px;
        height: 100px;
        background: #f8f8f8;
        border: 1px solid #eee;
        border-radius: 5px;
    }
    .crop-demo{
        display: flex;
        align-items: flex-end;
    }
    .crop-demo-btn{
        position: relative;
        width: 100px;
        height: 40px;
        line-height: 40px;
        padding: 0 20px;
        margin-left: 30px;
        background-color: #409eff;
        color: #fff;
        font-size: 14px;
        border-radius: 4px;
        box-sizing: border-box;
    }
    .crop-input{
        position: absolute;
        width: 100px;
        height: 40px;
        left: 0;
        top: 0;
        opacity: 0;
        cursor: pointer;
    }
</style>