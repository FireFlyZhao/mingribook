import java.io.*;

public class FileTest { // ������FileTest
	public static void main(String[] args) { // ������
		File file = new File("word.txt"); // �����ļ�����
		if (file.exists()) { // ������ļ�����
			file.delete(); // ���ļ�ɾ��
			System.out.println("�ļ���ɾ��"); // �������ʾ��Ϣ
		} else { // ����ļ�������
			try { // try���鲶׽���ܳ��ֵ��쳣
				file.createNewFile(); // �������ļ�
				System.out.println("�ļ��Ѵ���"); // �������ʾ��Ϣ
			} catch (Exception e) { // catch������쳣
				e.printStackTrace(); // ����쳣��Ϣ
			}
		}
	}
}
