package com.lzw;

import java.awt.*;
import java.awt.print.*;

public class MultiPagePrint {
	static class PrintPage implements Printable {
		public int print(Graphics graphics, PageFormat pageFormat,
				int pageIndex) throws PrinterException {
			// 获取可打印区域坐标的X位置
			int x = (int) pageFormat.getImageableX();
			// 获取可打印区域坐标的Y位置
			int y = (int) pageFormat.getImageableY();
			Graphics2D g2 = (Graphics2D) graphics;
			// 绘制文本
			g2.drawString("多页打印实例的第" + pageIndex + "页", x, y + 10);
			return Printable.PAGE_EXISTS; // 返回PAGE_EXISTS
		}
	}
	
	public static void main(String[] args) {
		try {
			PrinterJob job = PrinterJob.getPrinterJob();
			if (!job.printDialog()) // 如果取消打印对话框
				return; // 终止方法执行
			Book printBook = new Book();
			PageFormat pf = new PageFormat();
			printBook.append(new PrintPage(), pf); // 添加1页
			printBook.append(new PrintPage(), pf, 5); // 添加5页
			job.setPageable(printBook); // 设置打印页
			job.setJobName("多页打印"); // 设置打印任务名称
			job.print(); // 执行打印
		} catch (PrinterException e) {
			e.printStackTrace();
		}
	}
}