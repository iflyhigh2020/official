<template>
  <div id="articleDetail" v-if="!!articleInfo">
    <div class="content-wrap" v-html="articleInfo.content">
    </div>
  </div>
</template>

<script>
  import Layout from '../components/Layout'

  export default {
    name: "Article",
    data() {
      return {
        articleInfo: {}
      }
    },
    created() {
      this.getArticleInfo()
    },
    methods: {
      getArticleInfo() {
        if (!!!this.$route.params.url || !!!this.$route.params.id) {
          this.$router.push({name: 'home'})
          return false;
        }
        const url = this.commRouter + this.$route.params.url + "?id=" + this.$route.params.id;
        this.httpGet(url).then((response) => {
          this.articleInfo = response.data.value

        }).catch((response) => {
          console.log(response)
        })
      }
    },
    components: {
      Layout
    }
  }
</script>

<style scoped>

  #articleDetail {
    width: 100%;
  }

  .content-wrap {
    width: 100%;
  }
  .content-wrap p{
    width: 100%;
  }
  .content-wrap img{
    width: 100%;
  }
</style>
