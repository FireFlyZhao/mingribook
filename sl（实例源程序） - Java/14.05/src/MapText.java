import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapText { // ������MapText
	public static void main(String[] args) { // ������
		Map<String, String> map = new HashMap<>(); // ��HashMapʵ�ֵ�Map����
		Emp emp = new Emp("351", "����"); // ����Emp����
		Emp emp2 = new Emp("512", "����");
		Emp emp3 = new Emp("853", "��һ");
		Emp emp4 = new Emp("125", "����");
		Emp emp5 = new Emp("341", "����");

		map.put(emp4.getE_id(), emp4.getE_name()); // ��������ӵ�������
		map.put(emp5.getE_id(), emp5.getE_name());
		map.put(emp.getE_id(), emp.getE_name());
		map.put(emp2.getE_id(), emp2.getE_name());
		map.put(emp3.getE_id(), emp3.getE_name());

		Set<String> set = map.keySet(); // ��ȡMap�����е�key���󼯺�
		Iterator<String> it = set.iterator();
		System.out.println("HashMap��ʵ�ֵ�Map���ϣ�����");
		while (it.hasNext()) { // ����Map����
			String str = (String) it.next();
			String name = (String) map.get(str);
			System.out.println(str + " " + name);
		}
		TreeMap<String, String> treemap = new TreeMap<>(); // ����TreeMap���϶���
		treemap.putAll(map); // �򼯺���Ӷ���
		Iterator<String> iter = treemap.keySet().iterator();
		System.out.println("TreeMap��ʵ�ֵ�Map���ϣ�����������");
		while (iter.hasNext()) { // ����TreeMap���϶���
			String str = (String) iter.next(); // ��ȡ�����е�����key����
			String name = (String) treemap.get(str); // ��ȡ�����е�����valuesֵ
			System.out.println(str + " " + name);
		}
	}
}
