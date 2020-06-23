<template>
    <div id="aboutus">
        <el-collapse v-model="activeNames" @change="handleChange" :accordion="true">
            <el-collapse-item class="collapse-header" title="时间轴" name="1">
                <Timeline :page-type="pageType" :group-id="groupId"></Timeline>
            </el-collapse-item>
            <el-collapse-item class="collapse-header" title="公司信息" name="2">
                <Article :submit-url="submitInfo.submitUrl" :page-type="pageType" :group-id="submitInfo.companyGroupId"></Article>
            </el-collapse-item>
            <el-collapse-item class="collapse-header" title="品牌信息" name="3">
                <Article :submit-url="submitInfo.submitUrl" :page-type="pageType" :group-id="submitInfo.brandGroupId"></Article>
            </el-collapse-item>
        </el-collapse>
    </div>
</template>

<script>
    import Timeline from './page_element/Timeline';
    import Article from './page_element/Article';
    export default {
        name: 'Aboutus',
        components: { Article, Timeline },
        data() {
            return {
                activeNames: ['1'],
                pageType: 6,
                groupId: 1,
                submitInfo: {
                    submitUrl:"/article/save",
                    companyGroupId: 1,
                    brandGroupId: 2
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