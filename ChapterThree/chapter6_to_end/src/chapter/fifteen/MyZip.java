package chapter.fifteen;

import java.io.*;
import java.util.zip.*;

public class MyZip {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyZip book = new MyZip();
		try {
			book.zip("hello.zip", new File("src"));
			System.out.println("—πÀıÕÍ≥…");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void zip(String zipFileName, File inputFile) throws Exception{
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFileName));
		zip(out,inputFile,"");
		System.out.println("—πÀı÷–°≠");
		out.close();
	}

	public void zip(ZipOutputStream out, File f, String base) throws Exception {
		// TODO Auto-generated method stub
		if (f.isDirectory()) {
			File[] fl = f.listFiles();
			if(base.length() != 0) {
				out.putNextEntry(new ZipEntry(base + "/"));
			}
			for (int i = 0; i < fl.length; i++) {
				zip(out, fl[i], base + fl[i]);
			}
		}else {
			out.putNextEntry(new ZipEntry(base));
			FileInputStream in = new FileInputStream(f);
			int b;
			System.out.println(base);
			while ((b = in.read()) != -1) {
				out.write(b);
			}
			in.close();
		}
	}
	
}
