import java.io.*;

public class Student { // ������
	public static void main(String args[]) { // ������
		// �����ַ�������
		String content[] = { "�þò���", "�������", "����ϵ" };
		File file = new File("word.txt"); // �����ļ�����
		try {
			FileWriter fw = new FileWriter(file); // ����FileWriter�����
			// ����BufferedWriter�����
			BufferedWriter bufw = new BufferedWriter(fw); 
			for (int k = 0; k < content.length; k++) { // ѭ����������
				bufw.write(content[k]); // ���ַ���������Ԫ��д�뵽�����ļ���
				bufw.newLine(); // �������еĵ���Ԫ���Ե��е���ʽд���ļ�
			}
			bufw.close(); // ��BufferedWriter���ر�
			fw.close(); // ��FileWriter���ر�
		} catch (Exception e) { // �����쳣
			e.printStackTrace();
		}
		try {
			FileReader fr = new FileReader(file); // ����FileReader�����
			// ����BufferedReader�����
			BufferedReader bufr = new BufferedReader(fr);
			String s = null; // �����ַ�������
			int i = 0; // ����int�ͱ���
			// ����ļ����ı�������Ϊnull,�����ѭ��
			while ((s = bufr.readLine()) != null) { 
				i++; // ����������������
				System.out.println("��" + i + "��:" + s); // ����ļ�����
			}
			bufr.close(); // ��FileReader���ر�
			fr.close(); // ��FileReader���ر�
		} catch (Exception e) { // �����쳣
			e.printStackTrace();
		}
	}
}
