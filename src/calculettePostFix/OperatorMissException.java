package calculettePostFix;

/**
 * La classe <b>OperatorMissException</b> permet de gérer l'erreur du manque
 * d'un opérateur
 * 
 * @author Thomas
 * 
 */
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
