public class TrigonometricFunction {
	public static void main(String[] args) {
		// 取90度的正弦
		System.out.println("90度的正弦值：" + Math.sin(Math.PI / 2));
		System.out.println("0度的余弦值：" + Math.cos(0)); // 取0度的余弦
		// 取60度的正切
		System.out.println("60度的正切值：" + Math.tan(Math.PI / 3));
		// 取2的平方根与2商的反正弦
		System.out.println("2的平方根与2商的反弦值："
				+ Math.asin(Math.sqrt(2) / 2));
		// 取2的平方根与2商的反余弦
		System.out.println("2的平方根与2商的反余弦值："
				+ Math.acos(Math.sqrt(2) / 2));
		System.out.println("1的反正切值：" + Math.atan(1)); // 取1的反正切
		// 取120度的弧度值
		System.out.println("120度的弧度值：" + Math.toRadians(120.0));
		// 取π/2的角度
		System.out.println("π/2的角度值：" + Math.toDegrees(Math.PI / 2));
	}
}
