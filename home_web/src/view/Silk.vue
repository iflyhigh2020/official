<template>
  <div>
    <div>
      <ArticleShow :page-type="pageType" :group-id="articleGroupId"></ArticleShow>
    </div>
  </div>
</template>
<script>
  import {WOW} from 'wowjs';
  import ArticleShow from "../components/ArticleShow";

  export default {
    name: 'Silk',
    components: {

      ArticleShow
    },
    mounted() {
      var wow = new WOW();
      wow.init();
    },
    methods: {

    },
    data() {
      return {
        pageType: 5,
        articleGroupId: 1
      }
    }
  }
</script>
<style scoped>

</style>

