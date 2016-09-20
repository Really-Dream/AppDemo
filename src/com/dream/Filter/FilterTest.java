package com.dream.Filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class FilterTest implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("FIter init");
    }

    @SuppressWarnings("unused")
	@Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpSession session = req.getSession();

        String url = req.getRequestURI();
        if(url.endsWith("first")){
            req.setAttribute("username","new");
            filterChain.doFilter(servletRequest,servletResponse);
            return ;
        }
    }

    @Override
    public void destroy() {
        System.out.println("Filter destory");
    }
}
