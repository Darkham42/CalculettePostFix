package calculettePostFix;

/**
 * La classe <b>ArgumentMissException</b> permet de gérer l'erreur du manque
 * d'argument
 * 
 * @author Thomas
 * 
 */
@SuppressWarnings("serial")
public class ArgumentMissException extends IllegalArgumentException {

	public ArgumentMissException() {
	}

	public ArgumentMissException(String arg0) {
		super(arg0);
	}

	public ArgumentMissException(Throwable arg0) {
		super(arg0);
	}

	public ArgumentMissException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
