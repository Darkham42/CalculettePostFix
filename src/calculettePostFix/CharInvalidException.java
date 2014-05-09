package calculettePostFix;

/**
 * La classe <b>CharInvalidException</b> permet de gérer l'erreur d'un caractère
 * invalide
 * 
 * @author Thomas
 * 
 */
@SuppressWarnings("serial")
public class CharInvalidException extends IllegalArgumentException {

	public CharInvalidException() {
	}

	public CharInvalidException(String arg0) {
		super(arg0);
	}

	public CharInvalidException(Throwable arg0) {
		super(arg0);
	}

	public CharInvalidException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
