<template>
  <div>
    <Banner v-if="!!bannerInfo1 && !!bannerInfo1.imgUrl" :bg-url="bannerInfo1.imgUrl" :banner-text="bannerInfo1.content" :height="bannerInfo1.height"></Banner>
    <ListShow2 v-if="!!this.serviceList1 && this.serviceList1.length > 0" :service-list="this.serviceList1" :detail-data-url="detailDataUrl"></ListShow2>

    <Banner v-if="!!bannerInfo2 && !!bannerInfo2.imgUrl" :bg-url="bannerInfo2.imgUrl" :banner-text="bannerInfo2.content" :height="bannerInfo2.height"></Banner>
    <ListShow2 v-if="!!this.serviceList2 && this.serviceList2.length > 0" :service-list="this.serviceList2" :detail-data-url="detailDataUrl"></ListShow2>
  </div>
</template>

<script>
  import Banner from "../components/Banner";
  import ListShow2 from "../components/ListShow2";
  import {WOW} from "wowjs";

  export default {
    name: "Sanitary",

    components: {
      Banner,
      ListShow2
    },
    methods: {
      initBanner1() {
        const url = this.commRouter + '/banner/getByType?pageType=' +this.pageType+ '&groupId=1';
        this.httpGet(url).then((response) => {
          this.bannerInfo1 = response.data.value;
        }).catch((response) => {
          console.log(response);
        })
      },
      initListShow1() {
        const url = this.commRouter + '/listShow/listShows?pageType=' +this.pageType+ '&groupId=1';
        this.httpGet(url).then((response) => {
          this.serviceList1 = response.data.value;
        }).catch((response) => {
          console.log(response);
        })
      },
      initBanner2() {
        const url = this.commRouter + '/banner/getByType?pageType=' +this.pageType+ '&groupId=2';
        this.httpGet(url).then((response) => {
          this.bannerInfo2 = response.data.value;
        }).catch((response) => {
          console.log(response);
        })
      },
      initListShow2() {
        const url = this.commRouter + '/listShow/listShows?pageType=' +this.pageType+ '&groupId=2';
        this.httpGet(url).then((response) => {
          this.serviceList2 = response.data.value;
        }).catch((response) => {
          console.log(response);
        })
      }
    },
    data() {
      return {
        serviceList1: [],
        bannerInfo1: {},
        serviceList2: [],
        bannerInfo2: {},
        pageType: 4,
        detailDataUrl: "/listShow/selectOne"
      }
    },
    mounted() {
      this.initListShow1();
      this.initBanner1();
      this.initListShow2();
      this.initBanner2();
      var wow = new WOW();
      wow.init();
    }
  }
</script>

<style scoped>

</style>
