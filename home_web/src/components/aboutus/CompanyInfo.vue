<template>
  <div>
    <ArticleShow :page-type="pageType" :group-id="groupId"></ArticleShow>
  </div>
</template>

<script>
  import ArticleShow from "../ArticleShow";
  import {WOW} from 'wowjs';
  export default {
    name: "CompanyInfo",
    components: {ArticleShow},
    data() {
      return {
        pageType: 6,
        groupId: 1
      }
    },
    mounted() {
      var wow = new WOW();
      wow.init();
    }
  }
</script>

<style scoped>

</style>
