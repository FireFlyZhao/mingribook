package com.mingrisoft;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class SaveServlet
 */
@WebServlet(name = "saveServlet",urlPatterns ="/SaveServlet")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Connection con = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
public void init(ServletConfig config) throws ServletException {
	try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//�������ݿ�����
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;" +
					"DatabaseName=db_database09", "sa", "");				//��ȡ���ݿ�����
			if (con != null) {
				System.out.println("���ݿ����ӳɹ�");
							}
			} catch (Exception e) {
				e.printStackTrace();
		}
}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����request��response�ı���
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//��ȡ��������ֵ
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		String question = request.getParameter("question");
		String answer = request.getParameter("answer");
		String email = request.getParameter("email");
		//�ж����ݿ��Ƿ����ӳɹ�
		if (con != null) {
			try {
				//����ע����Ϣ��SQL���(ʹ��?ռλ��)
				String sql = "insert into tb_user(username,password,sex,question,answer,email) "
						+ "values(?,?,?,?,?,?)";
				//����PreparedStatement����
				PreparedStatement ps = con.prepareStatement(sql);
				//��SQL����еĲ�����̬��ֵ
				ps.setString(1, username);
				ps.setString(2, password);
				ps.setString(3, sex);
				ps.setString(4, question);
				ps.setString(5, answer);
				ps.setString(6, email);
				//ִ�и��²���
				ps.executeUpdate();
				//��ȡPrintWriter����
				PrintWriter out = response.getWriter();
				//���ע������Ϣ
				out.print("<h1 aling='center'>");
				out.print(username + "ע��ɹ���");
				out.print("</h1>");
				out.flush();
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			//�������ݿ����Ӵ�����ʾ��Ϣ
			response.sendError(500, "���ݿ����Ӵ���");
		}

	}

}
