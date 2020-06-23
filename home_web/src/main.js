// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'

/* 路由 */
import router from './router'

import ElementUI from 'element-ui';
import "element-ui/lib/theme-chalk/index.css";
/* axios */
import axios from './api'
import api from './api/api'

import VueAxios from "vue-axios";

Vue.use(VueAxios, axios);

/* swiper */
import 'swiper/dist/css/swiper.min.css';

/* 重置样式 */
import './assets/css/reset.min.css'

/* jquery */
import 'jquery'

/* bootstarp */
import './assets/css/bootstrap.min.css'
import './assets/js/bootstrap.min'

/* animate.css */
import 'animate.css'


/* 头部组件 */
import Header from './components/Header'
Vue.component(Header.name,Header)


/* 尾部组件 */
import Footer from './components/Footer'
Vue.component(Footer.name,Footer)

/* 回到顶部 */
import GoTop from './components/GoTop'
Vue.component(GoTop.name,GoTop)

Vue.config.productionTip = false

import base from './api/base.js'
Vue.use(base);

Vue.use(ElementUI, {
  size: 'small'
});

import moment from "moment";

Vue.filter("dateformat", function(dataStr, pattern = "YYYY-MM-DD HH:mm:ss") {
  return moment(dataStr).format(pattern);
});

router.beforeEach((to, from, next) => {
    if(to.meta.title){
      document.title = to.meta.title
    }
    next();
});


new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
