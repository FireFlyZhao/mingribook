import java.io.*;

public class FileTest { // ������
	public static void main(String[] args) {
		File file = new File("word.txt"); // �����ļ�����
		if (file.exists()) { // ����ļ�����
			String name = file.getName(); // ��ȡ�ļ�����
			long length = file.length(); // ��ȡ�ļ�����
			boolean hidden = file.isHidden(); // �ж��ļ��Ƿ��������ļ�
			System.out.println("�ļ����ƣ�" + name); // �����Ϣ
			System.out.println("�ļ������ǣ�" + length);
			System.out.println("���ļ��������ļ���" + hidden);
		} else { // ����ļ�������
			System.out.println("���ļ�������"); // �����Ϣ
		}
	}
}
