package com.lzw;
import java.awt.*;
import java.awt.print.*;
public class PrintText {
	public static void main(String[] args) {
		try {
			PrinterJob job = PrinterJob.getPrinterJob();
			if (!job.printDialog())
				return;
			job.setPrintable(new Printable() {
				public int print(Graphics graphics, PageFormat pageFormat,
						int pageIndex) throws PrinterException {
					if (pageIndex > 0)
						return Printable.NO_SUCH_PAGE;
					int x = (int) pageFormat.getImageableX();
					int y = (int) pageFormat.getImageableY();
					Graphics2D g2=(Graphics2D) graphics;
					g2.setFont(new Font("宋体",Font.PLAIN,34));
					g2.setColor(Color.BLUE);
					g2.drawString("通过本书学习",x, y+30);
					g2.setFont(new Font("宋体",Font.BOLD,48));
					g2.setColor(Color.RED);
					g2.drawString("JAVA",x, y+90);
					g2.setFont(new Font("宋体",Font.ITALIC,34));
					g2.setColor(Color.BLUE);
					g2.drawString("可以快速入门，并迅速提高",x, y+150);
					return Printable.PAGE_EXISTS;
				}
			});
			job.setJobName("打印图形");
			job.print();
		} catch (PrinterException e) {
			e.printStackTrace();
		}
	}
}