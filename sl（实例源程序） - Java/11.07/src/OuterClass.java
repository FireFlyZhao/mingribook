public class OuterClass {
	innerClass in = new innerClass(); // ���ⲿ��ʵ�����ڲ����������
	
	public void ouf() {
		in.inf(); // ���ⲿ�෽���е����ڲ��෽��
	}
	
	class innerClass {
		innerClass() { // �ڲ��๹�췽��
		}
		
		public void inf() { // �ڲ����Ա����
		}
		
		int y = 0; // �����ڲ����Ա����
	}
	
	public innerClass doit() { // �ⲿ�෽��������ֵΪ�ڲ�������
		// y=4; //�ⲿ�಻����ֱ�ӷ����ڲ����Ա����
		in.y = 4;
		return new innerClass(); // �����ڲ�������
	}
	
	public static void main(String args[]) {
		OuterClass out = new OuterClass();
		// �ڲ���Ķ���ʵ���������������ⲿ����ⲿ���еķǾ�̬������ʵ��
		OuterClass.innerClass in = out.doit();
		OuterClass.innerClass in2 = out.new innerClass();
	}
}