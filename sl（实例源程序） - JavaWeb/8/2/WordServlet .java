public class WordServlet implements Servlet {
	public void destroy() {
		// TODO Auto-generated method stub
	}
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
	}
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		PrintWriter pwt = response.getWriter();
		pwt.println("mingrisoft");
		pwt.close();
	}
}
