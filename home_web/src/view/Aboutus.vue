<template>
  <div id="Software" class="container">
    <div class="row">
      <div id="left" class="col-md-2 col-xs-12 card-wrapper">
        <el-card class="box-card">
          <div v-for="(item,index) in softwareList" :key="index" class="text item card-item">
            <a href="javascript:void(0)" @click="aboutusRouter(item)">{{item.name}}</a>
          </div>
        </el-card>
      </div>
      <div id="right" class="col-md-10 col-xs-12  wow bounceInRight">
        <router-view></router-view>
      </div>
    </div>
  </div>

</template>
<script>
  import {WOW} from 'wowjs';
  import Timeline from "../components/Timeline";
  import ServiceDetail from "./ServiceDetail";

  export default {
    name: 'Aboutus',
    components: {
      ServiceDetail,
      Timeline
    },
    methods: {
      aboutusRouter(data) {
        this.$router.push({
          path: data.path,
        })

      }
    },
    mounted() {
      var wow = new WOW();
      wow.init();
    },
    data() {
      return {
        timelineInfo : {},
        pageType: 6,
        softwareList: [
          /*{
            path: '/aboutus/timeline',
            name: '时间轴'
          },*/
          {
            path: '/aboutus/company',
            name: '公司信息'
          },{
            path: '/aboutus/brand',
            name: '品牌信息'
          }
        ]
      }
    }
  }
</script>

<style scoped>
  #left{
    margin: 50px 0;
  }
  .left-container{
    width: 60%;
    margin: 0 auto;
    border: 1px solid #474747;
    border-radius: 5px;
  }
  .left-container>p{
    text-align: center;
    line-height: 45px;
    padding: 0;
    margin: 0;
    background: #474747;
    color: #fff;
    font-size: 18px;
    font-weight: bold;
  }
  .left-container>li {
    text-align: center;
    height: 38px;
    line-height: 38px;
    margin: 0;
    border-top: 1px solid #474747;
  }
  .left-container>li>a{
    text-decoration: none;
  }
  .left-container>li:hover{
    background: #928989;
  }
  #right{
    padding: 50px 0;
  }

  .card-wrapper {
    height: 100%;
  }

  .card-item {
    /*margin-top: 20px;*/
    border-bottom: #e0dcdc 1px solid;
  }

  .box-card {
    display: flex;
    justify-content: center;
  }


  @media screen and (max-width: 768px){
    #right{
      padding: 15px;
    }
  }


</style>
