package com.lzw;

import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import java.lang.reflect.*;
import java.net.*;
import java.util.*;

import javax.swing.*;
import javax.swing.event.*;

import com.lzw.iframe.*;

public class MenuBar extends JMenuBar {// �˵���

	/**
	 * �����������˵�
	 */
	private JMenu jinhuo_Menu = null;

	/**
	 * �����������˵��λ�ڣ����������˵���
	 */
	private JMenuItem jinhuoItem = null;

	/**
	 * �������˻����˵��λ�ڣ����������˵���
	 */
	private JMenuItem jinhuo_tuihuoItem = null;

	/**
	 * �����۹����˵�
	 */
	private JMenu xiaoshou_Menu = null;

	/**
	 * ���������˵�
	 */
	private JMenu kucun_Menu = null;

	/**
	 * ����Ϣ��ѯ���˵�
	 */
	private JMenu xinxi_chaxunMenu = null;

	/**
	 * ���������ϣ��˵�
	 */
	private JMenu jiben_ziliaoMenu = null;

	/**
	 * ��ϵͳά�����˵�
	 */
	private JMenu xitong_weihuMenu = null;

	/**
	 * �����ڣ��˵�
	 */
	private JMenu chuang_kouMenu = null;

	/**
	 * ���������˵�
	 */
	private JMenu bang_zhuMenu = null;

	/**
	 * �����ڣ��˵��λ�ڣ��������˵���
	 */
	private JMenuItem guanyu_Item = null;

	/**
	 * ����ϵ����֧�֣��˵��λ�ڣ��������˵���
	 */
	private JMenuItem bugItem = null;

	/**
	 * �����ʼ�����վ���˵��λ�ڣ��������˵���
	 */
	private JMenuItem fangwen_wangzhanItem = null;

	/**
	 * �����۵����˵��λ�ڣ����۹����˵���
	 */
	private JMenuItem xiaoshou_danItem = null;

	/**
	 * �������˻����˵��λ�ڣ����۹����˵���
	 */
	private JMenuItem xiaoshou_tuihuoItem = null;

	/**
	 * ������̵㣩�˵��λ�ڣ��������˵���
	 */
	private JMenuItem kucun_pandianItem = null;

	/**
	 * ���۸�������˵��λ�ڣ��������˵���
	 */
	private JMenuItem jiage_tiaozhengItem = null;

	/**
	 * �����۲�ѯ���˵��λ�ڣ���Ϣ��ѯ���˵���
	 */
	private JMenuItem xiaoshou_chaxunItem = null;

	/**
	 * ����Ʒ��ѯ���˵��λ�ڣ���Ϣ��ѯ���˵���
	 */
	private JMenuItem shangpin_chaxunItem = null;

	/**
	 * ���������У��˵��λ�ڣ���Ϣ��ѯ���˵���
	 */
	private JMenuItem xiaoshou_paihangItem = null;

	/**
	 * ����Ʒ�����˵��λ�ڣ��������ϣ��˵���
	 */
	private JMenuItem shangpin_guanliItem = null;

	/**
	 * ���ͻ������˵��λ�ڣ��������ϣ��˵���
	 */
	private JMenuItem kehu_guanliItem = null;

	/**
	 * ����Ӧ�̹����˵��λ�ڣ��������ϣ��˵���
	 */
	private JMenuItem gys_guanliItem = null;

	/**
	 * �����������ã��˵��λ�ڣ��������ϣ��˵���
	 */
	private JMenuItem jsr_guanliItem = null;

	/**
	 * �������޸ģ��˵��λ�ڣ�ϵͳά�����˵���
	 */
	private JMenuItem mima_xiugaiItem = null;

	/**
	 * �����ݿⱸ����ָ����˵��λ�ڣ�ϵͳά�����˵���
	 */
	private JMenuItem shuju_beifenItem = null;

	/**
	 * ���˳����˵��λ�ڣ�ϵͳά�����˵���
	 */
	private JMenuItem exitItem = null;

	/**
	 * ������ƽ�̣��˵��λ�ڣ����ڣ��˵���
	 */
	private JMenuItem pingpuItem = null;

	/**
	 * �����ڲ�������������
	 */
	private JDesktopPane desktopPanel = null;

	/**
	 * �ڲ�����ļ���
	 */
	private Map<JMenuItem, JInternalFrame> iFrames = null;

	/**
	 * �ڲ������λ������
	 */
	private int nextFrameX, nextFrameY;

