<template>
  <!-- 轮播图 -->
  <div id="swiper" :style="{height: height + 'px'}" class="container-fuild">
      <div class="swiper-container banner-swiper" :style="{width: width + '%'}">
        <div class="swiper-wrapper">
          <div class="swiper-slide" v-for="(item,index) in this.swiperList" :key="index">
            <a>
              <img class="swiper-lazy" :data-src="item.imgUrl" alt="轮播图">
            </a>
            <div class="swiper-lazy-preloader"></div>
            <div class="swiper-slide-title">
<!--              <h1>{{item.title}}</h1>-->
<!--              <p>{{item.content}}</p>-->
            </div>
          </div>
        </div>
        <!-- 如果需要分页器 -->
        <div class="swiper-pagination"></div>

        <!-- 如果需要导航按钮 -->
        <div class="swiper-button-prev"></div>
        <div class="swiper-button-next"></div>
      </div>
  </div>
</template>
<script>
import Swiper from "swiper";

export default {
  name: "Slides",
  props: {
      swiperList: {
        type:Array
      },
      height: {
        type:Number,
        default: 200
      },
      width: {
        type: Number,
        default: 100
      }
  },
  data() {
    return {};
  },
  mounted() {
    /* banner-swiper */
    new Swiper(".banner-swiper", {
      loop: true, // 循环模式选项
      effect: 'fade',
      //自动播放
      autoplay: {
        delay: 3000,
        stopOnLastSlide: false,
        disableOnInteraction: false
      },
      // 如果需要分页器
      pagination: {
        el: ".swiper-pagination",
        clickable: true
      },
      // 如果需要前进后退按钮
      navigation: {
        nextEl: ".swiper-button-next",
        prevEl: ".swiper-button-prev"
      },
      // 延迟加载
      lazy: {
        loadPrevNext: true
      },
      observer: true, //修改swiper自己或子元素时，自动初始化swiper
      observeParents: true //修改swiper的父元素时，自动初始化swiper
    });
  }
};
</script>
<style scoped>
  /* 轮播图 */
  #swiper {
    /*height: 300px;*/
  }

  #swiper .banner-swiper {
    width: 100%;
    height: 100%;
  }
  #swiper .banner-swiper .swiper-slide img {
    width: 100%;
    height: 100%;
  }
  #swiper .banner-swiper .swiper-slide{
    position: relative;
  }
  #swiper .banner-swiper .swiper-slide-title {
    /*position: absolute;*/
    /*top: 0;*/
    /*left: 0;*/
    /*z-index: 999999999;*/
    width: 100%;
    height: 100%;
    /*color: #fff;*/
    /*!*background: rgba(51, 51, 51, 0.534);*!*/
    /*text-align: center;*/
    /*line-height: 80px;*/
  }
  #swiper .banner-swiper .swiper-slide-title > h1{
    font-size: 50px;
    margin-top: 12%;
  }
  #swiper .banner-swiper .swiper-slide-title > p{
    font-size: 20px;
    margin-top: 1%;
    font-weight: 700;
  }


  /* 媒体查询（手机） */
  @media screen and (max-width: 768px) {
    #swiper {
      height: 200px !important;
    }
  }


  /* 媒体查询（平板） */
  @media screen and (min-width: 768px) and (max-width: 996px) {
    #swiper {
      height: 400px;
    }
  }
</style>

