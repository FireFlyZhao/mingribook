import java.lang.annotation.*;

@Target(ElementType.CONSTRUCTOR)
@Retention(RetentionPolicy.RUNTIME)
public @interface Constructor_Annotation {

	String value() default "Ĭ�Ϲ��췽��";

}