	/**
	 * ��ȫ���رգ��˵��λ�ڣ����ڣ��˵���
	 */
	private JMenuItem closeAllItem = null;

	/**
	 * ��ȫ����С�����˵��λ�ڣ����ڣ��˵���
	 */
	private JMenuItem allIconItem = null;

	/**
	 * ��ȫ����ԭ���˵��λ�ڣ����ڣ��˵���
	 */
	private JMenuItem allResumeItem = null;

	/**
	 * ״̬�����ڲ�������ʾ��ǩ
	 */
	private JLabel stateLabel = null;

	/**
	 * Ĭ�ϵĹ��췽��
	 * 
	 */
	private MenuBar() {
	}

	public MenuBar(JDesktopPane desktopPanel, JLabel label) {
		super();
		iFrames = new HashMap<JMenuItem, JInternalFrame>();
		this.desktopPanel = desktopPanel;
		this.stateLabel = label;
		initialize();
	}

	/**
	 * ��ʼ���˵�������ķ���
	 * 
	 */
	private void initialize() {
		this.setSize(new Dimension(600, 24));
		add(getJinhuo_Menu());
		add(getXiaoshou_Menu());
		add(getKucun_Menu());
		add(getXinxi_chaxunMenu());
		add(getJiben_ziliaoMenu());
		add(getXitong_weihuMenu());
		add(getChuang_kouMenu());
		add(getBang_zhuMenu());
	}

	/**
	 * ��ʼ����������˵��ķ���
	 * 
	 * @return javax.swing.JMenu
	 */
	public JMenu getJinhuo_Menu() {
		if (jinhuo_Menu == null) {
			jinhuo_Menu = new JMenu();
			jinhuo_Menu.setText("��������(J)");
			jinhuo_Menu.setMnemonic(KeyEvent.VK_J);
			jinhuo_Menu.add(getJinhuoItem());
			jinhuo_Menu.add(getJinhuo_tuihuoItem());
		}
		return jinhuo_Menu;
	}

