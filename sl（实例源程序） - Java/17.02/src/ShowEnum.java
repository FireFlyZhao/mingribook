import static java.lang.System.*;

public class ShowEnum {
	enum Constants2 { // ������������ö��������
		Constants_A, Constants_B
	}
	 // ѭ����values()�������ص�����
	public static void main(String[] args) {
		for (int i = 0; i < Constants2.values().length; i++) {
			// ��ö�ٳ�Ա������ӡ
			out.println("ö�����ͳ�Ա������" + Constants2.values()[i]);
		}
	}
}
