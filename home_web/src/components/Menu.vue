<template>
  <div style="height: 100%">
    <!-- 电脑导航 -->
    <div class="row hidden-xs" style="height: 100%">

      <!-- 导航logo -->
      <!--<div class="header-nav-logo col-md-1">
&lt;!&ndash;        <img src="@/assets/img/logo_black.png" width="50px" height="50px">&ndash;&gt;
      </div>-->
      <div class="header-nav-logo col-md-3" style="height: 100% ">
        <!--        <img src="@/assets/img/logo_black.png" width="100%" height="100%">-->
        <img v-if="!!logoInfo" :src="logoInfo.logoUrl" class="logo-img"
             :style="{paddingLeft: logoInfo.paddingLeft + 'px'}">

      </div>
      <div class="col-md-9 header-nav" style="height: 100%;">
        <!-- 导航内容 -->
        <ul class="header-nav-wrapper " style="height: 100%;width:100%;">
          <li
            v-for="(item,index) in navList"
            :key="index"
            :class="index==navIndex?'active':''"
            @click="navClick(index,item.name)"
          >
            <router-link :to="item.path">
              {{item.name}}
              <span v-if="item.children.length>0" class="glyphicon glyphicon-menu-down"></span>
              <i class="underline"></i>
            </router-link>
            <dl v-if="item.children.length>0">
              <dt v-for="(i,n) in item.children" :key="n">
                <router-link :to="i.path">{{i.name}}</router-link>
              </dt>
            </dl>
          </li>
        </ul>
      </div>
    </div>


    <div class="visible-xs phone-menu-wrapper">
      <div class="phone-menu-button">
        <el-row :gutter="0" style="width: 100%;height: 100%">
          <el-col :span="16" class="phone-menu-el-col">
            <router-link to="/home">
              <el-image v-if="!!logoInfo && !!logoInfo.logoUrl" :src="logoInfo.logoUrl" style="width: 100px; height: 58px"  :fit="logoInfo.logoFit">
                <div slot="error" class="image-slot">
                  <!--加载失败不显示-->
                </div>
              </el-image>
            </router-link>
          </el-col>
          <el-col :span="5" class="phone-menu-el-col">

          </el-col>
          <el-col :span="3" class="phone-menu-el-col">
            <div @click="phoneMenu.drawer = true">
              <img src="../assets/icon/phone-menu.png" style="width: 25px;height: auto">
            </div>
          </el-col>
        </el-row>
      </div>
      <el-drawer
        title="菜单"
        :visible.sync="phoneMenu.drawer"
        :direction="phoneMenu.direction"
        :with-header="false"
        :custom-class="phoneMenu.drawerClass"
        :size="phoneMenu.size"
        :show-close="false"
        :modal="true"
        ref="drawer"
      style="width: 100%">

        <div class="el-drawer-menu-info">
          <div class="el-drawer-logo">
            <el-image v-if="!!logoInfo && logoInfo.logoUrl" :src="logoInfo.logoUrl" style="width: 100px; height: 58px;"  :fit="logoInfo.logoFit">
              <div slot="error" class="image-slot">
                <!--加载失败不显示-->
              </div>
            </el-image>
          </div>

          <div class="el-drawer-item-wrapper">

            <div class="el-drawer-item" v-for="(item,index) in navList" :key="index" @click="doCloseDrawer()">
              <router-link :to="item.path">
                <el-row :gutter="0">
                  <el-col :span="5" style="display: flex;justify-content: flex-end;padding-right: 5px">
                    <el-image  :src="item.iconPath" style="width: 16px; height: 16px;"  :fit="logoInfo.logoFit"></el-image>
                  </el-col>
                  <el-col :span="16">
                      {{item.name}}
                  </el-col>
                  <el-col :span="3">
                    <i style="color: white" class="el-icon-arrow-right"></i>
                  </el-col>
                </el-row>
              </router-link>
            </div>
            <div class="el-drawer-wechat">
              <div class="wechat-img">
                <el-image  :src="phoneMenu.wechatImgUrl"  :fit="logoInfo.logoFit">
                  <div slot="error" class="image-slot">
                    <!--加载失败不显示-->
                  </div>
                </el-image>
              </div>
              <div>扫描二维码关注我们</div>
            </div>
            <div class="el-drawer-link">
              <el-row>
                <el-col :span="12">
                  <a :href="phoneMenu.taobaoUrl" target="_blank">
                    <div>
                      <el-image  :src="require('../assets/icon/taobao.png')" style="width: 35px; height: 35px;"  :fit="logoInfo.logoFit">
                        <div slot="error" class="image-slot">
                          <!--加载失败不显示-->
                        </div>
                      </el-image>
                    </div>
                    <div>淘宝店</div>
                  </a>
                </el-col>
                <el-col :span="12">
                  <a :href="phoneMenu.jingdongUrl" target="_blank">
                    <div>
                      <el-image  :src="require('../assets/icon/jingdong.png')" style="width: 35px; height: 35px;"  :fit="logoInfo.logoFit">
                        <div slot="error" class="image-slot">
                          <!--加载失败不显示-->
                        </div>
                      </el-image>
                    </div>
                    <div>京东店</div>
                  </a>
                </el-col>
              </el-row>
            </div>
          </div>
        </div>
      </el-drawer>


    </div>

  </div>