	/**
	 * ��ʼ�������������˵���ķ��� �÷�������˵���򿪽���������,��ʹ���ڴ��ڱ�ѡ��״̬
	 * 
	 * @return javax.swing.JMenuItem
	 */
	public JMenuItem getJinhuoItem() {
		if (jinhuoItem == null) {
			jinhuoItem = new JMenuItem();
			jinhuoItem.setText("������");
			jinhuoItem.setIcon(new ImageIcon(getClass().getResource("/res/icon/jinhuodan.png")));
			jinhuoItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					createIFrame(jinhuoItem, JinHuoDan_IFrame.class);
				}
			});
		}
		return jinhuoItem;
	}

	/**
	 * ��ʼ���������˻����˵���ķ������÷�������˵���򿪣������˻������壬��ʹ���崦����ѡ��״̬��
	 * 
	 * @return javax.swing.JMenuItem
	 */
	public JMenuItem getJinhuo_tuihuoItem() {
		if (jinhuo_tuihuoItem == null) {
			jinhuo_tuihuoItem = new JMenuItem();
			jinhuo_tuihuoItem.setText("�����˻�");
			jinhuo_tuihuoItem.setIcon(new ImageIcon(getClass().getResource("/res/icon/jinhuo_tuihuo.png")));
			jinhuo_tuihuoItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					createIFrame(jinhuo_tuihuoItem, JinHuoTuiHuo.class);
				}
			});
		}
		return jinhuo_tuihuoItem;
	}

	/**
	 * ��ʼ�������۹����˵��ķ������÷�������˵�����ڲ����壬��ʹ���崦����ѡ��״̬��
	 * 
	 * @return javax.swing.JMenu
	 */
	public JMenu getXiaoshou_Menu() {
		if (xiaoshou_Menu == null) {
			xiaoshou_Menu = new JMenu();
			xiaoshou_Menu.setText("���۹���(X)");
			xiaoshou_Menu.setMnemonic(KeyEvent.VK_X);
			xiaoshou_Menu.add(getXiaoshou_danItem());
			xiaoshou_Menu.add(getXiaoshou_tuihuoItem());
		}
		return xiaoshou_Menu;
	}

	/**
	 * ��ʼ�����������˵��ķ���
	 * 
	 * @return javax.swing.JMenu
	 */
	public JMenu getKucun_Menu() {
		if (kucun_Menu == null) {
			kucun_Menu = new JMenu();
			kucun_Menu.setText("������(K)");
			kucun_Menu.setMnemonic(KeyEvent.VK_K);
			kucun_Menu.add(getKucun_pandianItem());
			kucun_Menu.add(getJiage_tiaozhengItem());
		}
		return kucun_Menu;
	}

	/**
	 * ��ʼ������Ϣ��ѯ���˵��ķ���
	 * 
	 * @return javax.swing.JMenu
	 */
	public JMenu getXinxi_chaxunMenu() {
		if (xinxi_chaxunMenu == null) {
			xinxi_chaxunMenu = new JMenu();
			xinxi_chaxunMenu.setText("��Ϣ��ѯ(C)");
			xinxi_chaxunMenu.setMnemonic(KeyEvent.VK_C);
			xinxi_chaxunMenu.add(getXiaoshou_chaxunItem());
			xinxi_chaxunMenu.add(getShangpin_chaxunItem());
			xinxi_chaxunMenu.addSeparator();
			xinxi_chaxunMenu.add(getXiaoshou_paihangItem());
		}
		return xinxi_chaxunMenu;
	}

	/**
	 * ��ʼ�����������ϣ��˵��ķ���
	 * 
	 * @return javax.swing.JMenu
	 */
	public JMenu getJiben_ziliaoMenu() {
		if (jiben_ziliaoMenu == null) {
			jiben_ziliaoMenu = new JMenu();
			jiben_ziliaoMenu.setText("��������(B)");
			jiben_ziliaoMenu.setMnemonic(KeyEvent.VK_B);
			jiben_ziliaoMenu.add(getShangpin_guanliItem());
			jiben_ziliaoMenu.add(getKehu_guanliItem());
			jiben_ziliaoMenu.add(getGys_guanliItem());
			jiben_ziliaoMenu.addSeparator();
			jiben_ziliaoMenu.add(getJsr_guanliItem());
		}
		return jiben_ziliaoMenu;
	}

	/**
	 * ��ʼ��ϵͳά���˵��ķ���
	 * 
	 * @return javax.swing.JMenu
	 */
	public JMenu getXitong_weihuMenu() {
		if (xitong_weihuMenu == null) {
			xitong_weihuMenu = new JMenu();
			xitong_weihuMenu.setText("ϵͳά��(S)");
			xitong_weihuMenu.setMnemonic(KeyEvent.VK_S);
			xitong_weihuMenu.add(getShuju_beifenItem());
			xitong_weihuMenu.addSeparator();
			xitong_weihuMenu.add(getMima_xiugaiItem());
			xitong_weihuMenu.addSeparator();
			xitong_weihuMenu.add(getExitItem());
		}
		return xitong_weihuMenu;
	}

	/**
	 * ��ʼ�����ڲ˵��ķ���
	 * 
	 * @return javax.swing.JMenu
	 */
	public JMenu getChuang_kouMenu() {
		if (chuang_kouMenu == null) {
			chuang_kouMenu = new JMenu();
			chuang_kouMenu.setText("����(W)");
			chuang_kouMenu.setMnemonic(KeyEvent.VK_W);
			chuang_kouMenu.addMenuListener(new MenuListener() {
				public void menuSelected(MenuEvent e) {
					chuang_kouMenu.removeAll();
					chuang_kouMenu.add(getPingpuItem());
					chuang_kouMenu.add(getClassAllItem());
					chuang_kouMenu.add(getAllIconItem());
					chuang_kouMenu.add(getAllResumeItem());
					chuang_kouMenu.addSeparator();
					int count = 0;
					// ��ȡ��������������ڲ�����
					JInternalFrame[] allFrames = desktopPanel.getAllFrames();
					// Foreach�����ڲ���������
					for (final JInternalFrame frame : allFrames) {
						String frameTitle = frame.getTitle();
						count++;// ���������
						final JMenuItem item = new JMenuItem(count + "  " + frameTitle);// ��������˵���
						chuang_kouMenu.add(item);// ��Ӳ˵���˵���
						item.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								try {// ������˵���ĵ����¼�
									frame.setIcon(false);
									frame.setSelected(true);
								} catch (PropertyVetoException e1) {
									e1.printStackTrace();
								}
							}
						});
					}
				}

				public void menuDeselected(javax.swing.event.MenuEvent e) {
				}

				public void menuCanceled(javax.swing.event.MenuEvent e) {
				}
			});
		}
		return chuang_kouMenu;
	}

	/**
	 * ��ʼ�����������˵��ķ���
	 * 
	 * @return javax.swing.JMenu
	 */
	public JMenu getBang_zhuMenu() {
		if (bang_zhuMenu == null) {
			bang_zhuMenu = new JMenu();
			bang_zhuMenu.setText("����(H)");
			bang_zhuMenu.setMnemonic(KeyEvent.VK_H);
			bang_zhuMenu.add(getGuanyu_Item());
			bang_zhuMenu.add(getBugItem());
			bang_zhuMenu.add(getFangwen_wangzhanItem());
		}
		return bang_zhuMenu;
	}

	/**
	 * ��ʼ�������ڣ��˵���ķ���
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getGuanyu_Item() {
		if (guanyu_Item == null) {
			guanyu_Item = new JMenuItem();
			guanyu_Item.setText("����");
			guanyu_Item.setIcon(new ImageIcon(getClass().getResource("/res/icon/guanyu.png")));
			URL url = DesktopPanel.class.getResource("/res/about.jpg");
			ImageIcon aboutImage = new ImageIcon(url);
			final JLabel imgLabel = new JLabel(aboutImage);
			imgLabel.setVisible(false);
			desktopPanel.add(imgLabel);
			desktopPanel.setLayer(imgLabel, Integer.MAX_VALUE);
			guanyu_Item.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int dw = desktopPanel.getWidth();
					int dh = desktopPanel.getHeight();
					imgLabel.setBounds((dw - 500) / 2, (dh - 350) / 2, 500, 350);
					imgLabel.setVisible(true);
				}
			});
			imgLabel.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					imgLabel.setVisible(false);
				}
			});
		}
		return guanyu_Item;
	}

	/**
	 * ��ʼ������ϵ����֧�֣��˵���ķ���
	 * 
	 * @return javax.swing.JMenuItem
	 */
	public JMenuItem getBugItem() {
		if (bugItem == null) {
			bugItem = new JMenuItem();
			bugItem.setText("��ϵ����֧��");
			bugItem.setIcon(new ImageIcon(getClass().getResource("/res/icon/jishu_zhichi.png")));
			bugItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (Desktop.isDesktopSupported()) {
						Desktop desktop = Desktop.getDesktop();
						try {
							URI uri = new URI("mailto:tmoonbook@sina.com");
							desktop.mail(uri);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				}
			});
		}
		return bugItem;
	}

	/**
	 * ��ʼ�������ʼ�����վ���˵���ķ���
	 * 
	 * @return javax.swing.JMenuItem
	 */
	public JMenuItem getFangwen_wangzhanItem() {
		if (fangwen_wangzhanItem == null) {
			fangwen_wangzhanItem = new JMenuItem();
			fangwen_wangzhanItem.setText("���ʼ�����վ");
			fangwen_wangzhanItem.setIcon(new ImageIcon(getClass().getResource("/res/icon/jishu_wangzhan.png")));
			fangwen_wangzhanItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (Desktop.isDesktopSupported()) {
						Desktop desktop = Desktop.getDesktop();
						try {
							URL url = new URL("http://www.mrbccd.com");
							desktop.browse(url.toURI());
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				}
			});
		}
		return fangwen_wangzhanItem;
	}

	/**
	 * ��ʼ�������۵����˵���ķ���
	 * 
	 * @return javax.swing.JMenuItem
	 */
	public JMenuItem getXiaoshou_danItem() {
		if (xiaoshou_danItem == null) {
			xiaoshou_danItem = new JMenuItem();
			xiaoshou_danItem.setText("���۵�");
			xiaoshou_danItem.setIcon(new ImageIcon(getClass().getResource("/res/icon/xiaoshoudan.png")));
			xiaoshou_danItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					createIFrame(xiaoshou_danItem, XiaoShouDan.class);
				}
			});
		}
		return xiaoshou_danItem;
	}

	/**
	 * ��ʼ���������˻����˵���ķ���
	 * 
	 * @return javax.swing.JMenuItem
	 */
	public JMenuItem getXiaoshou_tuihuoItem() {
		if (xiaoshou_tuihuoItem == null) {
			xiaoshou_tuihuoItem = new JMenuItem();
			xiaoshou_tuihuoItem.setText("�����˻�");
			xiaoshou_tuihuoItem.setIcon(new ImageIcon(getClass().getResource("/res/icon/xiaoshou_tuihuo.png")));
			xiaoshou_tuihuoItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					createIFrame(xiaoshou_tuihuoItem, XiaoShouTuiHuo.class);
				}
			});
		}
		return xiaoshou_tuihuoItem;
	}

	/**
	 * ��ʼ��������̵㣩�˵���ķ���
	 * 
	 * @return javax.swing.JMenuItem
	 */
	public JMenuItem getKucun_pandianItem() {
		if (kucun_pandianItem == null) {
			kucun_pandianItem = new JMenuItem();
			kucun_pandianItem.setText("����̵�");
			kucun_pandianItem.setIcon(new ImageIcon(getClass().getResource("/res/icon/kucun_pandian.png")));
			kucun_pandianItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					createIFrame(kucun_pandianItem, KuCunPanDian.class);
				}
			});
		}
		return kucun_pandianItem;
	}

	/**
	 * ��ʼ�����۸�������˵���ķ���
	 * 
	 * @return javax.swing.JMenuItem
	 */
	public JMenuItem getJiage_tiaozhengItem() {
		if (jiage_tiaozhengItem == null) {
			jiage_tiaozhengItem = new JMenuItem();
			jiage_tiaozhengItem.setText("�۸����");
			jiage_tiaozhengItem.setIcon(new ImageIcon(getClass().getResource("/res/icon/jiage_tiaozheng.png")));
			jiage_tiaozhengItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					createIFrame(jiage_tiaozhengItem, JiaGeTiaoZheng.class);
				}
			});
		}
		return jiage_tiaozhengItem;
	}

	/**
	 * ��ʼ�������۲�ѯ���˵���ķ���
	 * 
	 * @return javax.swing.JMenuItem
	 */
	public JMenuItem getXiaoshou_chaxunItem() {
		if (xiaoshou_chaxunItem == null) {
			xiaoshou_chaxunItem = new JMenuItem();
			xiaoshou_chaxunItem.setText("���۲�ѯ");
			xiaoshou_chaxunItem.setIcon(new ImageIcon(getClass().getResource("/res/icon/xiaoshou_chaxun.png")));
			xiaoshou_chaxunItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					createIFrame(xiaoshou_chaxunItem, XiaoShouChaXun.class);
				}
			});
		}
		return xiaoshou_chaxunItem;
	}

	/**
	 * ��ʼ������Ʒ��ѯ���˵���ķ���
	 * 
	 * @return javax.swing.JMenuItem
	 */
	public JMenuItem getShangpin_chaxunItem() {
		if (shangpin_chaxunItem == null) {
			shangpin_chaxunItem = new JMenuItem();
			shangpin_chaxunItem.setText("��Ʒ��ѯ");
			shangpin_chaxunItem.setIcon(new ImageIcon(getClass().getResource("/res/icon/shangpin_chaxun.png")));
			shangpin_chaxunItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					createIFrame(shangpin_chaxunItem, ShangPinChaXun.class);
				}
			});
		}
		return shangpin_chaxunItem;
	}

	/**
	 * ��ʼ�����������У��˵���ķ���
	 * 
	 * @return javax.swing.JMenuItem
	 */
	public JMenuItem getXiaoshou_paihangItem() {
		if (xiaoshou_paihangItem == null) {
			xiaoshou_paihangItem = new JMenuItem();
			xiaoshou_paihangItem.setText("��������");
			xiaoshou_paihangItem.setIcon(new ImageIcon(getClass().getResource("/res/icon/xiaoshou_paihang.png")));
			xiaoshou_paihangItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					createIFrame(xiaoshou_paihangItem, XiaoShouPaiHang.class);
				}
			});
		}
		return xiaoshou_paihangItem;
	}

	/**
	 * ��ʼ������Ʒ���Ϲ����˵���ķ���
	 * 
	 * @return javax.swing.JMenuItem
	 */
	public JMenuItem getShangpin_guanliItem() {
		if (shangpin_guanliItem == null) {
			shangpin_guanliItem = new JMenuItem();
			shangpin_guanliItem.setText("��Ʒ���Ϲ���");
			shangpin_guanliItem.setIcon(new ImageIcon(getClass().getResource("/res/icon/shangpin_guanli.png")));
			shangpin_guanliItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					createIFrame(shangpin_guanliItem, ShangPinGuanLi.class);
				}
			});
		}
		return shangpin_guanliItem;
	}

	/**
	 * ��ʼ�����ͻ����Ϲ����˵���ķ���
	 * 
	 * @return javax.swing.JMenuItem
	 */
	public JMenuItem getKehu_guanliItem() {
		if (kehu_guanliItem == null) {
			kehu_guanliItem = new JMenuItem();
			kehu_guanliItem.setText("�ͻ����Ϲ���");
			kehu_guanliItem.setIcon(new ImageIcon(getClass().getResource("/res/icon/kehu_guanli.png")));
			kehu_guanliItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					createIFrame(kehu_guanliItem, KeHuGuanLi.class);
				}
			});
		}
		return kehu_guanliItem;
	}

	/**
	 * ��ʼ������Ӧ�̹����˵���ķ���
	 * 
	 * @return javax.swing.JMenuItem
	 */
	public JMenuItem getGys_guanliItem() {
		if (gys_guanliItem == null) {
			gys_guanliItem = new JMenuItem();
			gys_guanliItem.setText("��Ӧ�����Ϲ���");
			gys_guanliItem.setIcon(new ImageIcon(getClass().getResource("/res/icon/gys_guanli.png")));
			gys_guanliItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					createIFrame(gys_guanliItem, GysGuanLi.class);
				}
			});
		}
		return gys_guanliItem;
	}

	/**
	 * ��ʼ�������������ã��˵���ķ���
	 * 
	 * @return javax.swing.JMenuItem
	 */
	public JMenuItem getJsr_guanliItem() {
		if (jsr_guanliItem == null) {
			jsr_guanliItem = new JMenuItem();
			jsr_guanliItem.setText("����������");
			jsr_guanliItem.setIcon(new ImageIcon(getClass().getResource("/res/icon/jsr_shezhi.png")));
			jsr_guanliItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					createIFrame(jsr_guanliItem, JsrGL.class);
				}
			});
		}
		return jsr_guanliItem;
	}

	/**
	 * ��ʼ���������޸ģ��˵���ķ���
	 * 
	 * @return javax.swing.JMenuItem
	 */
	public JMenuItem getMima_xiugaiItem() {
		if (mima_xiugaiItem == null) {
			mima_xiugaiItem = new JMenuItem();
			mima_xiugaiItem.setText("�����޸�");
			mima_xiugaiItem.setIcon(new ImageIcon(getClass().getResource("/res/icon/mima_xiugai.png")));
			mima_xiugaiItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					createIFrame(mima_xiugaiItem, GengGaiMiMa.class);
				}
			});
		}
		return mima_xiugaiItem;
	}

	/**
	 * ��ʼ�������ݿⱸ����ָ����˵���ķ���
	 * 
	 * @return javax.swing.JMenuItem
	 */
	public JMenuItem getShuju_beifenItem() {
		if (shuju_beifenItem == null) {
			shuju_beifenItem = new JMenuItem();
			shuju_beifenItem.setText("���ݿⱸ����ָ�");
			shuju_beifenItem.setIcon(new ImageIcon(getClass().getResource("/res/icon/shujuku_beifen_huifu.png")));
			shuju_beifenItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					createIFrame(shuju_beifenItem, BackupAndRestore.class);
				}
			});
		}
		return shuju_beifenItem;
	}

	/**
	 * ��ʼ�����˳�ϵͳ���˵���ķ���
	 * 
	 * @return javax.swing.JMenuItem
	 */
	public JMenuItem getExitItem() {
		if (exitItem == null) {
			exitItem = new JMenuItem();
			exitItem.setText("�˳�ϵͳ");
			exitItem.setIcon(new ImageIcon(getClass().getResource("/res/icon/tuichu_xitong.png")));
			exitItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return exitItem;
	}

	/**
	 * ��ʼ��������ƽ�̣��˵���ķ���
	 * 
	 * @return javax.swing.JMenuItem
	 */
	public JMenuItem getPingpuItem() {
		if (pingpuItem == null) {
			pingpuItem = new JMenuItem();
			pingpuItem.setText("���ڲ��");
			pingpuItem.setIcon(new ImageIcon(getClass().getResource("/res/icon/chuangkou_pingpu.png")));
			pingpuItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JInternalFrame[] allFrames = desktopPanel.getAllFrames();
					int x = 0, y = 0;
					for (JInternalFrame iFrame : allFrames) {
						iFrame.setLocation(x, y);
						try {
							iFrame.setSelected(true);
						} catch (PropertyVetoException e1) {
							e1.printStackTrace();
						}
						int frameH = iFrame.getPreferredSize().height;
						int panelH = iFrame.getContentPane().getPreferredSize().height;
						int fSpacing = frameH - panelH;
						x += fSpacing;
						y += fSpacing;
						if (x + getWidth() / 2 > desktopPanel.getWidth())
							x = 0;
						if (y + getHeight() / 2 > desktopPanel.getHeight())
							y = 0;
					}
				}
			});
		}
		return pingpuItem;
	}

	/**
	 * �����ڲ�����ķ������÷���ʹ�÷��似����ȡ�ڲ�����Ĺ��췽�����Ӷ������ڲ����塣
	 * 
	 * @param item��������ڲ�����Ĳ˵���
	 * @param clazz���ڲ������Class����
	 */
	private JInternalFrame createIFrame(JMenuItem item, Class clazz) {
		Constructor constructor = clazz.getConstructors()[0];
		JInternalFrame iFrame = iFrames.get(item);
		try {
			if (iFrame == null || iFrame.isClosed()) {
				iFrame = (JInternalFrame) constructor.newInstance(new Object[] {});
				iFrames.put(item, iFrame);
				iFrame.setFrameIcon(item.getIcon());
				iFrame.setLocation(nextFrameX, nextFrameY);
				int frameH = iFrame.getPreferredSize().height;
				int panelH = iFrame.getContentPane().getPreferredSize().height;
				int fSpacing = frameH - panelH;
				nextFrameX += fSpacing;
				nextFrameY += fSpacing;
				if (nextFrameX + iFrame.getWidth() > desktopPanel.getWidth())
					nextFrameX = 0;
				if (nextFrameY + iFrame.getHeight() > desktopPanel.getHeight())
					nextFrameY = 0;
				desktopPanel.add(iFrame);
				iFrame.setResizable(false);
				iFrame.setMaximizable(false);
				iFrame.setVisible(true);
			}
			iFrame.setSelected(true);
			stateLabel.setText(iFrame.getTitle());
			iFrame.addInternalFrameListener(new InternalFrameAdapter() {
				public void internalFrameActivated(InternalFrameEvent e) {
					super.internalFrameActivated(e);
					JInternalFrame frame = e.getInternalFrame();
					stateLabel.setText(frame.getTitle());
				}

				public void internalFrameDeactivated(InternalFrameEvent e) {
					stateLabel.setText("û��ѡ����");
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return iFrame;
	}

	/**
	 * ��ʼ����ȫ���رգ��˵���ķ���
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getClassAllItem() {
		if (closeAllItem == null) {
			closeAllItem = new JMenuItem();
			closeAllItem.setText("ȫ���ر�");
			closeAllItem.setIcon(new ImageIcon(getClass().getResource("/res/icon/quanbu_guanbi.png")));
			closeAllItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JInternalFrame[] allFrames = desktopPanel.getAllFrames();
					for (JInternalFrame frame : allFrames) {
						frame.doDefaultCloseAction();
					}
				}
			});
		}
		return closeAllItem;
	}

	/**
	 * ��ʼ����ȫ����С�����˵���ķ���
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getAllIconItem() {
		if (allIconItem == null) {
			allIconItem = new JMenuItem();
			allIconItem.setText("ȫ����С��");
			allIconItem.setIcon(new ImageIcon(getClass().getResource("/res/icon/quanbu_zuixiaohua.png")));
			allIconItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JInternalFrame[] allFrames = desktopPanel.getAllFrames();
					for (JInternalFrame frame : allFrames) {
						try {
							frame.setIcon(true);
						} catch (PropertyVetoException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
		}
		return allIconItem;
	}

	/**
	 * ��ʼ����ȫ����ԭ���˵���ķ���
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getAllResumeItem() {
		if (allResumeItem == null) {
			allResumeItem = new JMenuItem();
			allResumeItem.setText("ȫ����ԭ");
			allResumeItem.setIcon(new ImageIcon(getClass().getResource("/res/icon/quanbu_huanyuan.png")));
			allResumeItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JInternalFrame[] allFrames = desktopPanel.getAllFrames();
					for (JInternalFrame frame : allFrames) {
						try {
							frame.setIcon(false);
						} catch (PropertyVetoException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
		}
		return allResumeItem;
	}
}
