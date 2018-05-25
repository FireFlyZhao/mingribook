package com.lyq;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
/**
 * ͳ�ƹ�����
 * @author Li YongQiang
 */
public class CountFilter implements Filter {
	// ��������
	private int count;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// ��ȡ��ʼ������
		String param = filterConfig.getInitParameter("count");
		// ���ַ���ת��Ϊint
		count = Integer.valueOf(param);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// ������������
		count ++;
		// ��ServletRequestת����HttpServletRequest
		HttpServletRequest req = (HttpServletRequest) request;
		// ��ȡServletContext
		ServletContext context = req.getSession().getServletContext();
		// ����������ֵ���뵽ServletContext��
		context.setAttribute("count", count);
		// ���´��ݹ�����
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {

	}
}
