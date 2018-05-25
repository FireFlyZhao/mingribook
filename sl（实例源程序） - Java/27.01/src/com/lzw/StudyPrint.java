package com.lzw;

import java.awt.*;
import java.awt.print.*;

public class StudyPrint {
	public static void main(String[] args) {
		try {
			PrinterJob job = PrinterJob.getPrinterJob();
			if (!job.printDialog())
				return;
			job.setPrintable(new Printable() {
				private final int OVAL_WIDTH = 130; // 圆形的宽
				private final int OVAL_HEIGHT = 130; // 圆形的高
				
				public int print(Graphics graphics, PageFormat pageFormat,
						int pageIndex) throws PrinterException {
					if (pageIndex > 0)
						return Printable.NO_SUCH_PAGE;
					int x = (int) pageFormat.getImageableX();
					int y = (int) pageFormat.getImageableY();
					Graphics2D g2 = (Graphics2D) graphics;
					g2.setStroke(new BasicStroke(4.0F));
					g2.setColor(Color.BLUE);
					// 绘制第1个圆形
					g2.drawOval(x + 10, y + 10, OVAL_WIDTH, OVAL_HEIGHT); 
					g2.setColor(Color.CYAN);
					// 绘制第2个圆形
					g2.drawOval(x + 130, y + 10, OVAL_WIDTH, OVAL_HEIGHT); 
					g2.setColor(Color.GREEN);
					// 绘制第3个圆形
					g2.drawOval(x + 250, y + 10, OVAL_WIDTH, OVAL_HEIGHT); 
					g2.setColor(Color.MAGENTA);
					// 绘制第4个圆形
					g2.drawOval(x + 70, y + 120, OVAL_WIDTH, OVAL_HEIGHT); 
					g2.setColor(Color.ORANGE);
					// 绘制第5个圆形
					g2.drawOval(x + 190, y + 120, OVAL_WIDTH, OVAL_HEIGHT); 
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