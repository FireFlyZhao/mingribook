public class TrigonometricFunction {
	public static void main(String[] args) {
		// ȡ90�ȵ�����
		System.out.println("90�ȵ�����ֵ��" + Math.sin(Math.PI / 2));
		System.out.println("0�ȵ�����ֵ��" + Math.cos(0)); // ȡ0�ȵ�����
		// ȡ60�ȵ�����
		System.out.println("60�ȵ�����ֵ��" + Math.tan(Math.PI / 3));
		// ȡ2��ƽ������2�̵ķ�����
		System.out.println("2��ƽ������2�̵ķ���ֵ��"
				+ Math.asin(Math.sqrt(2) / 2));
		// ȡ2��ƽ������2�̵ķ�����
		System.out.println("2��ƽ������2�̵ķ�����ֵ��"
				+ Math.acos(Math.sqrt(2) / 2));
		System.out.println("1�ķ�����ֵ��" + Math.atan(1)); // ȡ1�ķ�����
		// ȡ120�ȵĻ���ֵ
		System.out.println("120�ȵĻ���ֵ��" + Math.toRadians(120.0));
		// ȡ��/2�ĽǶ�
		System.out.println("��/2�ĽǶ�ֵ��" + Math.toDegrees(Math.PI / 2));
	}
}
