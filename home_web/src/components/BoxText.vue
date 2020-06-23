<template>
  <div id="BoxText">
    <div class="container">
      <div class="BoxText-container wow pulse">
        <h2>医用耗材说明</h2>
        <p>说明1</p>
        <ol>
          <li>说法萨芬说法萨芬说法萨芬说法萨芬说法萨芬说法萨芬说法萨芬说法萨芬说法萨芬说法萨芬；</li>
          <li>说法萨芬说法萨芬说法萨芬说法萨芬说法萨芬说法萨芬说法萨芬说法萨芬说法萨芬说法萨芬说法萨芬说法萨芬说法萨芬；</li>
          <li>说法萨芬说法萨芬说法萨芬说法萨芬说法萨芬说法萨芬说法萨芬说法萨芬</li>
        </ol>
        <p>说明2</p>
        <ol>
          <li>说法萨芬说法萨芬说法萨芬说法萨芬说法萨芬说法萨芬说法萨芬说法萨芬说法萨芬说法萨芬说法萨芬</li>
          <li>说法萨芬说法萨芬说法萨芬说法萨芬说法萨芬说法萨芬说法萨芬说法萨芬</li>
          <li>说法萨芬说法萨芬说法萨芬说法萨芬说法萨芬说法萨芬说法萨芬说法萨芬；</li>
          <li>精说法萨芬说法萨芬说法萨芬说法萨芬说法萨芬说法萨芬说法萨芬说法萨芬化；</li>
          <li>熟说法萨芬说法萨芬说法萨芬说法萨芬说法萨芬说法萨芬说法萨芬说法萨芬；</li>
          <li>说法萨芬说法萨芬说法萨芬说法萨芬说法萨芬说法萨芬说法萨芬说法萨芬；</li>
          <li>面有丰面有丰面有丰面有丰面有丰面有丰面有丰面有丰面有丰面有丰面有丰面有丰面有丰面有丰面有丰面有丰。</li>
        </ol>
<!--        <button class="center-block btn btn-warning btn-lg">投递简历</button>-->
      </div>
    </div>
  </div>

</template>

<script>
    export default {
        name: "BoxText"
    }
</script>

<style scoped>

  .BoxText-container {
    margin: 100px;
    padding: 30px;
    transition: all ease 0.5s;
    border: 1px dashed salmon;
  }
  .BoxText-container h2{
    color: rgb(255, 102, 19);
    font-weight: bolder;
    text-align: center;
  }
  .BoxText-container p{
    font-size: 20px;
    color: rgb(255, 102, 19);
    font-weight: 700;
  }
  .BoxText-container ol{
    list-style-type: decimal;
    padding-left: 30px;
  }
  .BoxText-container ol>li{
    font-size: 14px;
    line-height: 2.7rem;
  }
  @media screen and (max-width: 997px) {
    .BoxText-container {
      margin: 20px 0;
      padding: 20px;
      border: 1px dashed salmon;
    }
  }
</style>
