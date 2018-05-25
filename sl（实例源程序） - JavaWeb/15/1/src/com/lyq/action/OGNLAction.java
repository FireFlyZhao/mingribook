package com.lyq.action;
import java.util.Map;
import com.lyq.bean.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * OGNLAction����
 * @author Li Yongqiang
 */
public class OGNLAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	// ��ͨ����name
	private String name;
	// ѧ������
	private Student student ;
	// Map���͵�request
	Map<String, Object> request;
	// ���췽��
	@SuppressWarnings("unchecked")
	public OGNLAction(){
		// ʵ����ѧ������
		student = new Student();
		// ��ѧ�Ÿ�ֵ
		student.setId(1);
		// ��ѧ��������ֵ
		student.setName("����");
		// ��name��ֵ
		name = "tom";
		// ��ȡMap���͵�request
		request = (Map<String, Object>) ActionContext.getContext().get("request");
	}
	// ��������
	@Override
	public String execute() throws Exception {
		// ��request���ֵ
		request.put("info", "request����");
		// ����SUCCESS
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
