import java.lang.annotation.*;

@Target(ElementType.CONSTRUCTOR)
// ���ڹ��췽��
@Retention(RetentionPolicy.RUNTIME)
// ������ʱ����Annotation��JVM��
public @interface Constructor_Annotation {
	String value() default "Ĭ�Ϲ��췽��"; // ����һ������Ĭ��ֵ��String�ͳ�Ա
}
