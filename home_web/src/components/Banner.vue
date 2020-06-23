<template>
  <!--  <div :style="{backgroundImage: 'url(' + bgUrl + ')' ,height: height + 'px'}" class="banner container-fuild" >
      <div style="height: 100%;width: 100%" v-html="bannerText"></div>
    </div>-->

  <div id="banner" :style="{height: height + 'px'}">
    <el-image style="width: 100%; height: 100%" :src="bgUrl" :fit="imgFit">
      <div slot="placeholder" class="image-slot">
        加载中<span class="dot">...</span>
      </div>
      <div slot="error" class="image-slot">
        <i class="el-icon-picture-outline"></i>
      </div>
    </el-image>
  </div>
</template>

<script>
  export default {
    name: "Banner",
    data() {
      return {
        imgFit: 'fits'
      }
    },
    props: {
      bgUrl: {
        type: String
      },
      bannerText: {
        type: String
      },
      height: {
        type: Number,
        default: 300
      }
    }
  }
</script>

<style scoped>

  /*  .banner {
      display: flex;
      background-repeat: no-repeat;
      background-size: cover;
      background-attachment: scroll;
      background-position: center center;
    }*/

  @media screen and (max-width: 768px) {
    #banner {
      height: auto !important;
      width: 100% !important;
    }

  }

</style>
