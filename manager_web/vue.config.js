module.exports = {
    baseUrl: './',
    assetsDir: 'static',
    productionSourceMap: false,
    devServer: {
        proxy: {
            '/':{
                target:'http://127.0.0.1:9003',
                changeOrigin:true,
                ws: true,
                secure: false,  // 如果是https接口，需要配置这个参数
                /*pathRewrite:{
                    '/':''
                }*/
            }
        }
    }
}