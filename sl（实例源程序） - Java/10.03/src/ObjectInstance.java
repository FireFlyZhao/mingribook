public class ObjectInstance {
	public String toString() { // ��дtoString()����
		return "��" + getClass().getName() + "������дtoString()����";
	}
	
	public static void main(String[] args) {
		System.out.println(new ObjectInstance()); // ��ӡ�������
	}
}
