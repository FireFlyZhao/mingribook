import java.awt.*;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.awt.print.*;

import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.border.*;
public class PrintPanel extends JPanel implements Printable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel label;
	private JButton printButton;
	private JButton previewButton;
	private JPanel controlPanel;
	private Image img;
	private Dimension size;
	private PrinterJob job;
	private JFrame previewDialog;
	PageFormat pf;
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 480);
		PrintPanel canvas = new PrintPanel();
		frame.add(canvas);
		frame.setVisible(true);
	}
	public PrintPanel() {
		super();
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				Point point = e.getPoint();
				Graphics2D g2 = (Graphics2D) img.getGraphics();
				g2.setStroke(new BasicStroke(5));
				g2.drawLine(point.x, point.y, point.x, point.y);
				img.flush();
				repaint();
			}
		});
		add(getControlPanel(), BorderLayout.SOUTH);
		pf = new PageFormat();
		pf.setOrientation(PageFormat.LANDSCAPE);
		job = PrinterJob.getPrinterJob();
		previewDialog = new JFrame();
		previewDialog.setSize(800, 600);
	}
	private void drawPage(Graphics2D g2) {
		g2.drawImage(img, 0, 0, this);
	}
	protected JButton getPreviewButton() {
		if (previewButton == null) {
			previewButton = new JButton();
			previewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pf = job.pageDialog(pf);
					MyCanvas canvas = new MyCanvas(pf,img);
					JScrollPane spanel = new JScrollPane(canvas);
					previewDialog.getContentPane().add(spanel);
					previewDialog.setVisible(true);
					canvas.repaint();
				}
			});
			previewButton.setText("打印预览");
		}
		return previewButton;
	}
	protected JButton getPrintButton() {
		if (printButton == null) {
			printButton = new JButton();
			printButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						job.setPrintable(PrintPanel.this);
						job.setJobName("打印图形");
						job.print();
					} catch (PrinterException e1) {
						e1.printStackTrace();
					}
				}
			});
			printButton.setText("打印");
		}
		return printButton;
	}

	protected JPanel getControlPanel() {
		if (controlPanel == null) {
			controlPanel = new JPanel();
			controlPanel.setBorder(new LineBorder(Color.BLUE, 1, false));
			final FlowLayout flowLayout = new FlowLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			flowLayout.setHgap(20);
			controlPanel.setLayout(flowLayout);
			controlPanel.add(getLabel());
			controlPanel.add(getPreviewButton());
			controlPanel.add(getPrintButton());
		}
		return controlPanel;
	}
	@Override
	protected void paintComponent(Graphics g) {
		if (size == null) {
			size = getSize();
			img = createImage(size.width, size.height);
		}
		Graphics2D g2 = (Graphics2D) g;
		drawPage(g2);
	}
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex)
			throws PrinterException {
		if (pageIndex > 0)
			return Printable.NO_SUCH_PAGE;
		int x = (int) pageFormat.getImageableX();
		int y = (int) pageFormat.getImageableY();
		Graphics2D g2 = (Graphics2D) graphics;
		g2.translate(x, y);
		drawPage(g2);
		return Printable.PAGE_EXISTS;
	}
	/**
	 * @return
	 */
	protected JLabel getLabel() {
		if (label == null) {
			label = new JLabel();
			label.setForeground(Color.RED);
			label.setText("请用鼠标在界面上画线或图形，进行预览");
		}
		return label;
	}
}
