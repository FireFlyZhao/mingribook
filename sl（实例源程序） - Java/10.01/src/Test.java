class Test {
	public Test() { // ���췽��
		// SomeSentence
	}
	
	protected void doSomething() { // ��Ա����
		// SomeSentence
	}
	
	protected Test doIt() { // ��������ֵ����ΪTest����
		return new Test();
	}
}

class Test2 extends Test { // �̳и���
	public Test2() { // ���췽��
		super(); // ���ø��๹�췽��
		super.doSomething(); // ���ø����Ա����
	}
	
	public void doSomethingnew() { // ��������
		// SomeSentence
	}
	
	public void doSomething() { // ��д���෽��
		// SomeNewSentence
	}
	
	protected Test2 doIt() { // ��д���෽������������ֵ����ΪTest2����
		return new Test2();
	}
}
