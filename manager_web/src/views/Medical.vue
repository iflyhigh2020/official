<template>
    <div id="cosmetic">
        <el-collapse v-model="activeNames" @change="handleChange" :accordion="true">
            <el-collapse-item class="collapse-header" title="Banner1" name="1">
                <Banner :page-type="pageType" :group-id="bannerGroupId1"></Banner>
            </el-collapse-item>
            <el-collapse-item class="collapse-header" title="图文列表1" name="2">
                <ListShow :page-type="pageType" :group-id="listShowGroupId1"></ListShow>
            </el-collapse-item>
            <el-collapse-item class="collapse-header" title="Banner2" name="3">
                <Banner :page-type="pageType" :group-id="bannerGroupId2"></Banner>
            </el-collapse-item>
            <el-collapse-item class="collapse-header" title="图文列表2" name="4">
                <ListShow :page-type="pageType" :group-id="listShowGroupId2"></ListShow>
            </el-collapse-item>
        </el-collapse>
    </div>
</template>

<script>
    import Banner from './page_element/Banner';
    import ListShow from './page_element/ListShow';
    export default {
        name: 'Medical',
        components: { ListShow, Banner },
        data() {
            return {
                activeNames: ['1'],
                pageType: 3,
                bannerGroupId1: 1,
                listShowGroupId1: 1,
                bannerGroupId2: 2,
                listShowGroupId2: 2
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