</template>

<script>
  export default {
    name: "Menu",
    props: {
      navList: {
        type: Array
      }
    },
    data() {
      return {
        navIndex: sessionStorage.getItem('navIndex') ? sessionStorage.getItem('navIndex') : 0,
        menuName: "首页",
        menuClass: "glyphicon glyphicon-menu-down",
        logoInfo: {},
        phoneMenu: {
          trigger: "click",
          splitButton: true,
          direction : "ltr",
          drawer: false,
          drawerClass: "menu-drawer",
          logoFit: "contain",
          size: "65%",
          taobaoUrl:"",
          jingdongUrl:"",
          wechatImgUrl:""
        }

      }
    },
    mounted() {
      this.initlogoUrl();
      this.getLinks();
    },
    methods: {
      //隐藏手机端侧边栏
      doCloseDrawer() {
        this.phoneMenu.drawer = false;
      },
      getLinks() {
        const url = this.commRouter + '/rightFooter/getCurrent';
        this.httpGet(url).then((response) => {
          if (!!response.data.value) {
            const footerInfo = response.data.value;
            this.phoneMenu.taobaoUrl = footerInfo.col1;
            this.phoneMenu.jingdongUrl = footerInfo.col2;
            this.phoneMenu.wechatImgUrl = footerInfo.col3;
          }
        }).catch((response) => {
          console.log(response);
        })
      },
      //pc端菜单点击后效果
      navClick(index, name) {
        this.navIndex = index;
        sessionStorage.setItem('navIndex', index)
        this.menuName = name;
      },
      initlogoUrl() {
        const url = this.commRouter + '/logo/getCurrent';
        this.httpGet(url).then((response) => {
          let data = response.data.value;
          if (!!data) {
            if (!!!data.paddingLeft) {
              data.paddingLeft = '30';
            }
            this.logoInfo = data;
          }
        }).catch((response) => {
          console.log(response);
        })
      },
      handleClick() {
        alert('button click');
      }
    }
  }
</script>

