package chapter.eleven;

public class TheSameName {
	
	private int x;
	
	private class innerClass{
		int x;
		private void doit(int x) {
			x++;
			this.x++;
			TheSameName.this.x++;
		}
	}
	

}
