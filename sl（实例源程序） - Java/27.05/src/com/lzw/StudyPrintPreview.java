package com.lzw;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
public class StudyPrintPreview {
	private final static int OVAL_WIDTH = 130; // 圆形的宽
	private final static int OVAL_HEIGHT = 130; // 圆形的高
	private static int x;
	private static int y;

	public static void main(String[] args) {
		PageFormat pf = new PageFormat();
		PrinterJob job = PrinterJob.getPrinterJob();
		BufferedImage img = new BufferedImage(400, 300,
				BufferedImage.TYPE_INT_RGB);
		if (!job.printDialog())
			return;
		job.setPrintable(new Printable() {
			public int print(Graphics graphics, PageFormat pageFormat,
					int pageIndex) throws PrinterException {
				if (pageIndex > 0)
					return Printable.NO_SUCH_PAGE;
				x = (int) pageFormat.getImageableX();
				y = (int) pageFormat.getImageableY();
				drawPage(graphics, x, y);
				return Printable.PAGE_EXISTS;
			}
		});
		job.setJobName("打印图形");
		pf = job.pageDialog(pf);
		drawPage(img.getGraphics(), x, y);
		StudyPreviewCanvas canvas = new StudyPreviewCanvas(pf, img);
		JScrollPane spanel = new JScrollPane(canvas);
		JFrame previewDialog = new JFrame();
		previewDialog.getContentPane().add(spanel);
		previewDialog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		previewDialog.setSize(800, 600);
		previewDialog.setVisible(true);
		canvas.repaint();
	}
	private static void drawPage(Graphics graphics, int x, int y) {
		Graphics2D g2 = (Graphics2D) graphics;
		g2.setColor(Color.WHITE);
		g2.fillRect(0, 0, 400, 300);
		g2.setStroke(new BasicStroke(4.0F));
		g2.setColor(Color.BLUE);
		g2.drawOval(x + 10, y + 10, OVAL_WIDTH, OVAL_HEIGHT); // 绘制第1个圆形
		g2.setColor(Color.CYAN);
		g2.drawOval(x + 130, y + 10, OVAL_WIDTH, OVAL_HEIGHT); // 绘制第2个圆形
		g2.setColor(Color.GREEN);
		g2.drawOval(x + 250, y + 10, OVAL_WIDTH, OVAL_HEIGHT); // 绘制第3个圆形
		g2.setColor(Color.MAGENTA);
		g2.drawOval(x + 70, y + 120, OVAL_WIDTH, OVAL_HEIGHT); // 绘制第4个圆形
		g2.setColor(Color.ORANGE);
		g2.drawOval(x + 190, y + 120, OVAL_WIDTH, OVAL_HEIGHT); // 绘制第5个圆形
	}
}