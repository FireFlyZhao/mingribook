import java.util.*;

public class UpdateStu {
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<>(); // ����Mapʵ��
		map.put("01", "��ͬѧ"); // �򼯺�����Ӷ���
		map.put("02", "κͬѧ");
		Set<String> set = map.keySet(); // ����Map����������key����ļ���
		Iterator<String> it = set.iterator(); // �������ϵ�����
		System.out.println("key�����е�Ԫ�أ�");
		while (it.hasNext()) { // ��������
			System.out.println(it.next());
		}
		Collection<String> coll = map.values(); // ����Map����������valuesֵ����
		it = coll.iterator();
		System.out.println("values�����е�Ԫ�أ�");
		while (it.hasNext()) { // ��������
			System.out.println(it.next());
		}
	}
}
