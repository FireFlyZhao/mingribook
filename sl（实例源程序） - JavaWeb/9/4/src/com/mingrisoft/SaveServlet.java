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
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//加载数据库驱动
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;" +
					"DatabaseName=db_database09", "sa", "");				//获取数据库连接
			if (con != null) {
				System.out.println("数据库连接成功");
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
		//设置request与response的编码
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//获取表单中属性值
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		String question = request.getParameter("question");
		String answer = request.getParameter("answer");
		String email = request.getParameter("email");
		//判断数据库是否连接成功
		if (con != null) {
			try {
				//插入注册信息的SQL语句(使用?占位符)
				String sql = "insert into tb_user(username,password,sex,question,answer,email) "
						+ "values(?,?,?,?,?,?)";
				//创建PreparedStatement对象
				PreparedStatement ps = con.prepareStatement(sql);
				//对SQL语句中的参数动态赋值
				ps.setString(1, username);
				ps.setString(2, password);
				ps.setString(3, sex);
				ps.setString(4, question);
				ps.setString(5, answer);
				ps.setString(6, email);
				//执行更新操作
				ps.executeUpdate();
				//获取PrintWriter对象
				PrintWriter out = response.getWriter();
				//输出注册结果信息
				out.print("<h1 aling='center'>");
				out.print(username + "注册成功！");
				out.print("</h1>");
				out.flush();
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			//发送数据库连接错误提示信息
			response.sendError(500, "数据库连接错误！");
		}

	}

}
