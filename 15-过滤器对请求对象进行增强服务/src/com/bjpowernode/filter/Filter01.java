package com.bjpowernode.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by dlkyy on 2021/2/13 23:04
 */
public class Filter01 implements Filter {

  // 通知拦截的请求对象，使用UTF-8字符集对当前请求体信息进行一次重新编辑
  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    servletRequest.setCharacterEncoding("utf-8");// 增强
    filterChain.doFilter(servletRequest, servletResponse); // 放行
  }
}
