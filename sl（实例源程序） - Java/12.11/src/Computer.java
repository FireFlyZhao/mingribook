public class Computer {
    public static int getMaxComm(int m , int n) throws MyException{
    	if( m <= 0 ||n<=0){
    		throw new MyException("传递的参数不是正整数");
    	}
    	if(m < n){
    		int temp = 0;
    		temp = m;
    		m = n;
    		n = temp;
    	}
    	int r = m % n;
    	while(r!=0){
    		m = n;
    		n = r;
    		r = m % n;
    	}
    	return n;
    }
	public static void main(String[] args) {
		try {
			int m = 122 , n= 0;
			int reslut = getMaxComm(m,n);
			System.out.println(m+" 和 "+n+"的最大共约数是："+reslut);
		} catch (MyException e) {
			
			e.printStackTrace();
		}
		
	}

}