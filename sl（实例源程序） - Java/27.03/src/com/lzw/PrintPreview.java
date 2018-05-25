package com.lzw;
import java.awt.*;
import java.awt.print.*;
import javax.swing.*;
public class PrintPreview extends JFrame implements Printable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image img;
	private JButton previewButton = null;
	private JPanel controlPanel = null;
	private JButton printButton = null;
	private Canvas canvas = null;
	private PageFormat pf;
	public PrintPreview() {
		canvas = new MyCanvas();
		pf = new PageFormat();
		pf.setOrientation(PageFormat.LANDSCAPE);
		printButton = new JButton("开始打印");
		img = Toolkit.getDefaultToolkit().getImage(
				PrintPreview.class.getResource("eat.png"));
		initialize();
	}
	// 界面初始化方法
	private void initialize() {
		this.setSize(new Dimension(840, 700));
		BorderLayout borderLayout = new BorderLayout();
		borderLayout.setHgap(10);
		setLayout(borderLayout);
		add(getControlPanel(), BorderLayout.SOUTH);
		add(canvas, BorderLayout.CENTER);
		this.setTitle("打印预览");
	}
	// 实现paint()方法
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex)
			throws PrinterException {
		int x = (int) pageFormat.getImageableX(); // 获取可打印区域坐标的X位置
		int y = (int) pageFormat.getImageableY(); // 获取可打印区域坐标的Y位置
		Graphics2D g2 = (Graphics2D) graphics;
		g2.drawImage(img, x, y, this); // 绘制图像
		return Printable.PAGE_EXISTS; // 返回PAGE_EXISTS
	}
	// 打印预览按钮
	private JButton getPreviewButton() {
		if (previewButton == null) {
			previewButton = new JButton();
			previewButton.setText("打印预览");
			previewButton
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(
								java.awt.event.ActionEvent e) {
							PrinterJob job = PrinterJob.getPrinterJob();
							pf = job.pageDialog(pf);
							canvas.repaint();
						}
					});
		}
		return previewButton;
	}
	// 控制面板
	private JPanel getControlPanel() {
		if (controlPanel == null) {
			FlowLayout flowLayout = new FlowLayout();
			flowLayout.setVgap(2);
			flowLayout.setHgap(30);
			controlPanel = new JPanel();
			controlPanel.setLayout(flowLayout);
			controlPanel.add(getPreviewButton(), null);
			controlPanel.add(printButton, null);
		}
		return controlPanel;
	}
	
	class MyCanvas extends Canvas {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void paint(Graphics g) {
			try {
				super.paint(g);
				Graphics2D g2 = (Graphics2D) g;
				g2.translate(10, 10);
				int x = (int) (pf.getImageableX() - 1);
				int y = (int) (pf.getImageableY() - 1);
				int width = (int) (pf.getImageableWidth() + 1);
				int height = (int) (pf.getImageableHeight() + 1);
				int mw = (int) pf.getWidth();
				int mh = (int) pf.getHeight();
				g2.drawRect(0, 0, mw, mh);
				g2.setStroke(new BasicStroke(1f, BasicStroke.CAP_ROUND,
						BasicStroke.JOIN_ROUND, 10f, new float[] { 5, 5 },
						0f));
				g2.drawRect(x, y, width, height);
				PrintPreview.this.print(g, pf, 0);
			} catch (PrinterException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		try {
			PrintPreview pp = new PrintPreview();
			pp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			pp.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}