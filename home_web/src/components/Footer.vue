<template>
  <!--:style="{background: 'url(' + bgUrl + ')' }"-->
  <div id="footer" class="container-fluid" :style="{background: footerInfo.bgColor}">
    <p class="title">
      {{footerInfo.title}}
    </p>
    <p class="footer-text">
      <span>{{footerInfo.text1}}</span>
    </p>
    <p class="footer-text">
      <span>{{footerInfo.text2}}</span>
    </p>
    <p class="footer-text">
      <span>{{footerInfo.text3}}</span>
    </p>
    <p class="footer-text">
      <span>{{footerInfo.text4}}</span>
    </p>
  </div>
</template>
<script>
export default {
  name: "Footer",
  mounted() {
      this.initFooter()
  },
  methods: {
    initFooter() {
      const url = this.commRouter + '/footer/getCurrentFooter';
      this.httpGet(url).then((response) => {
        if (!!response.data.value) {
          this.footerInfo = response.data.value;
        }
      }).catch((response) => {
        console.log(response);
      })
    }

  },
  data() {
    return {
      footerInfo: {
        bgColor:"#474747",
        textColor:"",
        title:"",
        text1:"",
        text2:"",
        text3:"",
        text4:"",
        text5:""
      }
    };
  }
};
</script>
<style scoped>
#footer {
  width: 100%;
  height: 100%;
  color: #fff;
  /*background: #474747;*/
  overflow: hidden;
  text-align: center;

}

.logo {
  width: 95px;
  height: 45px;
  margin: 50px auto 20px;
}
.title {
  font-size: 25px;
  margin-bottom: 20px;
}
.address_tel_fax {
  color: #d3d3d3;
  font-size: 14px;
  margin: 10px 0;
}
.email_wx {
  color: #d3d3d3;
  font-size: 14px;
}
.copy {
  color: #d3d3d3;
  font-size: 14px;
  margin: 50px 0 10px;
}
@media screen and (max-width: 997px) {
  .title {
    font-size: 20px;
  }
  .address_tel_fax {
    font-size: 12px;
  }
  .email_wx {

  font-size: 12px;
}
.copy {
  font-size: 12px;
  margin: 30px 0 10px;
}
}
</style>

