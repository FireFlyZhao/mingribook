package chapter.fourteen;

import java.util.*;

public class MapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,String> map = new HashMap<>();
		map.put("01", "��ͬѧ");
		map.put("02", "κͬѧ");
		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		System.out.println("key�����е�Ԫ�أ�");
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		Collection<String> coll = map.values();
		it = coll.iterator();
		System.out.println("values�����е�Ԫ�أ�");
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
