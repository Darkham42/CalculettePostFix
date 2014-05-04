package calculettePostFix;

@SuppressWarnings("serial")
public class OperatorMissException extends IllegalArgumentException {

	public OperatorMissException() {
	}

	public OperatorMissException(String arg0) {
		super(arg0);
	}

	public OperatorMissException(Throwable arg0) {
		super(arg0);
	}

	public OperatorMissException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
