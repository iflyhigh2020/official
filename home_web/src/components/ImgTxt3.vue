<template>
  <!--左边文字右边图片，与ImgTxt1相反-->
  <div id="CompanyIntroduction">
    <div class="container">
      <div class="row CompanyIntroduction-container">
        <div class="col-xs-12 col-sm-12 col-md-6">
          {{this.content}}
        </div>
        <div class="col-xs-12 col-sm-12 col-md-6 wow zoomIn">
          <img class="img-responsive center-block" :src="this.imgUrl">
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    name: "ImgTxt3",
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
      }
    }
  }
</script>

<style scoped>
  .row {
    margin-right: 0;
    margin-left: 0;
  }

  .CompanyIntroduction-container {
    padding: 100px 0;
    color: #808080;
    transition: all ease 0.5s;
  }

  .CompanyIntroduction-container > div > p {
    font-size: 14px;
    line-height: 2.5rem;
  }

  @media screen and (max-width: 997px) {
    .CompanyIntroduction-container {
      padding: 10px 0;
      color: #808080;
    }
  }
</style>
