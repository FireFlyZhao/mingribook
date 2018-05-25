package chapter.fourteen;
	
import java.util.*;

public class Text {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new LinkedList<>();
		for (int i = 1; i <= 100; i++) {
			list.add(new Integer(i));
		}
//		list.remove(new Integer(10));
//		list.remove(10);
		list.remove(list.get(10));
		System.out.println("ok");
		
		Set<String> set = new HashSet<>();
		set.add("a");
        set.add("c");
        set.add("A");
        set.add("a"); 
        set.add("C");
        
        List<String> list2 = new ArrayList<>();
        list2.add("a");
        list2.add("c");
        list2.add("A");
        list2.add("a"); 
        list2.add("C");
        System.out.println(set);
        System.out.println(list2);
        System.out.println(list);
		
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
