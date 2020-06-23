<template>
  <div id="slides" class="container-fuild">
    <div class="container slides-container">
      <p class="slides-title text-center">产品介绍</p>
      <div class="swiper-container slides-swiper hidden-xs">
        <div class="swiper-wrapper">
          <div class="swiper-slide slides-block" v-for="(item,index) in slidesList" :key="index">
            <div class="slides-logo">
              <img class="center-block" :src="item.imgUrl">
            </div>

            <div class="slides-content1 text-center">
              <small>{{item.content}}</small>
            </div>
            <div class="slides-content2 text-center">{{item.title}}</div>
          </div>
        </div>
        <!-- 如果需要导航按钮 -->
        <div class="swiper-button-prev"></div>
        <div class="swiper-button-next"></div>
      </div>
      <div class="row visible-xs slides-block">
        <div class="col-xs-12" v-for="(item,index) in slidesList" :key="index">
          <div class="slides-logo">
            <img class="center-block" :src="item.imgUrl">
          </div>

          <div class="slides-content1">
            <small>{{item.content}}</small>
          </div>
          <div class="slides-content2">
            <small>{{item.title}}</small>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
    import Swiper from "swiper";

    export default {
      name: "Slides2",
      props: {
        slidesList: {
          type: Array
        }
      },

      mounted() {
        /* slides-swiper */
        new Swiper(".slides-swiper", {
          loop: true, // 循环模式选项
          slidesPerView: 3,
          //自动播放
          autoplay: {
            delay: 3000,
            stopOnLastSlide: false,
            disableOnInteraction: false
          },
          // 如果需要前进后退按钮
          navigation: {
            nextEl: ".swiper-button-next",
            prevEl: ".swiper-button-prev"
          },
          observer: true, //修改swiper自己或子元素时，自动初始化swiper
          observeParents: true //修改swiper的父元素时，自动初始化swiper
        });
      }
    }
</script>

<style scoped>
  /* 客户评价 */
  #slides {
    padding: 50px 0;
    box-sizing: border-box;
    background: #efefef;
    transition: all ease 0.6s;
  }
  #slides .slides-title {
    font-size: 30px;
    color: rgb(102, 102, 102);
    margin: 0 0 30px;
  }
  #slides .slides-block {
    background: #fff;
    padding: 30px;
  }
  #slides .slides-logo img {
    width: 94px;
    height: 94px;
    border: 1px solid #ccc;
  }
  #slides .slides-yh img {
    width: 34px;
    height: 34px;
  }
  #slides .slides-content1 {
    padding-bottom: 20px;
    border-bottom: 1px solid #0ce9f1;
  }
  #slides .slides-content2 {
    padding-top: 20px;
  }

  /* 媒体查询（手机） */
  @media screen and (max-width: 768px) {

    #slides {
      padding: 30px 0;
      box-sizing: border-box;
      background: #fff;
    }

    #slides .slides-title {
      font-size: 16px;
      font-weight: bold;
    }

    #slides .slides-logo img {
      width: 48px;
      height: 48px;
    }

    #slides .slides-block {
      padding: 30px;
    }

    #slides .slides-block > div {
      padding: 30px 0;
    }
  }

  /* 媒体查询（平板） */
  @media screen and (min-width: 768px) and (max-width: 996px) {
    #slides .slides-title {
      font-size: 24px;
    }
  }
</style>
