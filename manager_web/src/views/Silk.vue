<template>
    <div id="silk">
        <el-collapse v-model="activeNames" @change="handleChange" :accordion="true">
            <el-collapse-item class="collapse-header" title="详情信息" name="1">
                <Article :submit-url="submitInfo.submitUrl" :page-type="pageType" :group-id="submitInfo.groupId"></Article>
            </el-collapse-item>
        </el-collapse>
    </div>
</template>

<script>
    import Article from './page_element/Article';
    export default {
        name: 'Silk',
        components: { Article},
        data() {
            return {
                activeNames: ['1'],
                pageType: 5,
                submitInfo: {
                    submitUrl:"/article/save",
                    groupId: 1
                }
            };
        },
        methods: {
            handleChange(val) {
                console.log(val);
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