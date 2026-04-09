package com.shop.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class AdminAuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false);
        Object adminUser = session != null ? session.getAttribute("adminUser") : null;

        if (adminUser == null) {
            response.sendRedirect(request.getContextPath() + "/admin/login");
            return false;
        }

        return true;
    }
}
