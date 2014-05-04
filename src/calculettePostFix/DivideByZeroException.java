package calculettePostFix;

@SuppressWarnings("serial")
public class DivideByZeroException extends IllegalArgumentException {

	public DivideByZeroException() {
	}

	public DivideByZeroException(String arg0) {
		super(arg0);
	}

	public DivideByZeroException(Throwable arg0) {
		super(arg0);
	}

	public DivideByZeroException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
