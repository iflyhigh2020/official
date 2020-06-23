<template>
  <!-- 左图右文 -->
    <div id="imgText1"  :style="{height: height + 'px', backgroundColor: bgColor}">
      <div class="row img-text-wrapper" :style="{width: width + '%'}">
        <div class="col-xs-12 col-sm-12 col-md-6 wow  banner" >
          <img width="100%" height="100%" :src="imgUrl">
        </div>
        <div class="col-xs-12 col-sm-12 col-md-6"  v-html="content"></div>
      </div>
    </div>
</template>
<script>
  export default {
    name: "ImgTxt1",
      props: {
      imgUrl: {
        type: String
      },
      content: {
        type: String
      },
      bgColor: {
        type: String,
        default: "white"
      },
        height: {
          type: Number,
          default: 400
        },
        width: {
          type: Number,
          default: 80
        }
    }
  }
</script>

<style scoped>
  /* 大数据管理系统 */
  #imgText1 {
    /*padding: 100px;*/
    transition: all ease 0.6s;
    box-sizing: border-box;
    width: 100%;
    display: flex;
    justify-content: center;

    /*height: 600px;*/
  }

  .banner {
    height: 100%;
    /*line-height: 400px;*/
    background-repeat: no-repeat;
    background-size: cover;
    background-attachment: scroll;
    background-position: center center;
  }


  .img-text-wrapper {
    height: 100%;
  }

  /* 媒体查询（手机） */
  @media screen and (max-width: 768px) {
    #imgText1 {
      /*padding: 30px;*/
    }


  }
  /* 媒体查询（平板） */
  @media screen and (min-width: 768px) and (max-width: 996px) {
    #imgText1 {
      padding: 60px;
    }


  }
</style>
