package com.listener;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
// �ַ����������
public class CharactorFilter implements Filter {
	// �ַ�����
	String encoding = null;
	@Override
	public void destroy() {
		encoding = null;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// �ж��ַ������Ƿ�Ϊ��
		if(encoding != null){
			// ����request�ı����ʽ
			request.setCharacterEncoding(encoding);
			// ����response�ַ�����
     		response.setContentType("text/html; charset="+encoding);
		}
		// ���ݸ���һ������
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// ��ȡ��ʼ������
		encoding = filterConfig.getInitParameter("encoding");
	}

}
