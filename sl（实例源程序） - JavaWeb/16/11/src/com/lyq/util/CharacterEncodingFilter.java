/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lyq.util;

import java.io.IOException;
import javax.servlet.*;

/**
 *
 * @author Li Zhong Wei
 */
public class CharacterEncodingFilter implements Filter{

    protected String encoding = null;
    protected FilterConfig filterConfig = null;

    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        this.encoding = filterConfig.getInitParameter("encoding");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (encoding != null) {
            request.setCharacterEncoding(encoding);
            response.setContentType("text/html; charset="+encoding);
        }
        chain.doFilter(request, response);
    }

    public void destroy() {
        this.encoding = null;
        this.filterConfig = null;
    }
}
