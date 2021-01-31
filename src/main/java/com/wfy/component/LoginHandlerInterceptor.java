package com.wfy.component;

import com.wfy.utils.RedisUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

@Component
public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Resource
    private RedisUtil redisUtil;

    /*@Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        Object roleId = request.getSession().getAttribute("roleId");
        System.out.println("afterCompletion----" + roleId + " ::: " + request.getRequestURL());
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        Object roleId = request.getSession().getAttribute("roleId");
        System.out.println("postHandle----" + roleId + " ::: " + request.getRequestURL());

    }*/

   @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       /* Object roleId = request.getSession().getAttribute("roleId");
        System.out.println("preHandle----" + roleId + " ::: " + request.getRequestURL());
        if (roleId != null) {
            return true;
        }
        request.getRequestDispatcher("/index.html").forward(request, response);
        return false;*/



        //不拦截路径（登录路径等等）
       List<String> asList = Arrays.asList("/","/User/login","/index.html","/main.html","/saveCustomer.html", "/saveProduct.html",
               "/saveUser.html","/updateCustomer.html","/updateProduct.html","/updateUser.html","/css/main.css","/js/interceptors.js");

       String uri = request.getRequestURI();
       //1.设置放行路径
       if(asList.contains(uri)){
           return true;
       }

       //2.拿到请求头里面的token（如果是第一次登录，那么是没有请求头的）
       String token = request.getHeader("token");
       if(token==null){
           response.setContentType("application/json; charset=utf-8");
           //response.sendRedirect("/index.html");
           //2.1 拦截请求并返回信息给前台 （前台后置拦截器就是根据这里面返回的json数据，来判读并跳转到登录界面）
           response.getWriter().print("{\"success\":false,\"msg\":\"NoUser\"}");
           return false;
       }

       //3、如果有token，那么就根据这个token从redis查询登录用户信息，如果redis里面还没过期，那么就正常放行，没有就进行拦截，并返回信息，叫他重新登录
       String tokenUser = redisUtil.get(token).toString();
       if(tokenUser==null){
           response.setContentType("application/json; charset=utf-8");
          // response.sendRedirect("/index.html");
           response.getWriter().print("{\"success\":false,\"msg\":\"NoUser\"}");
           return false;
       }

       //4.如果没有过期，那么就重新将token和登录用户信息存到redis
       redisUtil.set(token, tokenUser,60*30);
       return true;
    }
}
