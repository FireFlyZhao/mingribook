package chapter.fourteen;

import java.util.*;

public class Muster {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Collection<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			String str = (String) it.next();
			System.out.println(str);
		}
	}

}
