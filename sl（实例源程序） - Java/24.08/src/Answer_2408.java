import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

public class Answer_2408 extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ButtonGroup sexButtonGroup = new ButtonGroup();
	private ButtonGroup marriedButtonGroup = new ButtonGroup();
	private JTextField languageLevelTextField;
	private JComboBox<String> languageTypeComboBox;
	private JTextField specialtyTextField;
	private JComboBox<String> schoolageComboBox;
	private JTextField addressTextField;
	private JTextField postalcodeTextField;
	private JTextField partyMemberTextField;
	private JComboBox<String> nativePlaceComboBox;
	private JComboBox<String> nationComboBox;
	private JTextField idCardTextField;
	private JTextField birthdayTextField;
	private JTextField nameTextField;
	private JTextField numTextField;
	private SpringLayout springLayout;
	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			Answer_2408 frame = new Answer_2408();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public Answer_2408() {
		super();
		setTitle("新建档案");
		setBounds(100, 100, 500, 375);
		springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final JLabel numLabel = new JLabel();
		numLabel.setText("档案编号：");
		getContentPane().add(numLabel);
		springLayout.putConstraint(SpringLayout.NORTH, numLabel, 5,
				SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, numLabel, 5,
				SpringLayout.WEST, getContentPane());

		numTextField = new JTextField();
		numTextField.setEditable(false);
		numTextField.setHorizontalAlignment(SwingConstants.CENTER);
		numTextField.setText("TM000001");
		numTextField.setColumns(30);
		getContentPane().add(numTextField);
		springLayout.putConstraint(SpringLayout.EAST, numTextField, 245,
				SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, numTextField, 5,
				SpringLayout.EAST, numLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, numTextField, 18,
				SpringLayout.NORTH, numLabel);

		final JLabel nameLabel = new JLabel();
		nameLabel.setText("姓    名：");
		getContentPane().add(nameLabel);
		springLayout.putConstraint(SpringLayout.NORTH, nameLabel, 11, SpringLayout.SOUTH, numLabel);
		springLayout.putConstraint(SpringLayout.WEST, nameLabel, 0,
				SpringLayout.WEST, numLabel);

		nameTextField = new JTextField();
		getContentPane().add(nameTextField);
		springLayout.putConstraint(SpringLayout.NORTH, nameTextField, -18, SpringLayout.SOUTH, nameLabel);
		springLayout.putConstraint(SpringLayout.EAST, nameTextField, 0,
				SpringLayout.EAST, numTextField);
		springLayout.putConstraint(SpringLayout.WEST, nameTextField, 5,
				SpringLayout.EAST, nameLabel);

		final JLabel sexLabel = new JLabel();
		sexLabel.setText("性    别：");
		getContentPane().add(sexLabel);
		springLayout.putConstraint(SpringLayout.NORTH, sexLabel, 12, SpringLayout.SOUTH, nameLabel);
		springLayout.putConstraint(SpringLayout.WEST, sexLabel, 0,
				SpringLayout.WEST, nameLabel);

		final JRadioButton manRadioButton = new JRadioButton();
		sexButtonGroup.add(manRadioButton);
		manRadioButton.setText("男");
		getContentPane().add(manRadioButton);
		springLayout.putConstraint(SpringLayout.NORTH, manRadioButton, 5,
				SpringLayout.SOUTH, nameTextField);
		springLayout.putConstraint(SpringLayout.WEST, manRadioButton, 5,
				SpringLayout.EAST, sexLabel);

		final JRadioButton womanRadioButton = new JRadioButton();
		sexButtonGroup.add(womanRadioButton);
		womanRadioButton.setText("女");
		getContentPane().add(womanRadioButton);
		springLayout.putConstraint(SpringLayout.SOUTH, womanRadioButton, 77,
				SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, womanRadioButton, -23, SpringLayout.SOUTH, manRadioButton);

		final JLabel birthdayLabel = new JLabel();
		birthdayLabel.setText("出生日期：");
		getContentPane().add(birthdayLabel);
		springLayout.putConstraint(SpringLayout.NORTH, birthdayLabel, 12, SpringLayout.SOUTH, sexLabel);
		springLayout.putConstraint(SpringLayout.WEST, birthdayLabel, 5,
				SpringLayout.WEST, getContentPane());

		birthdayTextField = new JTextField();
		getContentPane().add(birthdayTextField);
		springLayout.putConstraint(SpringLayout.EAST, birthdayTextField, 0,
				SpringLayout.EAST, nameTextField);
		springLayout.putConstraint(SpringLayout.WEST, birthdayTextField, 5,
				SpringLayout.EAST, birthdayLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, birthdayTextField, 26,
				SpringLayout.SOUTH, manRadioButton);
		springLayout.putConstraint(SpringLayout.NORTH, birthdayTextField, 5,
				SpringLayout.SOUTH, manRadioButton);

		final JLabel idCardLabel = new JLabel();
		idCardLabel.setText("身份证号：");
		getContentPane().add(idCardLabel);
		springLayout.putConstraint(SpringLayout.NORTH, idCardLabel, 11, SpringLayout.SOUTH, birthdayLabel);
		springLayout.putConstraint(SpringLayout.WEST, idCardLabel, 0,
				SpringLayout.WEST, birthdayLabel);

		idCardTextField = new JTextField();
		getContentPane().add(idCardTextField);
		springLayout.putConstraint(SpringLayout.EAST, idCardTextField, 0,
				SpringLayout.EAST, birthdayTextField);
		springLayout.putConstraint(SpringLayout.WEST, idCardTextField, 5,
				SpringLayout.EAST, idCardLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, idCardTextField, 26,
				SpringLayout.SOUTH, birthdayTextField);
		springLayout.putConstraint(SpringLayout.NORTH, idCardTextField, 5,
				SpringLayout.SOUTH, birthdayTextField);

		final JLabel nationLabel = new JLabel();
		nationLabel.setText("民    族：");
		getContentPane().add(nationLabel);
		springLayout.putConstraint(SpringLayout.NORTH, nationLabel, 11,
				SpringLayout.SOUTH, idCardLabel);
		springLayout.putConstraint(SpringLayout.WEST, nationLabel, 0,
				SpringLayout.WEST, idCardLabel);

		nationComboBox = new JComboBox<>();
		getContentPane().add(nationComboBox);
		springLayout.putConstraint(SpringLayout.WEST, nationComboBox, 0,
				SpringLayout.WEST, idCardTextField);

		final JLabel nativePlaceLabel = new JLabel();
		nativePlaceLabel.setText("籍    贯：");
		getContentPane().add(nativePlaceLabel);
		springLayout.putConstraint(SpringLayout.NORTH, nativePlaceLabel, 13,
				SpringLayout.SOUTH, nationLabel);
		springLayout.putConstraint(SpringLayout.WEST, nativePlaceLabel, 5,
				SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, nationComboBox, 5,
				SpringLayout.SOUTH, idCardTextField);

		nativePlaceComboBox = new JComboBox<>();
		getContentPane().add(nativePlaceComboBox);
		springLayout.putConstraint(SpringLayout.NORTH, nativePlaceComboBox, 5,
				SpringLayout.SOUTH, nationComboBox);
		springLayout.putConstraint(SpringLayout.WEST, nativePlaceComboBox, 5,
				SpringLayout.EAST, nativePlaceLabel);

		final JLabel marriedLabel = new JLabel();
		marriedLabel.setText("婚姻状况：");
		getContentPane().add(marriedLabel);
		springLayout.putConstraint(SpringLayout.NORTH, marriedLabel, 10,
				SpringLayout.SOUTH, nativePlaceLabel);
		springLayout.putConstraint(SpringLayout.WEST, marriedLabel, 0,
				SpringLayout.WEST, nativePlaceLabel);

		final JRadioButton unmarriedRadioButton = new JRadioButton();
		marriedButtonGroup.add(unmarriedRadioButton);
		unmarriedRadioButton.setText("未婚");
		getContentPane().add(unmarriedRadioButton);
		springLayout.putConstraint(SpringLayout.NORTH, unmarriedRadioButton, 5,
				SpringLayout.SOUTH, nativePlaceComboBox);
		springLayout.putConstraint(SpringLayout.WEST, unmarriedRadioButton, 5,
				SpringLayout.EAST, marriedLabel);

		final JRadioButton marriedRadioButton = new JRadioButton();
		marriedRadioButton.setText("已婚");
		marriedButtonGroup.add(marriedRadioButton);
		getContentPane().add(marriedRadioButton);
		springLayout.putConstraint(SpringLayout.WEST, womanRadioButton, 0,
				SpringLayout.WEST, marriedRadioButton);
		springLayout.putConstraint(SpringLayout.WEST, marriedRadioButton, 140,
				SpringLayout.WEST, getContentPane());

		final JLabel partyMemberLabel = new JLabel();
		partyMemberLabel.setText("政治面貌：");
		getContentPane().add(partyMemberLabel);
		springLayout.putConstraint(SpringLayout.NORTH, partyMemberLabel, 12,
				SpringLayout.SOUTH, marriedLabel);
		springLayout.putConstraint(SpringLayout.WEST, partyMemberLabel, 0,
				SpringLayout.WEST, marriedLabel);

		partyMemberTextField = new JTextField();
		getContentPane().add(partyMemberTextField);
		springLayout.putConstraint(SpringLayout.SOUTH, marriedRadioButton, -5,
				SpringLayout.NORTH, partyMemberTextField);
		springLayout.putConstraint(SpringLayout.NORTH, marriedRadioButton, -28,
				SpringLayout.NORTH, partyMemberTextField);
		springLayout.putConstraint(SpringLayout.EAST, partyMemberTextField, 0,
				SpringLayout.EAST, idCardTextField);
		springLayout.putConstraint(SpringLayout.WEST, partyMemberTextField, 5,
				SpringLayout.EAST, partyMemberLabel);
		springLayout.putConstraint(SpringLayout.NORTH, partyMemberTextField, 5,
				SpringLayout.SOUTH, unmarriedRadioButton);

		final JLabel postalcodeLabel = new JLabel();
		postalcodeLabel.setText("邮政编码：");
		getContentPane().add(postalcodeLabel);
		springLayout.putConstraint(SpringLayout.NORTH, postalcodeLabel, 11, SpringLayout.SOUTH, partyMemberLabel);
		springLayout.putConstraint(SpringLayout.EAST, postalcodeLabel, 60,
				SpringLayout.WEST, partyMemberLabel);
		springLayout.putConstraint(SpringLayout.WEST, postalcodeLabel, 0,
				SpringLayout.WEST, partyMemberLabel);

		postalcodeTextField = new JTextField();
		getContentPane().add(postalcodeTextField);
		springLayout.putConstraint(SpringLayout.EAST, postalcodeTextField, 0,
				SpringLayout.EAST, partyMemberTextField);
		springLayout.putConstraint(SpringLayout.WEST, postalcodeTextField, 5,
				SpringLayout.EAST, postalcodeLabel);
		springLayout.putConstraint(SpringLayout.NORTH, postalcodeTextField, 5,
				SpringLayout.SOUTH, partyMemberTextField);

		final JLabel addressLabel = new JLabel();
		addressLabel.setText("户籍地址：");
		getContentPane().add(addressLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, addressLabel, 284,
				SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, addressLabel, 11, SpringLayout.SOUTH, postalcodeLabel);
		springLayout.putConstraint(SpringLayout.EAST, addressLabel, 60,
				SpringLayout.WEST, postalcodeLabel);
		springLayout.putConstraint(SpringLayout.WEST, addressLabel, 0,
				SpringLayout.WEST, postalcodeLabel);

		addressTextField = new JTextField();
		getContentPane().add(addressTextField);
		springLayout.putConstraint(SpringLayout.EAST, addressTextField, -5,
				SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, addressTextField, 0,
				SpringLayout.WEST, postalcodeTextField);
		springLayout.putConstraint(SpringLayout.NORTH, addressTextField, 5,
				SpringLayout.SOUTH, postalcodeTextField);

		final JLabel photoLabel = new JLabel();
		photoLabel.setBorder(new TitledBorder(null, "",
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, null, null));
		photoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		photoLabel.setText("<照片>");
		getContentPane().add(photoLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, photoLabel, 129,
				SpringLayout.SOUTH, numTextField);
		springLayout.putConstraint(SpringLayout.NORTH, photoLabel, 5,
				SpringLayout.SOUTH, numTextField);

		final JLabel schoolageLabel = new JLabel();
		schoolageLabel.setText("学    历：");
		getContentPane().add(schoolageLabel);
		springLayout.putConstraint(SpringLayout.NORTH, schoolageLabel, 0,
				SpringLayout.NORTH, nativePlaceLabel);

		schoolageComboBox = new JComboBox<>();
		getContentPane().add(schoolageComboBox);
		springLayout.putConstraint(SpringLayout.SOUTH, schoolageComboBox, 183,
				SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, schoolageComboBox, -18, SpringLayout.SOUTH, schoolageLabel);
		springLayout.putConstraint(SpringLayout.EAST, photoLabel, 430,
				SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, photoLabel, 0,
				SpringLayout.WEST, schoolageComboBox);
		springLayout.putConstraint(SpringLayout.WEST, schoolageComboBox, 5,
				SpringLayout.EAST, schoolageLabel);

		final JLabel specialtyLabel = new JLabel();
		specialtyLabel.setText("专    业：");
		getContentPane().add(specialtyLabel);
		springLayout.putConstraint(SpringLayout.WEST, schoolageLabel, 0,
				SpringLayout.WEST, specialtyLabel);
		springLayout.putConstraint(SpringLayout.WEST, specialtyLabel, 5,
				SpringLayout.EAST, partyMemberTextField);
		springLayout.putConstraint(SpringLayout.NORTH, specialtyLabel, 0,
				SpringLayout.NORTH, marriedLabel);

		specialtyTextField = new JTextField();
		getContentPane().add(specialtyTextField);
		springLayout.putConstraint(SpringLayout.EAST, specialtyTextField, -5,
				SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, specialtyTextField, 5,
				SpringLayout.EAST, specialtyLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, specialtyTextField, 26,
				SpringLayout.SOUTH, schoolageComboBox);
		springLayout.putConstraint(SpringLayout.NORTH, specialtyTextField, 5,
				SpringLayout.SOUTH, schoolageComboBox);

		final JLabel languageTypeLabel = new JLabel();
		languageTypeLabel.setText("外语语种：");
		getContentPane().add(languageTypeLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, languageTypeLabel, 232,
				SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, languageTypeLabel, 12, SpringLayout.SOUTH, specialtyLabel);
		springLayout.putConstraint(SpringLayout.EAST, languageTypeLabel, 0,
				SpringLayout.EAST, specialtyLabel);
		springLayout.putConstraint(SpringLayout.WEST, languageTypeLabel, 5,
				SpringLayout.EAST, partyMemberTextField);

		languageTypeComboBox = new JComboBox<>();
		getContentPane().add(languageTypeComboBox);
		springLayout.putConstraint(SpringLayout.SOUTH, languageTypeComboBox,
				235, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, languageTypeComboBox, 5,
				SpringLayout.EAST, languageTypeLabel);

		final JLabel languageLevelLabel = new JLabel();
		languageLevelLabel.setText("外语水平：");
		getContentPane().add(languageLevelLabel);
		springLayout.putConstraint(SpringLayout.EAST, languageLevelLabel, 0,
				SpringLayout.EAST, languageTypeLabel);
		springLayout.putConstraint(SpringLayout.WEST, languageLevelLabel, 5,
				SpringLayout.EAST, postalcodeTextField);
		springLayout.putConstraint(SpringLayout.NORTH, languageLevelLabel, 243,
				SpringLayout.NORTH, getContentPane());

		languageLevelTextField = new JTextField();
		getContentPane().add(languageLevelTextField);
		springLayout.putConstraint(SpringLayout.EAST, languageLevelTextField,
				-5, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, languageLevelTextField,
				5, SpringLayout.EAST, languageLevelLabel);
		springLayout.putConstraint(SpringLayout.NORTH, languageLevelTextField,
				5, SpringLayout.SOUTH, languageTypeComboBox);
		//
		initDiscreteness();

		final JButton exitButton = new JButton();
		exitButton.setText("退出");
		getContentPane().add(exitButton);
		springLayout.putConstraint(SpringLayout.EAST, exitButton, 0, SpringLayout.EAST, addressTextField);
		springLayout.putConstraint(SpringLayout.WEST, exitButton, -57, SpringLayout.EAST, addressTextField);
		springLayout.putConstraint(SpringLayout.SOUTH, exitButton, 325, SpringLayout.NORTH, getContentPane());

		final JButton submitButton = new JButton();
		submitButton.setText("确定");
		getContentPane().add(submitButton);
		springLayout.putConstraint(SpringLayout.SOUTH, submitButton, 325, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, submitButton, -5, SpringLayout.WEST, exitButton);
	}

	private void initDiscreteness() {

		nationComboBox.addItem("请选择");
		nationComboBox.addItem("汉族");
		nationComboBox.addItem("朝鲜族");

		nativePlaceComboBox.addItem("请选择");
		nativePlaceComboBox.addItem("北京市");
		nativePlaceComboBox.addItem("吉林省");
		nativePlaceComboBox.addItem("辽宁省");

		schoolageComboBox.addItem("请选择");
		schoolageComboBox.addItem("高中");
		schoolageComboBox.addItem("大专");
		schoolageComboBox.addItem("本科");
		schoolageComboBox.addItem("硕士");
		schoolageComboBox.addItem("博士");

		languageTypeComboBox.addItem("请选择");
		languageTypeComboBox.addItem("英语");
		languageTypeComboBox.addItem("日语");

	}

}
