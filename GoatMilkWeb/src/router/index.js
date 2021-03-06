import Vue from 'vue'
import VueRouter from 'vue-router'
import Brand from '../views/Brand'
import BrandF from '../views/BrandF'
import Info from '../views/Info'
import InfoF from '../views/InfoF'
import AddInfo from '../views/AddInfo'
import Milk from '../views/Milk'
import AddMilk from '../views/AddMilk'
import Index from '../views/Index'
import AddBrand from '../views/AddBrand'
import BrandUpdate from '../views/BrandUpdate'
import InfoUpdate from '../views/InfoUpdate'
import MilkUpdate from '../views/MilkUpdate'
import BrandFind from '../views/BrandFind'
import InfoFind from '../views/InfoFind'
import MilkFind from '../views/MilkFind'
import Test from '../views/Test'
import login from '../views/login'
import DNA from '../views/DNA'
import AddDNA from '../views/AddDNA'
import DNAFind from '../views/DNAFind'
import DNAUpdate from '../views/DNAUpdate'
import NOSE from '../views/NOSE'
import TONGUE from '../views/TONGUE'
import Power from '../views/Power'

Vue.use(VueRouter)

const routes = [
  {
    path: "/",
    name: "市售羊奶粉",
    component: Index,
    show: true,
    redirect: "/Brand",
    children: [
      {
        path: '/Brand',
        name: '陕西省内',
        component: Brand
      },
      {
        path: '/BrandF',
        name: '陕西省外',
        component: BrandF
      },
      {
        path: '/AddBrand',
        name: '添加产品',
        component: AddBrand
      },
      {
        path: '/BrangFind',
        name: '市售产品快速查询',
        component: BrandFind
      },
      {
        path: '/DNA',
        name: 'DNA数据',
        component: DNA
      },
      {
        path: '/AddDNA',
        name: '添加DNA信息',
        component: AddDNA
      },
      {
        path: '/DNAFind',
        name: 'DNA快速查询',
        component: DNAFind
      },
      {
        path: '/NOSE',
        name: '电子鼻图谱',
        component: NOSE
      },
      {
        path: '/TONGUE',
        name: '电子舌图谱',
        component: TONGUE
      }
    ]
  },
  {
    path: '/BrandUpdate',
    component: BrandUpdate,
    show: false
  },
  {
    path: "/navigation",
    name: "自检羊奶粉",
    component: Index,
    show: true,
    children: [
      {
        path: '/Info',
        name: '陕西省内',
        component: Info
      },
      {
        path: '/InfoF',
        name: '陕西省外',
        component: InfoF
      },
      {
        path: '/AddInfo',
        name: '添加产品',
        component: AddInfo
      },
      {
        path: '/InfoFind',
        name: '快速查询',
        component: InfoFind
      }
    ]
  },
  {
    path: '/InfoUpdate',
    component: InfoUpdate,
    show: false
  },
  {
    path: "/navigation",
    name: "生鲜羊乳",
    component: Index,
    show: true,
    children: [
      {
        path: '/Milk',
        name: '样品信息',
        component: Milk
      },
      {
        path: '/AddMilk',
        name: '添加产品',
        component: AddMilk
      },
      {
        path: '/MilkFind',
        name: '快速查询',
        component: MilkFind
      }
    ]
  },
  {
    path: '/MilkUpdate',
    component: MilkUpdate,
    show: false
  },
  // {
  //   path: "/navigation",
  //   name: "DNA数据",
  //   component: Index,
  //   show: true,
  //   // children:[
  //   //   {
  //   //     path: '/DNA',
  //   //     name: 'DNA数据',
  //   //     component: DNA
  //   //   },
  //   //   {
  //   //     path: '/AddDNA',
  //   //     name: '添加DNA信息',
  //   //     component: AddDNA
  //   //   },
  //   //   {
  //   //     path: '/DNAFind',
  //   //     name: '快速查询',
  //   //     component: DNAFind
  //   //   }
  //   // ]
  // },
  {
    path: '/DNAUpdate',
    component: DNAUpdate,
    show: false
  },
  // {
  //   path: "/navigation",
  //   name: "电子鼻、电子舌图谱",
  //   component: Index,
  //   show: true,
  //   children:[
  //     {
  //       path: '/NOSE',
  //       name: '电子鼻图谱',
  //       component: NOSE
  //     },
  //     {
  //       path: '/TONGUE',
  //       name: '电子舌图谱',
  //       component: TONGUE
  //     }]
  // },
  {
    path: "/navigation",
    name: "产地判断",
    component: Index,
    show: true,
    children: [
      {
        path: '/Test',
        name: '产地判断',
        component: Test
      }]
  },
  {
    path: "/navigation",
    name: "权限管理",
    component: Index,
    show: true,
    children: [
      {
        path: '/Power',
        name: '权限管理',
        component: Power
      }]
  },
  {
    path: "/login",
    name: "login",
    component: login

  }
  , {
    path: "/register",
    name: "register",
    component: () =>
      import("@/views/register.vue")
  },
  {
    path: "/master",
    name: "master",
    component: () =>
      import("@/views/master.vue")
  },
  {
    path: "/about",
    name: "about",
    component: () =>
      import("@/views/About.vue")
  }

]

import axios from "axios";
axios.defaults.withCredentials = true;

const router = new VueRouter({
  mode: 'hash',
  base: process.env.VUE_APP_URL,
  routes
})

router.beforeEach((to, from, next) => {
  if (to.path == "/login" || to.path == "/register") {
    next()
  }
  else if (router.app.$store.state.user_name == '') {
    axios
      .get(process.env.VUE_APP_URL + "/api/account/islogin")
      .then((res) => {
        if (res.data.status === "success") {
          router.app.$store.commit({
            type: "login",
            username: res.data.data.username,
            userrole: res.data.data.role,
          });
          console.log(
            "用户" +
            res.data.data.username +
            "已作为" +
            res.data.data.role +
            "登录"
          );
        }
        else {
          next("/login");
          console.log("未登录");
        }
      })
      .catch((error) => {
        console.log(error);
      });
  }
  next()
})


export default router


// router.beforeEach((to, from, next) => {
//   //登录及注册页面可以直接进入,而主页面需要分情况
//   if (to.path == '/login') {
//     next();
//     console.log(localStorage.s);
//   }
//   else if (to.path == '/register') {
//     next();
//   }
//   else {
//     if (from.path == "/login")//从登录页面可以直接通过登录进入主页面
//     {
//       next();
//     }
//     else {
//       //从/进入,如果登录状态是true，则直接next进入主页面
//       if (localStorage.s === "true") {
//         next();
//         console.log(localStorage['s'])
//       }
//       else {//如果登录状态是false，那么跳转至登录页面,需要登录才能进入主页面
//         next('/login');
//         console.log("需要登录")
//       }
//     }
//   }
// })

