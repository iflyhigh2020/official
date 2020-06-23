<template>

    <el-form :model="logoForm" ref="logoForm" label-width="100px" class="demo-logoForm">
        <el-form-item label="Logo图片" prop="logoUrl">
            <Upload @getImgUrl7="initImgUrl" :source="this.$options.name" ref="upload"></Upload>
        </el-form-item>
        <el-form-item label="向右移动像素" prop="paddingLeft">
            <el-input placeholder="请填写数字" v-model="logoForm.paddingLeft"></el-input>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="submit()">提交</el-button>
        </el-form-item>
    </el-form>
</template>

<script>
    import Upload from '../components/Upload';
    export default {
        components: {Upload},
        name: 'Logo',
        data() {
            return {
                logoForm: {
                    logoUrl: "",
                    paddingLeft:""
                }

            }
        },
        methods: {
            initImgUrl(data) {
                this.logoForm.logoUrl = data;
            },
            submit() {
                const url = this.commRouter + '/logo/save';
                const data = this.logoForm;

                this.httpPost(url, data, true, true)
                    .then((response) => {

                    }).catch((error) => {
                    console.log(error)
                });
            }
        }
    };
</script>

<style scoped>

</style>