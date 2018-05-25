package chapter.sixteen;

import java.lang.reflect.*;

public class Main_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Example_03 example = new Example_03();
		Class exampleC = example.getClass();
		Method[] declaredMethods = exampleC.getDeclaredMethods();
		
		for (int i = 0; i < declaredMethods.length; i++) {
			Method method = declaredMethods[i];
			System.out.println("名称为：" + method.getName());
			System.out.println("是否允许带有可变数量的参数：" + method.isVarArgs());
			System.out.println("入口参数类型依次为：");
			Class[] parameterTypes = method.getParameterTypes();
			for (int j = 0; j < parameterTypes.length; j++) {
				System.out.println(" " + parameterTypes[j]);
			}
			System.out.println("返回值类型为：" + method.getReturnType());
			System.out.println("可能抛出的异常类型有：");
			Class[] exceptionTypes = method.getExceptionTypes();
			for (int j = 0; j < exceptionTypes.length; j++) {
				System.out.println(" " + exceptionTypes[j]);
			}
			boolean isTurn = true;
			while(isTurn) {
				try {
					isTurn = false;
					if ("staticMathod".equals(method.getName()))
						method.invoke(example);
					else if ("publicMethod".equals(method.getName()))
						System.out.println("返回值为："
								+ method.invoke(example, 168));
					else if ("protectedMethod".equals(method.getName()))
						System.out.println("返回值为："
								+ method.invoke(example, "7", 5));
					else if ("privateMethod".equals(method.getName())) {
						Object[] parameters = new Object[] {new String[] {"M", "W", "Q"}};
						System.out.println("返回值为：" + method.invoke(example, parameters));
					}
						
				} catch (Exception e) {
					System.out.println("在执行方法时抛出异常，"
							+ "下面执行setAccessible()方法！");
					method.setAccessible(true);
					isTurn = true;
				}
				
			}
			System.out.println();
		}
	}

}
