<template>
  <div>
    <center>生鲜羊乳</center>
    <el-table id="myTable" :data="currentTabelData" border style="width: 100%">
      <el-table-column fixed prop="id" label="编号" width="150">
      </el-table-column>
      <el-table-column fixed prop="日期" label="日期" width="150">
      </el-table-column>
      <el-table-column prop="奶站" label="奶站" width="120"> </el-table-column>
      <el-table-column prop="感官" label="感官" width="120"> </el-table-column>
      <el-table-column prop="脂肪" label="脂肪(g/100g)" width="120">
      </el-table-column>
      <el-table-column prop="蛋白质" label="蛋白质(g/100g)" width="130">
      </el-table-column>
      <el-table-column prop="非脂乳固体" label="非脂乳固体(g/100g)" width="160">
      </el-table-column>
      <el-table-column prop="冰点" label="冰点(℃)" width="120">
      </el-table-column>
      <el-table-column prop="酸度" label="酸度(°T)" width="120">
      </el-table-column>
      <el-table-column prop="抗生素" label="抗生素" width="120">
      </el-table-column>
      <el-table-column prop="β-内酰胺酶" label="β-内酰胺酶" width="120">
      </el-table-column>
      <el-table-column prop="酒精试验" label="酒精试验" width="120">
      </el-table-column>
      <el-table-column prop="煮沸试验" label="煮沸试验" width="120">
      </el-table-column>
      <el-table-column prop="DBP" label="DBP(mg/kg)" width="120">
      </el-table-column>
      <el-table-column fixed="right" label="操作" width="100">
        <template slot-scope="scope">
          <el-button @click="edit(scope.row)" type="text" size="small"
            >修改</el-button
          >
          <el-button
            @click="deletemilk(scope.row, scope.$index)"
            type="text"
            size="small"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>
    <el-button style="float: right" @click="exportData">导出</el-button>

    <el-pagination
      background
      layout="prev, pager, next"
      :page-size="page_size"
      :total="tableData.length"
      @current-change="changePage"
    >
    </el-pagination>
  </div>
</template>

<script>
import XLSX from "xlsx";
import FileSaver from "file-saver";
import axios from "axios";
axios.defaults.withCredentials = true;

export default {
  //调用方法
  methods: {
    deletemilk(row, index_) {
      console.log(row);
      if (this.$store.state.user_role !== "admin") {
        alert("无更改权限，仅管理员可操作");
      }
      const _this = this;
      axios
        .delete(
          process.env.VUE_APP_URL +
            "/api/CompanySelfInspectionRawGoatMilkSample/" +
            row.id
        )
        .then((res) => {
          if (res.data.status === "success")
            _this.$alert(row.id + "删除成功", "消息", {
              confirmButtonText: "确定",
              callback: (action) => {
                _this.currentTabelData.splice(index_, 1);
                _this.tableData = _this.tableData.filter(
                  (item) => item.id != row.id
                );
                // window.location.reload()
                //动态刷新
              },
            });
        })
        .catch((error) => {
          console.error(error);
        });
    },
    edit(row) {
      this.$router.push({
        path: "/MilkUpdate",
        query: {
          row: row,
          //跳转到修改页面，利用id查询数据库对应信息显示出来
        },
      });
      //row.id
    },
    changePage(currentPage) {
      var start = this.page_size * (currentPage - 1);
      var end = start + this.page_size;
      this.currentTabelData = this.tableData.slice(start, end);
    },
    exportData() {
      // let table = document.getElementById('currentTabelData');
      // let worksheet = XLSX.utils.table_to_sheet(table);
      // let workbook = XLSX.utils.book_new();
      // XLSX.utils.book_append_sheet(workbook, worksheet, 'sheet');
      // 以上四行也可以直接一行搞定，如果不需要对表格数据进行修改的话
      let workbook = XLSX.utils.table_to_book(
        document.getElementById("myTable")
      );
      try {
        XLSX.writeFile(workbook, "text.xlsx");
      } catch (e) {
        console.log(e, workbook);
      }
    },
  },

  //用于获取后台返回的数据
  // created(){
  //   const _this = this
  //   axios.get('').then(function (resp){
  //     _this.tableData = resp.data.content
  //     _this.total = resp.data.totalElements
  //   })
  // },

  //初始化页面加载的
  mounted() {
    const that = this;
    axios
      .get(
        process.env.VUE_APP_URL + "/api/CompanySelfInspectionRawGoatMilkSample/"
      )
      .then((res) => {
        if (res.data.status === "success") {
          that.tableData = res.data.data_list;
          // console.log(that.tableData);
          that.changePage(1);
        }
      })
      .catch((error) => {
        console.error(error);
      });
  },

  //返回数据
  data() {
    return {
      tableData: [],
      currentTabelData: [],
      page_size: 9,
    };
  },
};
</script>