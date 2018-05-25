import static java.lang.System.*;

public class EnumIndexTest {
	enum Constants2 { // ������������ö��������
		Constants_A("����ö�ٳ�ԱA"), // �����������ö�����ͳ�Ա
		Constants_B("����ö�ٳ�ԱB"), Constants_C("����ö�ٳ�ԱC"), Constants_D(3);
		private String description;
		private int i = 4;
		
		private Constants2() {
		}
		 // �������ΪString�͵Ĺ��췽��
		private Constants2(String description) {
			this.description = description;
		}
		
		private Constants2(int i) { // �������Ϊ���͵Ĺ��췽��
			this.i = this.i + i;
		}
		
		public String getDescription() { // ��ȡdescription��ֵ
			return description;
		}
		
		public int getI() { // ��ȡi��ֵ
			return i;
		}
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < Constants2.values().length; i++) {
			out.println(Constants2.values()[i] + "����getDescription()����Ϊ��"
					+ Constants2.values()[i].getDescription());
		}
		out.println(Constants2.valueOf("Constants_D") + "����getI()����Ϊ��"
				+ Constants2.valueOf("Constants_D").getI());
	}
}
