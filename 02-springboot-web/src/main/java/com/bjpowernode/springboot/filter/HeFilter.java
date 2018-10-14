package com.bjpowernode.springboot.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Author 714班
 */
public class HeFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        System.out.println("He Filter 您已进入filter过滤器，您的请求正常，请继续遵规则...");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
