import Vue from 'vue';
import Router from 'vue-router';

Vue.use(Router);

const originalPush = Router.prototype.push
Router.prototype.push = function push(location) {
    return originalPush.call(this, location).catch(err => err)
}

export default new Router({
    routes: [
        {
            path: '/',
            redirect: '/home'
        },
        {
            path: '/',
            component: () => import('../components/common/Home.vue'),
            meta: { title: '自述文件' },
            children: [
                {
                    path: '/home',
                    component: () => import('../views/Home'),
                    meta: { title: '首页' }
                },
                {
                    path: '/cosmetic',
                    component: () => import('../views/Cosmetic'),
                    meta: { title: '化妆品' }
                },
                {
                    path: '/medical',
                    component: () => import('../views/Medical'),
                    meta: { title: '医用耗材' }
                },
                {
                    path: '/sanitary',
                    component: () => import('../views/Sanitary'),
                    meta: { title: '卫生巾用品' }
                },
                {
                    path: '/silk',
                    component: () => import('../views/Silk'),
                    meta: { title: '蚕丝无纺布' }
                },
                {
                    path: '/aboutus',
                    component: () => import('../views/Aboutus'),
                    meta: { title: '关于我们' }
                }
                ,
                {
                    path: '/footer',
                    component: () => import('../views/Footer'),
                    meta: { title: '页面基础元素' }
                }

            ]
        },
        {
            path: '/login',
            component: () => import(/* webpackChunkName: "login" */ '../components/page/Login.vue'),
            meta: { title: '登录' }
        },
        {
            path: '*',
            redirect: '/404'
        }
    ]
});
