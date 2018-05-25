import java.util.*;

public class MutiOverClass<K, V> {
	public Map<K, V> m = new HashMap<K, V>(); // 定义一个集合HashMap实例
	 // 设置put()方法，将对应的键值与键名存入集合对象中
	public void put(K k, V v) {
		m.put(k, v);
	}
	
	public V get(K k) { // 根据键名获取键值
		return m.get(k);
	}
	
	public static void main(String[] args) {
		// 实例化泛型类对象
		MutiOverClass<Integer, String> mu
		= new MutiOverClass<Integer, String>();
		for (int i = 0; i < 5; i++) {
			// 根据集合的长度循环将键名与具体值放入集合中
			mu.put(i, "我是集合成员" + i);
		}
		for (int i = 0; i < mu.m.size(); i++) {
			// 调用get()方法获取集合中的值
			System.out.println(mu.get(i));
		}
	}
}
