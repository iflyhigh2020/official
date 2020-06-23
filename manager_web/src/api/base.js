import { Loading } from "element-ui";
import { Message } from "element-ui";
export default {
  install(Vue) {

    // Vue.prototype.commRouter = "/comm";
    Vue.prototype.commRouter = "";

    Vue.prototype.LOCAL_AUTH_KEY = "LOCAL_AUTH_KEY";
    Vue.prototype.LOGIN_USER_NAME = "LOGIN_USER_NAME";


    /**
     * 统一get请求
     * @param url
     * @param params
     * @param loadParams
     * @returns {Promise<any>}
     */
    Vue.prototype.httpGet = function(url, params) {
      return new Promise((resolve, reject) => {
        this.axios
          .get(url, {
            headers: {
              token: this.getLocalToken()
            },
            params: params
          })
          .then(response => {
            if (response.data.code === 0) {
              resolve(response);
            } else if (response.data.code === 1) {
              this.$notify({
                title: 'Failure!',
                message: response.data.value,
                type: 'error'
              });
            } else if (response.data.code === 2) {
              this.$notify({
                title: 'Warning!',
                message: '请登录后继续操作',
                type: 'warning'
              });
              this.$router.push('/login');
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
    Vue.prototype.httpPost = function(url, data, useLoading, showNoticeFlag) {
      let loadingInstance;
      //默认使用loading
      if (
          useLoading === undefined ||
          useLoading === null ||
          useLoading === true
      ) {
        loadingInstance = Loading.service({
          fullscreen: true,
          text: "请求中..."
        });
      }
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
            if (response.data.code === 0) {
              resolve(response);
              if (!!showNoticeFlag) {
                this.$notify({
                  title: 'Success!',
                  message: "操作成功！",
                  type: 'success'
                });
              }
            } else if (response.data.code === 1) {
              this.$notify({
                title: 'Warning!',
                message: response.data.value,
                type: 'warning'
              });
            } else if (response.data.code === 2) {
              console.log(11111111111111111111111)
              this.$notify({
                title: 'Warning!',
                message: '请登录后继续操作',
                type: 'warning'
              });
              this.$router.push('/login');
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
     * 获取token值
     *
     * @returns {*}
     */
    Vue.prototype.getLocalToken = function() {
      if (
          sessionStorage.getItem(this.LOCAL_AUTH_KEY) === null ||
          sessionStorage.getItem(this.LOCAL_AUTH_KEY) === undefined
      ) {
        return "";
      }
      return sessionStorage.getItem(this.LOCAL_AUTH_KEY);
    };

    Vue.prototype.logout = function() {
      this.clearLoginInfo();
      this.$router.push('/login');
    };

    Vue.prototype.clearLoginInfo = function() {
      sessionStorage.removeItem(this.LOCAL_AUTH_KEY);
      sessionStorage.removeItem(this.LOGIN_USER_NAME);
    }

    Vue.prototype.getLoginName = function() {
      return sessionStorage.getItem(this.LOGIN_USER_NAME);
    }

    /**
     * 关闭Loading
     * @param loadingInstance
     * @returns {boolean}
     */
    function closeLoadingInstance(loadingInstance) {
      if (loadingInstance === null || loadingInstance === undefined) {
        return false;
      }
      loadingInstance.close();
    }

    /**
     * 提示信息
     * @param value
     */
    Vue.prototype.successNotice = function(value) {
      Message.success({
        message: value,
        duration: 2000,
        center: true
      });
    };
    Vue.prototype.errorNotice = function(value) {
      Message.error({
        message: value,
        duration: 5000,
        showClose: true,
        center: true
      });
    };
    Vue.prototype.warningNotice = function(value) {
      Message.warning({
        message: value,
        duration: 5000,
        showClose: true,
        center: true
      });
    };
    Vue.prototype.infoNotice = function(value) {
      Message.info({
        message: value,
        duration: 3000,
        center: true
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
