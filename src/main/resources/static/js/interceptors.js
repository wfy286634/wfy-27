Vue.prototype.$http=axios;  //给axios配置原型（全局使用）
axios.defaults.baseURL='http://localhost:8080/'; //给axios请求设置访问后台的前缀

//!**************前台拦截器**************

//1 使用axios前置拦截器，让所有的请求都携带uToken
axios.interceptors.request.use(config=>{
    //1.1 获取到浏览器里面一直存储的token，并将它放到
    let uToken =  localStorage.getItem("uToken");
    if(uToken){
        //1.2 注意：给请求头里面添加u-token（后台判断就是取的这个请求头）请求头，并把随机数的token值也设置进去
        config.headers['token']=uToken;
    }
    //1.3 必须要返回这个，才能执行后面代码
    return config;
},error => {
    Promise.reject(error);
});

//!**********

//2 使用axios设置后置拦截器，处理后台被拦截，没有登录的请求
axios.interceptors.response.use(function (result){
    let data = result.data;
    //只要前台被拦截的请求里面含这两个参数，那么就跳转到登录界面
    if(!data.success && data.msg==="NoUser"){
        window.location.href = "index.html";
    }
    return result;
},error => {
    Promise.reject(error);
});