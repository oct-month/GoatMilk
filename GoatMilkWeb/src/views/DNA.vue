<template>
  <div>
    <center>DNA数据</center>
    <el-table id="myTable" :data="currentTabelData" border style="width: 70%">
      <el-table-column fixed prop="id" label="编号" width="150">
      </el-table-column>
      <el-table-column fixed prop="Abs260" label="Abs260" width="150">
      </el-table-column>
      <el-table-column fixed prop="Abs280" label="Abs280" width="150">
      </el-table-column>
      <el-table-column fixed prop="Abs260_280" label="260/280" width="150">
      </el-table-column>
      <el-table-column
        fixed
        prop="DNA_content"
        label="DNA浓度（ng/ul)"
        width="150"
      >
      </el-table-column>
      <el-table-column fixed="right" label="操作" width="100">
        <template slot-scope="scope">
          <el-button @click="edit(scope.row)" type="text" size="small"
            >修改</el-button
          >
          <el-button
            @click="deleteDNA(scope.row, scope.$index)"
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
import axios from "axios";
axios.defaults.withCredentials = true;

export default {
  methods: {
    deleteDNA(row, index_) {
      console.log(row);
      if (this.$store.state.user_role !== "admin") {
        alert("无更改权限，仅管理员可操作");
      }
      const _this = this;
      axios
        .delete(process.env.VUE_APP_URL + "/api/GoatDNAContent/" + row.id)
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
              },
            });
        })
        .catch((error) => {
          console.error(error);
        });
    },
    edit(row) {
      this.$router.push({
        path: "/DNAUpdate",
        query: {
          row: row,
        },
      });
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

  mounted() {
    const that = this;
    axios
      .get(process.env.VUE_APP_URL + "/api/GoatDNAContent/")
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

<style scoped>
</style>