<template>
    <div v-html="articleHtml">
    </div>
</template>

<script>
    export default {
      name: "ArticleShow",
      props: {
        pageType: {
          type: Number
        },
        groupId: {
          type: Number
        }
      },
      data() {
        return {
          articleHtml:''
        }
      },
      mounted() {
        this.initArticle();

      },
      methods : {
        initArticle() {
          const url = this.commRouter + '/article/getByType?pageType=' + this.pageType + '&groupId=' + this.groupId;
          this.httpGet(url).then((response) => {
            if (!!response.data.value) {
              this.articleHtml = response.data.value.content;
            }
          }).catch((response) => {
            console.log(response);
          })
        }
      }
    }
</script>

<style scoped>

</style>
