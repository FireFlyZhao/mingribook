public class TheSameName {
	private int x;
	
	private class Inner {
		private int x = 9;
		public void doit(int x) {
			x++; // ���õ����β�x
			this.x++; // �����ڲ���ı���x
			TheSameName.this.x++; // �����ⲿ��ı���x
		}
	}
}