<style scoped>
  /* 导航栏 */
  #header .header-nav {
    height: 100%;
  }

  /* 导航栏logo */
  #header .header-nav .header-nav-logo {
    width: 100%;
    height: 100%;
    float: left;
  }

  .logo-img {
    width: auto;
    height: 100%;
    float: left;
  }

  /* 导航栏 导航容器 */
  #header .header-nav-fixed .header-nav-wrapper {
    line-height: 50px;
  }

  #header .header-nav .header-nav-wrapper {
    line-height: 65px;
    float: right;
    margin: 0;
    max-width: 800px;
  }

  /* 导航栏 每个导航 */
  #header .header-nav .header-nav-wrapper > li {
    float: left;
    height: 100%;
    margin: 0 20px;
    position: relative;
  }

  #header .header-nav .header-nav-wrapper > li :hover {
    font-weight: bold;
  }

  /* 导航栏 每个导航下面的 a 链接 */
  #header .header-nav .header-nav-wrapper > li > a {
    color: #000;
    font-size: 15px;
    padding: 15px 0;
    position: relative;
  }

  /* 导航栏 每个导航下面的 a 链接的下划线 */
  #header .header-nav .header-nav-wrapper > li > a > i {
    display: block;
    position: absolute;
    bottom: -2px;
    left: 50%;
    width: 0;
    height: 2px;
    opacity: 0;
    transition: all 0.6s ease;
    background-color: #1e73be;
  }

  /* 导航栏 每个导航下面的 a 链接的右侧小三角 */
  #header .header-nav .header-nav-wrapper > li > a > span {
    font-size: 12px;
    transition: transform ease 0.5s;
  }

  /* 导航栏 每个导航下面的 a 链接 鼠标滑上去的样式 */
  #header .header-nav .header-nav-wrapper > li > a:hover {
    color: #1e73be;
    text-decoration: none;
  }

  /* 导航栏 每个导航下面的 a 链接 鼠标滑上去下划线的样式 */
  #header .header-nav .header-nav-wrapper > li > a:hover .underline {
    opacity: 1;
    width: 100%;
    left: 0;
  }

  /* 导航栏 每个导航下面的 a 链接 鼠标滑上去三角标的样式 */
  #header .header-nav .header-nav-wrapper > li > a:hover span {
    transform: rotate(180deg);
  }

  /* 导航栏 每个导航下面的 a 链接 鼠标点击后的样式 */
  #header .header-nav .header-nav-wrapper > li.active > a {
    color: #1e73be;
    text-decoration: none;
    border-bottom: 2px solid #1e73be;
  }

  /* 导航栏 每个导航下面的二级导航容器 */
  #header .header-nav .header-nav-wrapper > li > dl {
    display: none;
    position: absolute;
    width: 168px;
    top: 80%;
    left: 0;
    z-index: 999999;
    box-shadow: 0 0 3px 1px #ccc;
    background: #fff;
  }

  /* 导航栏 每个导航下面的二级导航容器的每个导航 */
  #header .header-nav .header-nav-wrapper > li > dl > dt {
    width: 100%;
    padding: 10px;
    border-bottom: 1px solid #ccc;
  }

  /* 导航栏 每个导航下面的二级导航容器的每个导航 当鼠标滑上时的样式*/
  #header .header-nav .header-nav-wrapper > li > dl > dt > a:hover {
    text-decoration: none;
  }

  /* 导航栏 滑上一级导航显示二级导航 */
  #header .header-nav .header-nav-wrapper > li:hover dl {
    display: block;
  }

  #header .header-nav .header-nav-wrapper > li > dl > dt:hover {
    cursor: pointer;
    background: #ccc;
  }

  .menu-drawer {
    width: 60% !important;
    /*background-color: #474747;*/
  }
  @media screen and (max-width: 997px) {

    .menu-drawer {
      width: 60% !important;
    }

    .phone-menu-wrapper {
      width: 100%;
      height: 100%;
    }

    .phone-menu-button {
      width: 100%;
      height: 100%;
      display: flex;
      flex-direction: row;
      background-color: #f7f7f7;
    }

    .phone-menu-el-col {
      height: 100%;
      display: flex;
      align-items: center;
      justify-content: center;
    }

    .el-drawer-menu-info {
      height: 100%;
    }

    .el-drawer-item-wrapper {
      height: 100%;
      background-color: #333;
    }

    .el-drawer-item {
      height: 36px;
      border-bottom: 1px solid rgba(0,0,0,.3);
      box-shadow: inset 0 1px 0 rgba(255,255,255,.05);
      text-shadow: 0 1px 0 rgba(0,0,0,.5);

    }

    .el-drawer-item a{
      color: #ccc;
      height: 100%;

      display:flex;
      align-items:center;
    }

    .el-drawer-logo {
      background-color: #f7f7f7;
      display: flex;
      justify-content: center;
    }
    .el-drawer-item .el-row {
      width: 100%;
    }

    .el-drawer-link {
      height: 80px;
      display: flex;
      flex-direction: column;
      align-items: center;
      justify-content: center;
      background-color: whitesmoke;
    }

    .el-drawer-link .el-row{
     width: 100%;
    }

    .el-drawer-link .el-row .el-col {
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;
    }
    .el-drawer-link .el-row .el-col div {
      color: #999999;
    }

    .el-drawer-wechat {
      height: 150px;
      background-color: whitesmoke;
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;
      background-color:#333;
    }

    .el-drawer-wechat div{
      color: whitesmoke;
      font-weight: bold;
    }

    .el-drawer-wechat .wechat-img {
      height: 130px;
      width: 130px;
      display: flex;
      justify-content: center;
      align-items: center;
      background-color:#c5c3c3;
    }

    .el-drawer-wechat .wechat-img .el-image {
      width: 110px;
      height: 110px;
    }

  }
</style>
