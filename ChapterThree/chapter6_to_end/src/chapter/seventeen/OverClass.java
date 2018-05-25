package chapter.seventeen;

public class OverClass<Gee> {
	private Gee over;
	
	public Gee getOver() {
		return over;
	}

	public void setOver(Gee over) {
		this.over = over;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OverClass<Boolean> over1 = new OverClass();
		over1.setOver(true);
		Boolean b = over1.getOver();
		System.out.println(b);
		OverClass<Float> over2 = new OverClass<Float>();
		over2.setOver(12.3f);
		Float f= over2.getOver();
		System.out.println(f);
		OverClass<Boolean[]> over3 = new OverClass();
		
		over3.setOver(new Boolean[] {true, false});
		Boolean[] bArr = over3.getOver();
		System.out.println(bArr[0] + " " + bArr[1]);
	}

}
