import java.util.*;

public class AnyClass {
	public static void main(String[] args) {
		// ����ArrayList���������������ڵ�ֵ����ΪInteger
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1); // Ϊ���������ֵ
		for (int i = 0; i < a.size(); i++) {
			// ���������ĳ���ѭ����ʾ�����ڵ�ֵ
			System.out.println("��ȡArrayList������ֵ��" + a.get(i));
		}
		// ����HashMap���������������ļ������ֵ���ͷֱ�ΪInteger��String��
		Map<Integer, String> m = new HashMap<Integer, String>();
		for (int i = 0; i < 5; i++) {
			m.put(i, "��Ա" + i); // Ϊ�������������ֵ
		}
		for (int i = 0; i < m.size(); i++) {
			 // ���ݼ�����ȡ��ֵ
			System.out.println("��ȡMap������ֵ" + m.get(i));
		}
		// ����Vector������ʹ�����е�����ΪString��
		Vector<String> v = new Vector<String>();
		for (int i = 0; i < 5; i++) {
			v.addElement("��Ա" + i); // ΪVector�����������
		}
		for (int i = 0; i < v.size(); i++) {
			// ��ʾ�����е�����
			System.out.println("��ȡVector������ֵ" + v.get(i));
		}
	}
}
