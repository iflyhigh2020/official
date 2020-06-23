<template>
  <div id="app">
    <div class="content">
      <Header></Header>
      <router-view/>
      <RightFooter></RightFooter>
    </div>
    <div class="footer">
      <Footer></Footer>
<!--      <GoTop></GoTop>-->
    </div>

  </div>
</template>

<script>
import RightFooter from "./components/RightFooter";
export default {
  name: 'App',
  components: {RightFooter}
}
</script>

<style>
  /*footer固定在底部*/
  html {
    height: 100%;
  }
  body {
    height: 100%;
  }
  #app {
    min-height: 100%;
    display: flex;
    flex-direction: column;
  }

  .content {
    flex: 1;
  }

  @media screen and (max-width: 768px) {
    img {
      max-width: 100% !important;
      height: auto;
      display: block
    }
  }
</style>
