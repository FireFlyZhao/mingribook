public class MyException extends Exception { // �����Զ����쳣��
	String message; // ����String���ͱ���
	
	public MyException(String ErrorMessagr) { // ���෽��
		message = ErrorMessagr;
	}
	
	public String getMessage() { // ����getMessage()����
		return message;
	}
}
