<template>
  <div>
    <ArticleShow :page-type="pageType" :group-id="groupId"></ArticleShow>
  </div>
</template>

<script>
  import ArticleShow from "../ArticleShow";
  import {WOW} from 'wowjs';
  export default {
    name: "BrandInfo",
    components: {ArticleShow},
    data() {
      return {
        pageType: 6,
        groupId: 2
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
