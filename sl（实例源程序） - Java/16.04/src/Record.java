public class Record {
	@Field_Method_Parameter_Annotation(describe = "���", type = int.class)
	// ע���ֶ�
	int id;
	@Field_Method_Parameter_Annotation(describe = "����", type = String.class)
	String name;
	
	@Constructor_Annotation()
	// ����Ĭ��ֵע�͹��췽��
	public Record() {
	}
	
	@Constructor_Annotation("������ʼ�����췽��")
	// ע�͹��췽��
	public Record(
		@Field_Method_Parameter_Annotation(describe = "���",
				type = int.class) int id,
		@Field_Method_Parameter_Annotation(describe = "����",
				type = String.class) String name) {
		this.id = id;
		this.name = name;
	}
	
	@Field_Method_Parameter_Annotation(describe = "��ñ��", type = int.class)
	// ע�ͷ���
	public int getId() {
		return id;
	}
	
	@Field_Method_Parameter_Annotation(describe = "���ñ��")
	// ��Աtype����Ĭ��ֵע�ͷ���
	public void setId(
	// ע�ͷ����Ĳ���
			@Field_Method_Parameter_Annotation(describe = "���",
					type = int.class) int id) {
		this.id = id;
	}
	
	@Field_Method_Parameter_Annotation(describe = "�������",
			type = String.class)
	public String getName() {
		return name;
	}
	
	@Field_Method_Parameter_Annotation(describe = "��������")
	public void setName(
			@Field_Method_Parameter_Annotation(describe = "����",
					type = String.class) String name) {
		this.name = name;
	}
}
