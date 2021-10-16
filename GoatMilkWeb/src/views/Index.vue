<template>
  <h1>
    <el-header>
      <center class="containerh">羊奶粉信息数据库</center>
    </el-header>
    <el-container id="contain">
      <el-aside width="200px" style="background-color: rgb(108, 141, 246)">
        <el-menu :default-openeds="['1']" :default-active="'1-1'">
          <el-menu router style="background-color: rgb(150,  201,  206)">
            <el-submenu
              v-for="(item, index) in $router.options.routes"
              :key="index"
              :index="index"
              v-if="item.show"
            >
                <template slot="title">
                  <i class="el-icon-message"></i>{{ item.name }}
                </template>

                <el-menu-item
                  v-for="(item2, index2) in item.children"
                  :key="index2"
                  :index="item2.path"
                  :class="$route.path == item2.path ? 'is-active' : ''"
                  >{{ item2.name }}</el-menu-item
                >
                <!-- 设置自动高亮 -->
            </el-submenu>
          </el-menu>
        </el-menu>
      </el-aside>

      <!-- <el-container>
    <el-header style="text-align: right; font-size: 12px">
      <el-dropdown>
        <i class="el-icon-setting" style="margin-right: 15px"></i>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item>查看</el-dropdown-item>
          <el-dropdown-item>新增</el-dropdown-item>
          <el-dropdown-item>删除</el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
      <span>王小虎</span>
    </el-header>
  </el-container> -->
      <!--"style="background-color: rgb(228, 101, 146)  -->

      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
  </h1>
</template>

<style scoped>
#background {
  width: 100%;
  height: 100%;
  background: url("../assets/be.jpg");
  background-size: 100% 100%;
  position: fixed;
  top: 0;
  left: 0;
}

#container {
  height: 100%;
  border: 1px solid #601f99;
}
</style>

<script>
export default {
  name: "Other",
};
</script>

<style scoped>
.el-header {
  background-color: #0b53a7;
  color: rgb(250, 240, 240);
  /* line-height: 60px; */
}

.containerh {
  color: rgb(237, 239, 241);
  margin-left: 200px;
}

.el-body {
  background-color: #7331ad;
  color: rgb(241, 237, 237);
  /* line-height: 60px; */
}
</style>