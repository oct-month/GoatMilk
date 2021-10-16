<template>
  <div id="app">
    <router-view></router-view>
  </div>
</template>

<style>
#app {
  height: 100%;
}

.el-header {
  background-color: #b3c0d1;
  color: #333;
  /* line-height: 60px; */
}

.el-aside {
  color: #b3c0d1;
}
</style>

<script>
import axios from "axios";
axios.defaults.withCredentials = true;

export default {
  data() {
    const item = {
      date: "2016-05-02",
      name: "王小虎",
      address: "上海市普陀区金沙江路 1518 弄",
    };
    return {
      tableData: Array(20).fill(item),
    };
  },
  methods: {
    mounted() {
      var that = this;
      axios
        .get(process.env.VUE_APP_URL + "/api/account/islogin")
        .then((res) => {
          if (res.data.status === "success") {
            that.$store.commit({
              type: "login",
              username: res.data.data.username,
              userrole: res.data.data.role,
            });
            // that.$router.replace({ path: "/Brand" });
          } else {
            that.$router.replace({ path: "/login" });
            // console.log(this.$store.state.user_role) // 拿到用户的role
          }
        })
        .catch((error) => {});
    },
  },
};
</script>
