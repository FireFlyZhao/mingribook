public class BreakOutsideNested {
	public static void main(String[] args) {
		Loop: for (int i = 0; i < 3; i++) {// 在for循环前用标签标记
			for (int j = 0; j < 6; j++) {
				if (j == 4) {// 如果j等于4的时候就结束外层循环
					break Loop;// 跳出Loop标签标记的循环体
				}
				System.out.println("i=" + i + " j=" + j);
			}
		}
	}
}
