import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class TestServlet extends HttpServlet {
	//初始化方法
	public void init() throws ServletException {
	}
	//处理HTTP Get请求
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
	//处理HTTP Post请求
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
	//处理HTTP Put请求
	public void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
	//处理HTTP Delete请求
	public void doDelete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}
	//销毁方法
	public void destroy() {
		super.destroy();
	}
}
