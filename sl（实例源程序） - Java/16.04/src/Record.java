public class Record {
	@Field_Method_Parameter_Annotation(describe = "编号", type = int.class)
	// 注释字段
	int id;
	@Field_Method_Parameter_Annotation(describe = "姓名", type = String.class)
	String name;
	
	@Constructor_Annotation()
	// 采用默认值注释构造方法
	public Record() {
	}
	
	@Constructor_Annotation("立即初始化构造方法")
	// 注释构造方法
	public Record(
		@Field_Method_Parameter_Annotation(describe = "编号",
				type = int.class) int id,
		@Field_Method_Parameter_Annotation(describe = "姓名",
				type = String.class) String name) {
		this.id = id;
		this.name = name;
	}
	
	@Field_Method_Parameter_Annotation(describe = "获得编号", type = int.class)
	// 注释方法
	public int getId() {
		return id;
	}
	
	@Field_Method_Parameter_Annotation(describe = "设置编号")
	// 成员type采用默认值注释方法
	public void setId(
	// 注释方法的参数
			@Field_Method_Parameter_Annotation(describe = "编号",
					type = int.class) int id) {
		this.id = id;
	}
	
	@Field_Method_Parameter_Annotation(describe = "获得姓名",
			type = String.class)
	public String getName() {
		return name;
	}
	
	@Field_Method_Parameter_Annotation(describe = "设置姓名")
	public void setName(
			@Field_Method_Parameter_Annotation(describe = "姓名",
					type = String.class) String name) {
		this.name = name;
	}
}
