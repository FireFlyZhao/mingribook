interface OutInterface2 { // ����һ���ӿ�
}
class OuterClass3 {
	public OutInterface2 doit(final String x) { // doit()��������Ϊfinal����
		// ��doit()�����ж���һ���ڲ���
		class InnerClass2 implements OutInterface2 {
			InnerClass2(String s) {
				s = x;
				System.out.println(s);
			}
		}
		return new InnerClass2("doit");
	}
}
