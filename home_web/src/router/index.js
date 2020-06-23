import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '*',
      redirect: '/'
    }, {
      path: '/',
      name: 'PageView',
      component: resolve => require(['@/view/PageView'], resolve),
      children: [
        {
          path: '/',
          redirect: '/home'
        }, {
          path: '/home',
          name: 'home',
          component: resolve => require(['@/view/HomePage'], resolve),
          /*meta: {
            title: '首页'
          }*/
        }, {
          path: '/cosmetic',
          name: 'cosmetic',
          component: resolve => require(['@/view/Cosmetic'], resolve),
          /*meta: {
            title: '化妆品'
          }*/
        },  {
          path: '/medical',
          name: 'medical',
          component: resolve => require(['@/view/Medical'], resolve),
          /*meta: {
            title: '医用耗材'
          }*/
        },  {
          path: '/sanitary',
          name: 'sanitary',
          component: resolve => require(['@/view/Sanitary'], resolve),
          /*meta: {
            title: '卫生巾用品'
          }*/
        }, {
          path: '/silk',
          name: 'silk',
          component: resolve => require(['@/view/Silk'], resolve),
          /*meta: {
            title: '蚕丝无纺布'
          }*/
        }, {
          path: '/aboutus',
          name: 'aboutus',
          component: resolve => require(['@/view/Aboutus'], resolve),
          /*meta: {
            title: '关于我们'
          },*/
          children: [
            {
              path: '/aboutus',
              redirect: '/aboutus/company'
            },
            /*{
              path: '/aboutus/timeline',
              name: 'timeline',
              component: resolve => require(['@/components/Timeline'], resolve),
              meta: {
                title: '关于我们丨时间轴'
              }
            },*/
            {
              path: '/aboutus/company',
              name: 'company',
              component: resolve => require(['@/components/aboutus/CompanyInfo'], resolve),
              /*meta: {
                title: '关于我们丨公司介绍'
              }*/
            },
            {
              path: '/aboutus/brand',
              name: 'brand',
              component: resolve => require(['@/components/aboutus/BrandInfo'], resolve),
              /*meta: {
                title: '关于我们丨品牌介绍'
              }*/
            }
          ]
        }, {
          path: '/article',
          name: 'article',
          component: resolve => require(['@/components/Article'], resolve),
          /*meta: {
            title: '详情'
          }*/
        }
      ]
    }
  ]
})
