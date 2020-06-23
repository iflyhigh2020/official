<template>
  <!--标题下面4个框，其中图标+文字说明-->
  <div id="whyChooseUs" class="conatiner-fuild">
    <div class="container">
      <div class="whyChooseUs-title text-center">
        <!--<p>为什么选择我们的产品</p>
        <p>THE REASON TO CHOOSING US</p>-->
      </div>
      <div class="row">
        <div
          class="col-xs-12 col-sm-6 col-md-3 server-wrapper"
          v-for="(item,index) in serverList"
          :key="index"
        >
          <div
            class="server-block wow slideInUp"
            onmouseenter="this.style.color='#28f';this.style.borderColor='#28f'"
            onmouseleave="this.style.color='#666';this.style.borderColor='#ccc'">
            <img class="center-block" :src="item.imgUrl">
            <p class="text-center">{{item.title}}</p>

          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
    export default {
      name: "ListShow",
      props: {
        serverList: {
          type: Array
        }
      }
    }
</script>

<style scoped>
  /* 为什么选择我们 */
  #whyChooseUs {
    padding: 100px;
  }
  #whyChooseUs .whyChooseUs-title {
    margin-bottom: 50px;
  }
  #whyChooseUs .whyChooseUs-title p:nth-of-type(1) {
    font-size: 25px;
    font-weight: 500;
  }
  #whyChooseUs .whyChooseUs-title p:nth-of-type(2) {
    font-size: 14px;
  }
  #whyChooseUs .server-block {
    padding: 50px 20px;
    border: 1px solid #ccc;
    border-bottom: 5px solid #ccc;
  }
  #whyChooseUs .server-block img {
    width: 48px;
    height: 48px;
  }
  #whyChooseUs .server-block > p {
    font-size: 20px;
    margin: 30px 0;
  }
  #whyChooseUs .server-block > div {
    color: #ccc;
  }

  /* 媒体查询（手机） */
  @media screen and (max-width: 768px) {
    #whyChooseUs {
      padding: 20px 0;
      transition: all ease 0.6s;
    }
    #whyChooseUs .whyChooseUs-title p:nth-of-type(1) {
      font-size: 20px;
      font-weight: 700;
    }
    #whyChooseUs .whyChooseUs-title p:nth-of-type(2) {
      font-size: 12px;
    }
    #whyChooseUs .server-block {
      padding: 50px 0;
      border: 1px solid #ccc;
      border-bottom: 5px solid #ccc;
    }
    #whyChooseUs .server-block img {
      width: 48px;
      height: 48px;
    }
    #whyChooseUs .server-block > p {
      font-size: 20px;
      margin: 30px 0;
    }
    #whyChooseUs .server-block > div {
      color: #ccc;
    }
  }

  /* 媒体查询（平板） */
  @media screen and (min-width: 768px) and (max-width: 996px) {
    #whyChooseUs {
      padding: 20px 0;
    }
  }
</style>
