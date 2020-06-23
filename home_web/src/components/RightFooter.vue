<template>
  <div v-if="show" id="right-footer">
    <div class="right-footer-pc">
      <ul v-if="!!taobaoUrl" class="icon-wapper">
        <a :href="taobaoUrl" target="_blank">
          <img src="../assets/icon/taobao.png" class="img-responsive img-circle img-thumbnail icon-img"
               alt="Cinque Terre">
        </a>
      </ul>
      <ul v-if="!!jingdongUrl" class="icon-wapper">
        <a :href="jingdongUrl" target="_blank">
          <img src="../assets/icon/jingdong.png" class="img-responsive img-circle img-thumbnail icon-img"
               alt="Cinque Terre">
        </a>
      </ul>
      <ul v-if="!!qqNo" class="icon-wapper">
        <a :href="'tencent://message/?uin=' + qqNo +'&Site=Sambow&Menu=yes'">
          <img src="../assets/icon/qq.png" class="img-responsive img-circle img-thumbnail icon-img" alt="Cinque Terre">
        </a>
      </ul>
      <ul v-if="!!wechatImgUrl" class="icon-wapper">
        <div class="wechat-icon-wapper">
          <el-popover
            placement="left"
            trigger="hover" visible-arrow="true">
            <el-image :src="wechatImgUrl" class="wechat-img">
              <div slot="placeholder" class="image-slot ">
                加载中<span class="dot">...</span>
              </div>
            </el-image>
            <img slot="reference" src="../assets/icon/wechat.png"
                 class="img-responsive img-circle img-thumbnail icon-img" alt="Cinque Terre">
          </el-popover>
        </div>
      </ul>
      <ul v-if="!!weiboUrl" class="icon-wapper">
        <a :href="weiboUrl" target="_blank">
          <img src="../assets/icon/weibo.png" class="img-responsive img-circle img-thumbnail icon-img" alt="Cinque Terre">
        </a>
      </ul>

      <ul class="icon-wapper">
        <div @click="goTop()">
          <img src="../assets/icon/go_top.png" class="img-responsive img-circle img-thumbnail icon-img"
               alt="Cinque Terre">
        </div>
      </ul>
    </div>
    <div class="right-footer-phone">
      <ul class="icon-wapper">
        <div @click="goTop()">
          <img height="" src="../assets/icon/rocket2.png" class="img-responsive img-circle img-thumbnail icon-img"
               alt="Cinque Terre">
        </div>
      </ul>
    </div>


  </div>

</template>

<script>
  export default {
    name: "RightFooter",
    data() {
      return {
        show: false,
        taobaoUrl: "",
        jingdongUrl: "",
        wechatImgUrl: "",
        weiboUrl: "",
        qqNo: ""
      }
    },
    mounted() {
      this.getRightFooterInfo();
    },
    methods: {
      getRightFooterInfo() {
        const url = this.commRouter + '/rightFooter/getCurrent';
        this.httpGet(url).then((response) => {
          if (!!response.data.value) {
            const footerInfo = response.data.value;
            this.taobaoUrl = footerInfo.col1;
            this.jingdongUrl = footerInfo.col2;
            this.wechatImgUrl = footerInfo.col3;
            this.weiboUrl = footerInfo.col4;
            this.qqNo = footerInfo.col5;
            this.show = true;
          }
        }).catch((response) => {
          console.log(response);
        })

      },
      goTop() {
        (function smoothscroll() {
          var currentScroll =
            document.documentElement.scrollTop || document.body.scrollTop;
          if (currentScroll > 0) {
            window.requestAnimationFrame(smoothscroll);
            window.scrollTo(0, currentScroll - currentScroll / 10);
          }
        })();
      }

    }
  }
</script>

<style scoped>
  .right-footer-pc {
    width: 60px;
    height: 412px;
    position: fixed;
    bottom: 10px;
    right: 0px;
    z-index: 100;
  }

  .right-footer-pc ul {
    margin-top: 10px;
    cursor: pointer;
    transition: all 0.6s;
  }
  .right-footer-pc ul :hover {
    transform: scale(1.06);
  }


  ol, ul, li {
    list-style: none;
  }

  .icon-img {
    width: 48px;
    height: 48px;
  }

  .right-footer-phone {
    display: none;
  }

  .wechat-img {
    width: 250px;
    height: 250px;
  }

  /* 媒体查询（手机） */
  @media screen and (max-width: 768px) {
    .right-footer-pc {
      display: none;
    }
    .right-footer-phone {
      display: block;
      width: 50px;
      height: 52px;
      position: fixed;
      bottom: 85px;
      right: 0px;
      z-index: 100;
    }

    .icon-img {
      width: 36px;
      height: 36px;
    }
  }
</style>
