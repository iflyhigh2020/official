<template>
  <!-- 头部整体盒子 -->
  <div id="header" class="container-fuild">

    <Menu :nav-list="this.navList"></Menu>

  </div>
</template>
<script>
  import Menu from "./Menu";
  export default {
    name: "Header",
    components: {
      Menu
    },
    data() {
      return {

        navList: [
          {
            name: "首页",
            path: "/",
            children: [],
            iconPath: require('../assets/icon/phone/home.png')
          },
          {
            name: "化妆品",
            path: "/cosmetic",
            children: [],
            iconPath: require('../assets/icon/phone/huazhuangpin.png')
          },
          {
            name: "医用耗材",
            path: "/medical",
            children: [],
            iconPath: require('../assets/icon/phone/medical.png')
          },
          {
            name: "卫生巾用品",
            path: "/sanitary",
            children: [],
            iconPath: require('../assets/icon/phone/weishengjin.png')
          },
          {
            name: "蚕丝无纺布",
            path: "/silk",
            children: [],
            iconPath: require('../assets/icon/phone/silk.png')
          },
          {
            name: "关于我们",
            path: "/aboutus",
            children: [],
            iconPath: require('../assets/icon/phone/aboutus.png')
          }
        ]
      };
    }
  };
</script>
<style scoped>
  /* 顶部 */
  #header {
    /*background: #f4f4f4;*/
    background: #faf8f8;
    transition: all ease 0.6s;
    height: 58px;
  }

  #header .header-top {
    height: 50px;
    color: #fff;
    font-size: 12px;
    line-height: 50px;
    background: #474747;
  }

  /* 顶部的图标 */
  #header .header-top span {
    margin: 0 8px;
  }
</style>
