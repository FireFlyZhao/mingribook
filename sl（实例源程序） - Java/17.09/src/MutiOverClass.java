import java.util.*;

public class MutiOverClass<K, V> {
	public Map<K, V> m = new HashMap<K, V>(); // ����һ������HashMapʵ��
	 // ����put()����������Ӧ�ļ�ֵ��������뼯�϶�����
	public void put(K k, V v) {
		m.put(k, v);
	}
	
	public V get(K k) { // ���ݼ�����ȡ��ֵ
		return m.get(k);
	}
	
	public static void main(String[] args) {
		// ʵ�������������
		MutiOverClass<Integer, String> mu
		= new MutiOverClass<Integer, String>();
		for (int i = 0; i < 5; i++) {
			// ���ݼ��ϵĳ���ѭ�������������ֵ���뼯����
			mu.put(i, "���Ǽ��ϳ�Ա" + i);
		}
		for (int i = 0; i < mu.m.size(); i++) {
			// ����get()������ȡ�����е�ֵ
			System.out.println(mu.get(i));
		}
	}
}
