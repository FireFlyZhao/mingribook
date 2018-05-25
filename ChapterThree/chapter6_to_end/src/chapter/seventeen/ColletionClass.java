package chapter.seventeen;

import java.util.*;

public class ColletionClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1);
		for (int i = 0; i <a.size(); i++) {
			System.out.println("获取ArrayList容器的值：" + a.get(i));
		}
		
		Map<Integer, String> m = new HashMap<Integer, String>();
		for(int i = 0; i < 5; i++) {
			m.put(i, "成员" + i);
		}
		for(int i = 0; i < m.size(); i++) {
			System.out.println("获取Map容器的值" + m.get(i));
		}
	}

}
