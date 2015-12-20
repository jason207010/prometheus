package com.web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author jayson  <br/> 2015-12-17 14:37
 * @since v1.0
 */
public class BasePathFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest r = (HttpServletRequest) request;
        String path = r.getScheme() + "://" + r.getServerName() + ":" + r.getServerPort() + r.getContextPath();
        r.setAttribute("path" , path);
        chain.doFilter(request , response);
    }

    @Override
    public void destroy() {

    }
}
