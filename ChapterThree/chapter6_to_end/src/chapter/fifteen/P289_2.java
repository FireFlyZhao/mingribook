package chapter.fifteen;

import java.io.*;

public class P289_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] a = "����10�����".toCharArray();
		int n = 0;
		try {
			File out = new File("wordex.txt");
			for (int i = 0; i < a.length; i++) {
				a[i] = (char)(a[i] ^ 'd');
			}
			FileWriter fw = new FileWriter(out);
			fw.write(a, 0, a.length);
			fw.close();
			FileReader fr = new FileReader(out);
			char tom[] = new char[10];
			System.out.println("���ܺ�");
			while ((n = fr.read(tom, 0, 10)) != -1) {
				String s = new String(tom, 0, n);
				System.out.println(s);
			}
			fr.close();
			fr = new FileReader(out);
			System.out.println("���ģ�");
			while((n = fr.read(tom, 0, 10)) != -1) {
				for (int j = 0; j < n; j++) {
					tom[j] = (char)(tom[j] ^ 'd');
				}
				String str = new String(tom, 0, n);
				System.out.println(str);
			}
			fr.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
