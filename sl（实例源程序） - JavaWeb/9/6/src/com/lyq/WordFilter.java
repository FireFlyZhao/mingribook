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
 * 非法字符过滤器
 * @author Li Yong Qiang
 */
public class WordFilter implements Filter {
	// 非法字符数组
	private String words[];
	// 字符编码
	private String encoding;
	// 实现Filter接口init()方法
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// 获取字符编码
		encoding = filterConfig.getInitParameter("encoding");
		// 初始化非法字符数组
		words = new String[]{"糟糕","混蛋"};
	}
	// 实现Filter接口doFilter()方法
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// 判断字符编码是否有效
    	if (encoding != null) {
    		// 设置request字符编码
            request.setCharacterEncoding(encoding);
            // 将request转换为重写后的Request对象
            request = new Request((HttpServletRequest) request);
            // 设置response字符编码
            response.setContentType("text/html; charset="+encoding);
        }
		chain.doFilter(request, response);
	}
	// 实现Filter接口destroy()方法
	@Override
	public void destroy() {
		this.words = null;
		this.encoding = null;
	}
	/**
	 * 内部类重写HttpServletRequestWrapper
	 * @author Li Yong Qiang
	 */
	class Request extends HttpServletRequestWrapper{
		// 构造方法
		public Request(HttpServletRequest request) {
			super(request);
		}
		// 重写getParameter()方法
		@Override
		public String getParameter(String name) {
			// 返回过滤后的参数值
			return filter(super.getRequest().getParameter(name));
		}
		// 重写getParameterValues()方法
		@Override
		public String[] getParameterValues(String name) {
			// 获取所有参数值
			String[] values = super.getRequest().getParameterValues(name);
			// 通过循环对所有参数值进行过滤
			for (int i = 0; i < values.length; i++) {
				values[i] = filter(values[i]);
			}
			// 返回过滤后的参数值
			return values;
		}
	}
	/**
	 * 过滤非法字符
	 * @param param 参数值
	 * @return 过滤后的参数值
	 */
	public String filter(String param){
		try {
			// 判断非法字符是否被初始化
			if(words != null && words.length > 0){
				// 循环替换非法字符
				for (int i = 0; i < words.length; i++) {
					// 判断是否包含非法字符
					if(param.indexOf(words[i]) != -1){
						// 将非法字符替换为"****"
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
