class Test {
	public Test() { // 构造方法
		// SomeSentence
	}
	
	protected void doSomething() { // 成员方法
		// SomeSentence
	}
	
	protected Test doIt() { // 方法返回值类型为Test类型
		return new Test();
	}
}

class Test2 extends Test { // 继承父类
	public Test2() { // 构造方法
		super(); // 调用父类构造方法
		super.doSomething(); // 调用父类成员方法
	}
	
	public void doSomethingnew() { // 新增方法
		// SomeSentence
	}
	
	public void doSomething() { // 重写父类方法
		// SomeNewSentence
	}
	
	protected Test2 doIt() { // 重写父类方法，方法返回值类型为Test2类型
		return new Test2();
	}
}
