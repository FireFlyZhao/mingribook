package chapter.fifteen;

import java.io.*;

public class P285 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileOutputStream fs = new FileOutputStream("wordex.txt");
			DataOutputStream ds = new DataOutputStream(fs);
			ds.writeUTF("ʹ��writeUFT()����д������;");
			ds.writeChars("ʹ��writeChars()����д������;");
			ds.writeBytes("ʹ��writeBytes()����д������.");
			ds.close();
			FileInputStream fis = new FileInputStream("wordex.txt");
			DataInputStream dis = new DataInputStream(fis);
			System.out.println(dis.readUTF());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
