import java.io.*;
import java.util.zip.*;

public class MyZip { // ������
	private void zip(String zipFileName, File inputFile) throws Exception {
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(
				zipFileName)); // ����ZipOutputStream�����
		zip(out, inputFile, ""); // ���÷���
		System.out.println("ѹ���С�"); // �����Ϣ
		out.close(); // �����ر�
	}
	
	private void zip(ZipOutputStream out, File f, String base)
			throws Exception { // ��������
		if (f.isDirectory()) { // ���Դ˳���·������ʾ���ļ��Ƿ���һ��Ŀ¼
			File[] fl = f.listFiles(); // ��ȡ·������
			out.putNextEntry(new ZipEntry(base + "/")); // д���Ŀ¼��entry
			base = base.length() == 0 ? "" : base + "/"; // �жϲ����Ƿ�Ϊ��
			for (int i = 0; i < fl.length; i++) { // ѭ�������������ļ�
				zip(out, fl[i], base + fl[i]);
			}
		} else {
			out.putNextEntry(new ZipEntry(base)); // �����µĽ����
			// ����FileInputStream����
			FileInputStream in = new FileInputStream(f);
			int b; // ����int�ͱ���
			System.out.println(base);
			while ((b = in.read()) != -1) { // ���û�е�������β��
				out.write(b); // ���ֽ�д�뵱ǰZIP��Ŀ
			}
			in.close(); // �ر���
		}
	}
	
	public static void main(String[] temp) { // ������
		MyZip book = new MyZip(); // ������������
		try {
			// ���÷���������Ϊѹ�����ļ���Ҫѹ���ļ�
			book.zip("hello.zip", new File("src"));
			System.out.println("ѹ�����"); // �����Ϣ
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
