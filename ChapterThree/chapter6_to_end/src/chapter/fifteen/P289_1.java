package chapter.fifteen;

import java.io.*;

import javax.swing.*;

public class P289_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte b[] = new byte[124];
		try {
			FileInputStream fis = new FileInputStream("wordex.txt");
			ProgressMonitorInputStream in = 
					new ProgressMonitorInputStream(null, "¶ÁÈ¡ÎÄ¼þ", fis);
			while(in.read(b) != -1) {
				String s = new String(b);
				System.out.println(s);
				Thread.sleep(100);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
