<template>
    <div id="home">
        <el-collapse v-model="activeNames" @change="handleChange" :accordion="true">
            <el-collapse-item class="collapse-header" title="轮播图" name="1">
                <div style="height:20px"></div>
                <Slides :page-type="pageType" :group-id="1"></Slides>
            </el-collapse-item>
            <el-collapse-item class="collapse-header" title="左图右文" name="2">
                <div style="height:20px"></div>
                <ImgText1 :page-type="pageType" :group-id="1"></ImgText1>
            </el-collapse-item>
            <el-collapse-item class="collapse-header" title="下图上文" name="3">
                <div style="height:20px"></div>
                <ImgText1 :page-type="pageType" :group-id="2"></ImgText1>
            </el-collapse-item>
            <el-collapse-item class="collapse-header" title="图文列表" name="4">
                <div style="height:20px"></div>
                <ListShow :page-type="pageType" :group-id="1"></ListShow>
            </el-collapse-item>
        </el-collapse>
    </div>
</template>

<script>
    import Slides from './page_element/Slides';
    import ImgText1 from './page_element/ImgText1';
    import ListShow from './page_element/ListShow';
    export default {
        name: 'Home',
        components: { ListShow, ImgText1, Slides },
        data() {
            return {
                activeNames: ['1'],
                pageType: 1
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