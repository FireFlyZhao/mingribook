package chapter.fourteen;

import java.util.*;

public class Gather {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		int i = (int)(Math.random()*list.size());
		System.out.println("�����ȡ�����е�Ԫ�أ�" + list.get(i));
		list.remove(2);
		System.out.println("��������'2'��Ԫ�ش������Ƴ��������е�Ԫ���ǣ�");
		for (int j = 0; j < list.size(); j++) {
			System.out.println(list.get(j));
		}
	}

}
