package nl.thuis.tutorial.rest.exception;

public class StudentNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 8220287645734930683L;

	public StudentNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public StudentNotFoundException(String message) {
		super(message);
	}

	public StudentNotFoundException(Throwable cause) {
		super(cause);
	}
	
}
