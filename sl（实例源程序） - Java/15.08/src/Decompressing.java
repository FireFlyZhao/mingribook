import java.io.*;
import java.util.zip.*;

public class Decompressing { // �����ļ�
	public static void main(String[] temp) {
		ZipInputStream zin; // ����ZipInputStream����
		try { // try��䲶����ܷ������쳣
			zin = new ZipInputStream(new FileInputStream("hello.zip"));
			// ʵ��������ָ��Ҫ���н�ѹ���ļ�
			ZipEntry entry = zin.getNextEntry(); // ��ȡ��һ��ZipEntry
			while (((entry = zin.getNextEntry()) != null)
					&& !entry.isDirectory()) {
				// ���entry��Ϊ�գ�������ͬһĿ¼��
				File file = new File("d:\\" + entry.getName()); // ��ȡ�ļ�Ŀ¼
				System.out.println(file);
				if (!file.exists()) { // ������ļ�������
					file.mkdirs();// �����ļ������ļ���
					file.createNewFile(); // �����ļ�
				}
				zin.closeEntry(); // �رյ�ǰentry
				System.out.println(entry.getName() + "��ѹ�ɹ�");
			}
			zin.close(); // �ر���
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
