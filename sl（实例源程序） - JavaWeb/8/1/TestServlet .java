import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class TestServlet extends HttpServlet {
	//��ʼ������
	public void init() throws ServletException {
	}
	//����HTTP Get����
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
	//����HTTP Post����
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
	//����HTTP Put����
	public void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
	//����HTTP Delete����
	public void doDelete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}
	//���ٷ���
	public void destroy() {
		super.destroy();
	}
}
