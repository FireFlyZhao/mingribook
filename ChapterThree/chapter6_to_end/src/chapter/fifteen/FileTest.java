package chapter.fifteen;

import java.io.*;

public class FileTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("word.txt");
		if(file.exists()) {
			file.delete();
			System.out.println("�ļ���ɾ��");
		}else {
			try {
				file.createNewFile();
				System.out.println("�ļ��Ѵ���");
				System.out.println(file.getAbsolutePath());
				System.out.println(file.getParent());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		File file2 = new File("word2.txt");
		if (file2.exists()) {
			String name = file2.getName();
			long length = file2.length();
			boolean hidden = file2.isHidden();
			System.out.println("�ļ����ƣ�" + name);
			System.out.println("�ļ������ǣ�" + length);
			System.out.println("���ļ��������ļ���" + hidden);
		}else {
			System.out.println("���ļ�������"); 
		}
		System.out.println("******  03  ******");
		File file3 = new File("word3.txt");
		try {
			FileOutputStream out = new FileOutputStream(file3);
			byte buy[] = "����һֻСë¿���Ҵ���Ҳ���".getBytes();
			out.write(buy);
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			FileInputStream in = new FileInputStream(file3);
			byte byt[] = new byte[1024];
			int len = in.read(byt);
			System.out.println("�ļ��е���Ϣ�ǣ�" + new String (byt, 0, len));
			in.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
