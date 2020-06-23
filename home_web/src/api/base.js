
export default {
  install(Vue) {

    Vue.prototype.commRouter = "";


    /**
     * 统一get请求
     * @param url
     * @param params
     * @param loadParams
     * @returns {Promise<any>}
     */
    Vue.prototype.httpGet = function(url, params, useLoading) {
      return new Promise((resolve, reject) => {
        this.axios
          .get(url, {
            params: params
          })
          .then(response => {
            if (response.data.code === 0) {
              resolve(response);
            } else if (response.data.code === 1) {
              // this.errorNotice(response.data.value);
            }
          })
          .catch(err => {
            reject(err);
          });
      });
    };

    /**
     * 统一post请求
     * @param url
     * @param params
     * @param loadParams
     * @returns {Promise<any>}
     */
    Vue.prototype.httpPost = function(url, data, useLoading) {
      return new Promise((resolve, reject) => {
        this.axios({
          method: "post",
          url: url,
          headers: {
            "Content-type": "application/json;charset=UTF-8",
            token: this.getLocalToken()
          },
          data: data
        })
          .then(response => {
            if (response.data.code === 2) {
              alert("请登录后操作");
              location.href = "/auth.html/#/login";
            } else if (response.data.code === 0) {
              resolve(response);
            } else if (response.data.code === 1) {
              this.errorNotice(response.data.value);
            }
            closeLoadingInstance(loadingInstance);
          })
          .catch(err => {
            reject(err);
            closeLoadingInstance(loadingInstance);
          });
      });
    };

    /**
     * 根据url参数名取参数值
     *
     * @param name
     * @returns {string}
     */
    Vue.prototype.getQueryString = function(name) {
      const reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
      const r = window.location.search.substr(1).match(reg);
      if (r != null) {
        return unescape(r[2]);
      }
      return "";
    };

  }
};
