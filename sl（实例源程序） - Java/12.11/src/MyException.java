public class MyException extends Exception {			
	String message;							
	public MyException(String ErrorMessagr) {		
		message = ErrorMessagr;
	}
	public String getMessage(){					
		return message;
	}
}