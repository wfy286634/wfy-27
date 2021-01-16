package com.wfy.component;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        Object roleId = request.getSession().getAttribute("roleId");
        System.out.println("afterCompletion----" + roleId + " ::: " + request.getRequestURL());
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        Object roleId = request.getSession().getAttribute("roleId");
        System.out.println("postHandle----" + roleId + " ::: " + request.getRequestURL());

    }

   @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object roleId = request.getSession().getAttribute("roleId");
        System.out.println("preHandle----" + roleId + " ::: " + request.getRequestURL());
        if (roleId != null) {
            return true;
        }
        request.getRequestDispatcher("/index.html").forward(request, response);
        return false;

    }
}
