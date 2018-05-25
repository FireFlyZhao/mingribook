import java.lang.reflect.*;
public class Main_02 {
	public static void main(String[] args) {
		Example_02 example = new Example_02();
		Class exampleC = example.getClass();
		// ������г�Ա����
		Field[] declaredFields = exampleC.getDeclaredFields();
		for (int i = 0; i < declaredFields.length; i++) {
			Field field = declaredFields[i]; // ������Ա����
			// ��ó�Ա��������
			System.out.println("����Ϊ��" + field.getName());
			Class fieldType = field.getType(); // ��ó�Ա��������
			System.out.println("����Ϊ��" + fieldType);
			boolean isTurn = true;
			while (isTurn) {
				// ����ó�Ա�����ķ���Ȩ��Ϊprivate�����׳��쳣�������������
				try {
					isTurn = false;
					// ��ó�Ա����ֵ
					System.out.println("�޸�ǰ��ֵΪ��" + field.get(example));
					// �жϳ�Ա�����������Ƿ�Ϊint��
					if (fieldType.equals(int.class)) {
						System.out.println("���÷���setInt()�޸ĳ�Ա������ֵ");
						field.setInt(example, 168); // Ϊint�ͳ�Ա������ֵ
						// �жϳ�Ա�����������Ƿ�Ϊfloat��
					} else if (fieldType.equals(float.class)) {
						System.out.println("���÷���setFloat()�޸ĳ�Ա������ֵ");
						// Ϊfloat�ͳ�Ա������ֵ
						field.setFloat(example, 99.9F);
						// �жϳ�Ա�����������Ƿ�Ϊboolean��
					} else if (fieldType.equals(boolean.class)) {
						System.out.println("���÷���setBoolean()�޸ĳ�Ա������ֵ");
						// Ϊboolean�ͳ�Ա������ֵ
						field.setBoolean(example, true);
					} else {
						System.out.println("���÷���set()�޸ĳ�Ա������ֵ");
						// ����Ϊ�������͵ĳ�Ա������ֵ
						field.set(example, "MWQ");
					}
					// ��ó�Ա����ֵ
					System.out.println("�޸ĺ��ֵΪ��" + field.get(example));
				} catch (Exception e) {
					System.out.println("�����ó�Ա����ֵʱ�׳��쳣��"
							+ "����ִ��setAccessible()������");
					field.setAccessible(true); // ����Ϊ�������
					isTurn = true;
				}
			}
			System.out.println();
		}
	}
}