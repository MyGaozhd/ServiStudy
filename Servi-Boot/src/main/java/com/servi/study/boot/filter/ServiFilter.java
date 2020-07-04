package com.servi.study.boot.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author servi
 * @date 2020/7/4
 */
public class ServiFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("ServiFilter->自定义filter");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
