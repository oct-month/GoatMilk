<template>
  <el-table
    :data="tableData"
    style="width: 45%"
    max-height="750">
    <el-table-column
      fixed
      prop="username"
      label="昵称"
      width="150">
    </el-table-column>
    <!-- <el-table-column
      prop="password"
      label="密码"
      width="120">
    </el-table-column> -->
    <el-table-column
      prop="role"
      label="权限"
      width="120">
    </el-table-column>
    <el-table-column
      fixed="right"
      label="操作"
      width="120">
      <template slot-scope="scope">
        <el-button
          @click.native.prevent="update(scope.$index, tableData)"
          type="text"
          size="small">
          权限升级
        </el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<script>
import axios from 'axios';
axios.defaults.withCredentials = true

  export default {
    methods: {
      update(index, rows) {
        // console.log(rows[index])
        if(this.$store.state.user_role !== "admin"){
          alert("无修改权限")
        }
        const _this = this
        rows[index]["role"] = "admin"
        axios.put('http://goat.oct-month.top/api/power/', rows[index])
          .then(res =>{
            if(res.data.status === "success")
              _this.$alert(rows[index]["username"]+'修改成功','消息',{
                confirmButtonText: '确定',
                callback: action => {
                  // window.location.reload()
                  //动态刷新
                }
              })
        })
      },
    },
    mounted() {
      const that = this
      axios.get('http://goat.oct-month.top/api/power/')
        .then(res => {
          if (res.data.status === "success")
          {
            that.tableData = res.data.data_list
            // console.log(that.tableData);
            //that.changePage(1)
          }
        })
        .catch(error => {
          console.error(error)
        })
    },
    data() {
      return {
        currentTableData:[],
        tableData: [{
          date: '2016-05-03',
          name: '王小虎',
          province: '上海',
          city: '普陀区',
          address: '上海市普陀区金沙江路 1518 弄',
          zip: 200333
        }, {
          date: '2016-05-02',
          name: '王小虎',
          province: '上海',
          city: '普陀区',
          address: '上海市普陀区金沙江路 1518 弄',
          zip: 200333
        }, {
          date: '2016-05-04',
          name: '王小虎',
          province: '上海',
          city: '普陀区',
          address: '上海市普陀区金沙江路 1518 弄',
          zip: 200333
        }, {
          date: '2016-05-01',
          name: '王小虎',
          province: '上海',
          city: '普陀区',
          address: '上海市普陀区金沙江路 1518 弄',
          zip: 200333
        }, {
          date: '2016-05-08',
          name: '王小虎',
          province: '上海',
          city: '普陀区',
          address: '上海市普陀区金沙江路 1518 弄',
          zip: 200333
        }, {
          date: '2016-05-06',
          name: '王小虎',
          province: '上海',
          city: '普陀区',
          address: '上海市普陀区金沙江路 1518 弄',
          zip: 200333
        }, {
          date: '2016-05-07',
          name: '王小虎',
          province: '上海',
          city: '普陀区',
          address: '上海市普陀区金沙江路 1518 弄',
          zip: 200333
        }]
      }
    },
  }
</script>