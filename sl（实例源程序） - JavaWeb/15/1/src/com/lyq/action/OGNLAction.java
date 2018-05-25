package com.lyq.action;
import java.util.Map;
import com.lyq.bean.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * OGNLAction测试
 * @author Li Yongqiang
 */
public class OGNLAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	// 普通属性name
	private String name;
	// 学生对象
	private Student student ;
	// Map类型的request
	Map<String, Object> request;
	// 构造方法
	@SuppressWarnings("unchecked")
	public OGNLAction(){
		// 实例化学生对象
		student = new Student();
		// 对学号赋值
		student.setId(1);
		// 对学生姓名赋值
		student.setName("张三");
		// 对name赋值
		name = "tom";
		// 获取Map类型的request
		request = (Map<String, Object>) ActionContext.getContext().get("request");
	}
	// 请求处理方法
	@Override
	public String execute() throws Exception {
		// 向request添加值
		request.put("info", "request测试");
		// 返回SUCCESS
		return SUCCESS;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
}
