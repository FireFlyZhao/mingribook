package com.lzw;

import java.awt.*;
import java.awt.print.*;

public class MultiPagePrint {
	static class PrintPage implements Printable {
		public int print(Graphics graphics, PageFormat pageFormat,
				int pageIndex) throws PrinterException {
			// ��ȡ�ɴ�ӡ���������Xλ��
			int x = (int) pageFormat.getImageableX();
			// ��ȡ�ɴ�ӡ���������Yλ��
			int y = (int) pageFormat.getImageableY();
			Graphics2D g2 = (Graphics2D) graphics;
			// �����ı�
			g2.drawString("��ҳ��ӡʵ���ĵ�" + pageIndex + "ҳ", x, y + 10);
			return Printable.PAGE_EXISTS; // ����PAGE_EXISTS
		}
	}
	
	public static void main(String[] args) {
		try {
			PrinterJob job = PrinterJob.getPrinterJob();
			if (!job.printDialog()) // ���ȡ����ӡ�Ի���
				return; // ��ֹ����ִ��
			Book printBook = new Book();
			PageFormat pf = new PageFormat();
			printBook.append(new PrintPage(), pf); // ���1ҳ
			printBook.append(new PrintPage(), pf, 5); // ���5ҳ
			job.setPageable(printBook); // ���ô�ӡҳ
			job.setJobName("��ҳ��ӡ"); // ���ô�ӡ��������
			job.print(); // ִ�д�ӡ
		} catch (PrinterException e) {
			e.printStackTrace();
		}
	}
}