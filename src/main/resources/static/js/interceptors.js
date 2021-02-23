Vue.prototype.$http=axios;  //给axios配置原型
axios.defaults.baseURL='http://localhost:8080/'; //给axios请求设置访问后台的前缀
axios.defaults.withCredentials = true
//!**************前台拦截器**************

//1 使用axios前置拦截器，让所有的请求都携带uToken
axios.interceptors.request.use(config=>{
    //获取到浏览器里面一直存储的token
    let uToken =  sessionStorage.getItem("uToken");
    if(uToken){
        //给请求头里面添加uToken（后台判断就是取的这个请求头）请求头，并把随机数的token值也设置进去
        config.headers['token']=uToken;
    }
    //1.3 必须要返回这个，才能执行后面代码
    return config;
},error => {
    Promise.reject(error);
});


//2 使用axios设置后置拦截器，处理后台被拦截，没有登录的请求
axios.interceptors.response.use(function (result){
    let data = result.data;
    //只要前台被拦截的请求里面含这个参数，那么就跳转到登录界面
    if(data.msg==="NoUser"){
        location.href = "/index.html";
    }
    return result;
},error => {
    Promise.reject(error);
});

