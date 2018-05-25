import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapText { // 创建类MapText
	public static void main(String[] args) { // 主方法
		Map<String, String> map = new HashMap<>(); // 由HashMap实现的Map对象
		Emp emp = new Emp("351", "张三"); // 创建Emp对象
		Emp emp2 = new Emp("512", "李四");
		Emp emp3 = new Emp("853", "王一");
		Emp emp4 = new Emp("125", "赵六");
		Emp emp5 = new Emp("341", "黄七");

		map.put(emp4.getE_id(), emp4.getE_name()); // 将对象添加到集合中
		map.put(emp5.getE_id(), emp5.getE_name());
		map.put(emp.getE_id(), emp.getE_name());
		map.put(emp2.getE_id(), emp2.getE_name());
		map.put(emp3.getE_id(), emp3.getE_name());

		Set<String> set = map.keySet(); // 获取Map集合中的key对象集合
		Iterator<String> it = set.iterator();
		System.out.println("HashMap类实现的Map集合，无序：");
		while (it.hasNext()) { // 遍历Map集合
			String str = (String) it.next();
			String name = (String) map.get(str);
			System.out.println(str + " " + name);
		}
		TreeMap<String, String> treemap = new TreeMap<>(); // 创建TreeMap集合对象
		treemap.putAll(map); // 向集合添加对象
		Iterator<String> iter = treemap.keySet().iterator();
		System.out.println("TreeMap类实现的Map集合，键对象升序：");
		while (iter.hasNext()) { // 遍历TreeMap集合对象
			String str = (String) iter.next(); // 获取集合中的所有key对象
			String name = (String) treemap.get(str); // 获取集合中的所有values值
			System.out.println(str + " " + name);
		}
	}
}
