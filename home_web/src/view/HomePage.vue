<template>
  <div id="HomePage">
    <!-- 轮播图 -->
    <Slides v-if="!!slidesInfo.sildesList && slidesInfo.sildesList.length > 0"
            :swiper-list="slidesInfo.sildesList"
            :height="slidesInfo.height"
            :width="slidesInfo.width"
            ></Slides>
    <div v-if="!!homeRouterList && homeRouterList.length > 0" class="home-router-wrapper">
      <el-row :gutter="10" style="width: 100%">
        <el-col :span="6" v-for="(item,index) in homeRouterList" :key="index" >
          <div @click="homeRouter(item.routerPath)">
            <div class="home-router-inner-item">
              <el-image style="width: 45px; height: 45px" :src="item.imgPath" :fit="item.fit"></el-image>
            </div>
            <div style="margin-top: 10px"></div>
            <div class="home-router-inner-item">{{item.title}}</div>
          </div>
        </el-col>
      </el-row>
    </div>
    <ImgTxt1 v-if="!!imgText1Data && !!imgText1Data.imgUrl" :img-url="imgText1Data.imgUrl"
             :content="imgText1Data.content"
              :height="imgText1Data.height"
             :width="imgText1Data.width"
    ></ImgTxt1>
    <div style="margin-top: 10px"></div>
    <ImgTxt2 v-if="!!imgText2Data && !! imgText2Data.imgUrl" :img-url="imgText2Data.imgUrl"
             :content="imgText2Data.content"
             :height="imgText2Data.height"
             :width="imgText2Data.width"
    ></ImgTxt2>
    <div style="margin-top: 10px"></div>
    <ListShow v-if="!!this.serverList && this.serverList.length > 0" :server-list="this.serverList"></ListShow>
  </div>
</template>
<script>

  import Swiper from "swiper";
  import {WOW} from 'wowjs';

  import Slides from '../components/Slides';
  import ImgTxt1 from '../components/ImgTxt1';
  import ImgTxt2 from '../components/ImgTxt2';
  import Slides2 from '../components/Slides2';
  import ListShow from '../components/ListShow';


  export default {
    name: "HomePage",
    components: {
      Slides, ImgTxt1, ImgTxt2, Slides2, ListShow
    },
    data() {
      return {
        slidesInfo: {
          height:0,
          width:0,
          sildesList: [],
        },
        serverList: [],

        imgText1Data:{},
        imgText2Data:{},
        homeRouterList: [
          {
            imgPath:require('../assets/icon/home/cosmetics.png'),
            routerPath:'/cosmetic',
            fit:'fit',
            title:"化妆品"
          },
          {
            imgPath:require('../assets/icon/home/medical.png'),
            routerPath:'/medical',
            fit:'fit',
            title:"医用耗材"
          },
          {
            imgPath:require('../assets/icon/home/weishengjin.png'),
            routerPath:'/sanitary',
            fit:'fit',
            title:"卫生巾"
          },
          {
            imgPath:require('../assets/icon/home/silk.png'),
            routerPath:'/silk',
            fit:'fit',
            title:"蚕丝无纺布"
          }
        ]
      };
    },
    methods: {
      homeRouter(routerPath) {
        this.$router.push({path: routerPath})
      },
      initSildes() {
        this.httpGet(this.commRouter + '/slidesInfo/getSlidesInfo?pageType=1&groupId=1').then((response) => {

          let data = response.data.value;
          if (!!!data.height) {
            data.height = 500;
          }
          if (!!!data.width || window.innerWidth <= 768 ) {
            data.width = 100;
          }
          this.slidesInfo = data;
        }).catch((response) => {
          console.log(response);
        })
      },
      initListShow() {
        this.httpGet(this.commRouter + '/listShow/listShows?pageType=1&groupId=1').then((response) => {
          this.serverList = response.data.value;
        }).catch((response) => {
          console.log(response);
        })
      },
      initImgText1() {
        this.httpGet(this.commRouter + '/imgText/getByType?pageType=1&groupId=1').then((response) => {
          let data = response.data.value;
          if (!!!data.height) {
            data.height = 300;
          }
          if (!!!data.width || window.innerWidth <= 768 ) {
            data.width = 100;
          }
          this.imgText1Data = data;

        }).catch((response) => {
          console.log(response);
        })
      },
      initImgText2() {
        this.httpGet(this.commRouter + '/imgText/getByType?pageType=1&groupId=2').then((response) => {
          let data = response.data.value;
          if (!!!data.height) {
            data.height = 400;
          }
          if (!!!data.width || window.innerWidth <= 768 ) {
            data.width = 100;
          }
          this.imgText2Data = data;
        }).catch((response) => {
          console.log(response);
        })
      },
    },
    mounted() {
      this.initSildes();
      this.initListShow();
      this.initImgText1();
      this.initImgText2();
      /* wowjs动画 */
      var wow = new WOW({
        boxClass: 'wow',
        animateClass: 'animated',
        offset: 0,
        mobile: true,
        live: true
      })
      wow.init();
    }
  };
</script>
<style scoped>
  /* 整体盒子 */
  #HomePage {
    width: 100%;
  }

  #swiper .banner-swiper .swiper-slide img {
    width: 100%;
    height: 100%;
  }

  #swiper .banner-swiper .swiper-slide {
    position: relative;
  }

  #swiper .banner-swiper .swiper-slide-title {
    position: absolute;
    top: 0;
    left: 0;
    z-index: 999999999;
    width: 100%;
    height: 100%;
    color: #fff;
    background: rgba(51, 51, 51, 0.534);
    text-align: center;
    line-height: 80px;
  }

  #swiper .banner-swiper .swiper-slide-title > h1 {
    font-size: 50px;
    margin-top: 12%;
  }

  #swiper .banner-swiper .swiper-slide-title > p {
    font-size: 20px;
    margin-top: 1%;
    font-weight: 700;
  }

  .home-router-wrapper {
    display: none;
  }

  /* 媒体查询（手机） */
  @media screen and (max-width: 768px) {
    .home-router-wrapper {
      display: flex;
      width: 100%;
      justify-content: center;
      align-items: center;
      /*padding-top: 20px;*/
      height: 150px;
      background-color: #fbfbfb;
    }
    .home-router-inner-item {
      display: flex;
      justify-content: center;
      color: #999999;
    }
  }

</style>

