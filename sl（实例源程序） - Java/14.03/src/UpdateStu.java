import java.util.*;
public class UpdateStu implements Comparable<Object> {
	String name;
	long id;
	public UpdateStu(String name, long id) {
		this.id = id;
		this.name = name;
	}
	public int compareTo(Object o) {
		UpdateStu upstu = (UpdateStu) o;
		int result = id > upstu.id ? 1 : (id == upstu.id ? 0 : -1);
		return result;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public static void main(String[] args) {
		UpdateStu stu1 = new UpdateStu("��ͬѧ", 01011);
		UpdateStu stu2 = new UpdateStu("��ͬѧ", 01021);
		UpdateStu stu3 = new UpdateStu("��ͬѧ", 01051);
		UpdateStu stu4 = new UpdateStu("��ͬѧ", 01012);
		TreeSet<UpdateStu> tree = new TreeSet<>();
		tree.add(stu1);
		tree.add(stu2);
		tree.add(stu3);
		tree.add(stu4);
		Iterator<UpdateStu> it = tree.iterator();
		System.out.println("Set�����е�����Ԫ�أ�");
		while (it.hasNext()) {
			UpdateStu stu = (UpdateStu) it.next();
			System.out.println(stu.getId() + " " + stu.getName());
		}
		it = tree.headSet(stu2).iterator();
		System.out.println("��ȡǰ�沿�ֵļ��ϣ�");
		while (it.hasNext()) {
			UpdateStu stu = (UpdateStu) it.next();
			System.out.println(stu.getId() + " " + stu.getName());
		}
		it = tree.subSet(stu2, stu3).iterator();
		System.out.println("��ȡ�м䲿�ֵļ���");
		while (it.hasNext()) {
			UpdateStu stu = (UpdateStu) it.next();
			System.out.println(stu.getId() + " " + stu.getName());
		}
	}
}
