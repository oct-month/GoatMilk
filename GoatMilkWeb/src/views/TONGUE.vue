<template>
  <div class="demo-image__lazy">
    <center>电子舌图谱</center>
      <div class="block" v-for="img in imgs" :key='img.url'>
    <!--循环遍历返回的url，输出图片 -->
    <el-row :gutter="0">
        <el-image
        style="width:300px;height:300px"
        :src='img.url'>
        </el-image>
        <textarea style="width:300px;height:150px" v-model="img.desc">这里是介绍文本</textarea>
        <el-button @click="deletepicture(img.url)" type="primary" icon="el-icon-delete">删除</el-button>
    <!-- 生成图片同时，生成其对应的删除按钮，利用url进行图片识别 -->
    </el-row>
  </div>
  <!-- <el-col :span="16">
      <el-button type="primary" icon="el-icon-plus" size="small" circle @click="callFile()"></el-button> 
  </el-col> -->
  <el-upload
    class="upload-demo"
    ref="upload"
    action="http://goat.oct-month.top/api/tongue/"
    :data="fileForm"
    :on-preview="handlePreview"
    :on-remove="handleRemove"
    :on-success="handleSuccess"
    :file-list="fileList"
    :auto-upload="false">
    <el-button slot="trigger" size="small" type="primary">选取文件</el-button>
    <el-button style="margin-left: 10px;" size="small" type="success" @click="submitUpload">上传到服务器</el-button>
    <div slot="tip" class="el-upload__tip">
      <textarea style="width:300px;height:150px" v-model="fileForm.desc">这里是介绍文本</textarea>
    </div>
  </el-upload>
</div>
</template>

<script>
import axios from 'axios'

  export default {
    data() {
      return {
        fileForm: {
          desc: "",
        },
        fileList: [{}],
        imgs: [
          {
            "url": "https://fuss10.elemecdn.com/a/3f/3302e58f9a181d2509f3dc0fa68b0jpeg.jpeg",
            "desc": "wdnmd"
          },
          {
            "url": "https://fuss10.elemecdn.com/a/3f/3302e58f9a181d2509f3dc0fa68b0jpeg.jpeg",
            "desc": "wdnmd"
          }
          // 'https://fuss10.elemecdn.com/a/3f/3302e58f9a181d2509f3dc0fa68b0jpeg.jpeg',
          // 'https://fuss10.elemecdn.com/1/34/19aa98b1fcb2781c4fba33d850549jpeg.jpeg',
          // 'https://fuss10.elemecdn.com/0/6f/e35ff375812e6b0020b6b4e8f9583jpeg.jpeg',
          // 'https://fuss10.elemecdn.com/9/bb/e27858e973f5d7d3904835f46abbdjpeg.jpeg',
        ]
      }
    },
    methods:{
      deletepicture(row){
         console.log(row);
         if(this.$store.state.user_role !== 'admin'){
          alert("无更改权限，仅管理员可操作");
        }
        const _this = this
        axios.delete('http://goat.oct-month.top/api/tongue/', {
          data: {url: row}
        })
          .then(res => {
            if (res.data.status === "success")
              _this.$alert(row+'删除成功','消息',{
                confirmButtonText: '确定',
                callback: action => {
                  window.location.reload()
                  //动态刷新
                }
              })
        })
        .catch(error => {
          console.error(error);
        })
      },
      callFile () {
        //点击添加图片按钮，触发type:"file"的input标签
        let fileDom = document.querySelector("#file")
        fileDom.click()
      },
      submitUpload() {
        this.$refs.upload.submit();
      },
      handleSuccess(response, file) {
        if (response.status == "success")
        {
          var url = response.data["url"];
          console.log('上传成功：' + url)
        }
      },
      handleRemove(file, fileList) {
        console.log(file, fileList);
      },
      handlePreview(file) {
        console.log(file);
      }
    },
    mounted() {
      const that = this
      axios.get('http://goat.oct-month.top/api/tongue/')
        .then(res => {
          if (res.data.status === "success")
          {
            that.imgs = res.data.data_list;
            // console.log(that.tableData);
          }
        })
        .catch(error => {
          console.error(error)
        })
    },
  }
</script>

<style scoped>
  
</style>
