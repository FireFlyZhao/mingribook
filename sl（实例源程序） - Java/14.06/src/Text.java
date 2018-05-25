import java.util.*;
public class Text {
	public static void main(String[] args) {
		List<Integer> list = new LinkedList<>();
		for(int i = 1 ;i<=100;i++){
			list.add(new Integer(i));
			}
		list.remove(list.get(10));
		System.out.println("ok");
	}
}
