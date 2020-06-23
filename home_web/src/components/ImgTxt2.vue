<template>
  <!--图上带文字-->
  <div id="imgText2" :style="{height: height + 'px'}">
    <div class="img-text-html" :style="{backgroundImage: 'url(' + imgUrl + ')', width: width + '% !important'}" v-html="content">
    </div>
  </div>
</template>

<script>
    export default {
        name: "ImgTxt2",
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
          default: 500
        },
        width: {
          type: Number,
          default: 70
        }
      }
    }
</script>

<style scoped>

  #imgText2 {
    color: #1d1c1c;
    font-size: 18px;
    font-weight: 500;
    height: 400px;
    background-size: 100% 100%;
    transition: all ease 0.6s;
    display: flex;
    justify-content: center;
  }

  .img-text-html {
    height: 100%;
  }

  @media screen and (max-width: 768px) {

    #imgText2 {
      height: 200px;
      transition: all ease 0.6s;
    }

  }

  /* 媒体查询（平板） */
  @media screen and (min-width: 768px) and (max-width: 996px) {

    #imgText2 {
      height: 300px;
    }

  }

</style>
