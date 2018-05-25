package com.lyq;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
/**
 * �Ƿ��ַ�������
 * @author Li Yong Qiang
 */
public class WordFilter implements Filter {
	// �Ƿ��ַ�����
	private String words[];
	// �ַ�����
	private String encoding;
	// ʵ��Filter�ӿ�init()����
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// ��ȡ�ַ�����
		encoding = filterConfig.getInitParameter("encoding");
		// ��ʼ���Ƿ��ַ�����
		words = new String[]{"���","�쵰"};
	}
	// ʵ��Filter�ӿ�doFilter()����
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// �ж��ַ������Ƿ���Ч
    	if (encoding != null) {
    		// ����request�ַ�����
            request.setCharacterEncoding(encoding);
            // ��requestת��Ϊ��д���Request����
            request = new Request((HttpServletRequest) request);
            // ����response�ַ�����
            response.setContentType("text/html; charset="+encoding);
        }
		chain.doFilter(request, response);
	}
	// ʵ��Filter�ӿ�destroy()����
	@Override
	public void destroy() {
		this.words = null;
		this.encoding = null;
	}
	/**
	 * �ڲ�����дHttpServletRequestWrapper
	 * @author Li Yong Qiang
	 */
	class Request extends HttpServletRequestWrapper{
		// ���췽��
		public Request(HttpServletRequest request) {
			super(request);
		}
		// ��дgetParameter()����
		@Override
		public String getParameter(String name) {
			// ���ع��˺�Ĳ���ֵ
			return filter(super.getRequest().getParameter(name));
		}
		// ��дgetParameterValues()����
		@Override
		public String[] getParameterValues(String name) {
			// ��ȡ���в���ֵ
			String[] values = super.getRequest().getParameterValues(name);
			// ͨ��ѭ�������в���ֵ���й���
			for (int i = 0; i < values.length; i++) {
				values[i] = filter(values[i]);
			}
			// ���ع��˺�Ĳ���ֵ
			return values;
		}
	}
	/**
	 * ���˷Ƿ��ַ�
	 * @param param ����ֵ
	 * @return ���˺�Ĳ���ֵ
	 */
	public String filter(String param){
		try {
			// �жϷǷ��ַ��Ƿ񱻳�ʼ��
			if(words != null && words.length > 0){
				// ѭ���滻�Ƿ��ַ�
				for (int i = 0; i < words.length; i++) {
					// �ж��Ƿ�����Ƿ��ַ�
					if(param.indexOf(words[i]) != -1){
						// ���Ƿ��ַ��滻Ϊ"****"
						param = param.replaceAll(words[i], "****");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return param;
	}
}
