package chapter.fifteen;

import java.util.zip.*;
import java.io.*;

public class Decompression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ZipInputStream zin;
		try {
			zin = new ZipInputStream(new FileInputStream("hello.zip"));
			ZipEntry entry = zin.getNextEntry();
			while (((entry = zin.getNextEntry()) != null && !entry.isDirectory())) {
				File file = new File("d:\\" + entry.getName());
				System.out.println(file);
				if (!file.exists()) {
					file.mkdirs();
					file.createNewFile();
				}
				zin.closeEntry();
				System.out.println(entry.getName() + "Ω‚—π≥…π¶");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
