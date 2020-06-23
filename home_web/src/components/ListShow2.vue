<template>
  <!--标题下面4个框，其中图片+文字说明-->
  <div id="listShow2" v-if="!!this.serviceList && this.serviceList.length > 0">
    <div class="container-fluid">
      <el-row :gutter="10">
        <el-col class="img-wrapper" :xs="12" :sm="8" :md="6" :lg="4" :xl="4" wow slideInUp v-for="(item,index) in serviceList" :key="index" >
          <div class="img-wrapper-item"  @click="ServiceClick(item.id)">
            <div>
              <img :src="item.imgUrl" alt="product">
            </div>
            <div class="img-title">{{item.title}}</div>
          </div>
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
  export default {
    name: "ListShow2",
    props: {
      serviceList:{
        type:Array
      },
      detailDataUrl: {
        type: String
      }
    },
    methods:{
      ServiceClick(id){
        this.$router.push({
          name: 'article',
          params: {
            url: this.detailDataUrl,
            id: id
          }
        })
      }
    }
  }
</script>

<style scoped>

  .listShow2-container {
    margin:5px;
    padding: 5px;
  }

  .el-row {
    background: rgba(244,244,244,1);
    padding: 25px 0;
  }

  .img-wrapper {
    display: flex;
    justify-content: center;
    cursor: pointer;
    padding-bottom: 10px;
    /*height: 200px !important;*/
  }

  .img-wrapper-item {
    display: flex;
    flex-direction: column;
    height: 210px;
  }

  img {
    cursor: pointer;
    border-radius: 5px;
    transition: all 0.5s;
    height: 200px;
    width: 200px;
  }
  img:hover{
    transform: scale(1.1);
  }

  .img-title {
    height: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
    color: #999999;
  }

  @media screen and (max-width: 768px){
    img {
      cursor: pointer;
      border-radius: 5px;
      transition: all 0.5s;
      height: 160px;
      width: 160px ;
    }
    img:hover{
      transform: scale(1.0);
    }

  }


</style>
