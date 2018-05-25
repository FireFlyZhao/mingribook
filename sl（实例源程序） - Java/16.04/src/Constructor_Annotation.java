import java.lang.annotation.*;

@Target(ElementType.CONSTRUCTOR)
// 用于构造方法
@Retention(RetentionPolicy.RUNTIME)
// 在运行时加载Annotation到JVM中
public @interface Constructor_Annotation {
	String value() default "默认构造方法"; // 定义一个具有默认值的String型成员
}
