import java.util.*;

public class Text {
	public static void main(String[] args) {
		Map<String, String> map = new TreeMap<>();
		Emp emp = new Emp("001", "张三");
		Emp emp2 = new Emp("005", "李四");
		Emp emp3 = new Emp("004", "王一");
		Emp emp4 = new Emp("010", "王一");
		Emp emp5 = new Emp("015", "王一");
		map.put(emp.getE_id(), emp.getE_name());
		map.put(emp2.getE_id(), emp2.getE_name());
		map.put(emp3.getE_id(), emp3.getE_name());
		map.put(emp4.getE_id(), emp4.getE_name());
		map.put(emp5.getE_id(), emp5.getE_name());
		map.remove("015");
		for (String string : map.keySet()) {
			System.out.println(map.get(string));
		}
	}
}
