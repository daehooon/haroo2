package com.bit189.haroo.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

//@WebFilter("/*")
public class LoginCheckFilter implements Filter {
  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain nextChain)
      throws ServletException, IOException {
    HttpServletRequest httpRequest = (HttpServletRequest) request;

    String servletPath = httpRequest.getServletPath().toLowerCase();

    if (servletPath.endsWith("add") ||   
        servletPath.endsWith("update") ||  
        servletPath.endsWith("delete")) { 

      if (httpRequest.getSession().getAttribute("loginUser") == null) {
        response.setContentType("text/plain;charset=UTF-8");
        response.getWriter().println("로그인 해야 합니다!");
        return;
      }
    }

    nextChain.doFilter(request, response);

  }
}
