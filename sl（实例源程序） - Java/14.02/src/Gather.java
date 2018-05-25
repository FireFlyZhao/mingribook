import java.util.*;

public class Gather { // 创建类Gather
	public static void main(String[] args) { // 主方法
		List<String> list = new ArrayList<>(); // 创建集合对象
		list.add("a"); // 向集合添加元素
		list.add("b");
		list.add("c");
		int i = (int) (Math.random() * (list.size() - 1)); // 获得0~1之间的随机数
		System.out.println("随机获取数组中的元素：" + list.get(i));
		list.remove(2); // 将指定索引位置的元素从集合中移除
		System.out.println("将索引是'2'的元素从数组移除后，数组中的元素是：");
		for (int j = 0; j < list.size(); j++) { // 循环遍历集合
			System.out.println(list.get(j));
		}
	}
}
