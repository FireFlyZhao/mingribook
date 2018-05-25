import java.io.*;

import javax.swing.*;

public class Student {
	public static void main(String[] temp) {
		byte b[] = new byte[2];
		try{
			FileInputStream fis = new FileInputStream("word.txt");
			ProgressMonitorInputStream in = 
				new ProgressMonitorInputStream(null,"¶ÁÈ¡ÎÄ¼þ",fis);
		   while(in.read(b)!=-1){
			   String s = new String(b);
			   System.out.print(s);
			   Thread.sleep(100);
		   }
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
