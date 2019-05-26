package nl.thuis.tutorial.rest.exception;

public class CustomerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 8220287645734930683L;

	public CustomerNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public CustomerNotFoundException(String message) {
		super(message);
	}

	public CustomerNotFoundException(Throwable cause) {
		super(cause);
	}
	
}
