package calculettePostFix;

import calculette.IExpression;
import calculette.IIdentifiants;
import calculette.IPile;

/**
 * La classe <b>ID</b> permet de
 * @author Thomas
 *
 */
public class ID implements IIdentifiants {

	public int getNombre() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void ajoute(String id) throws IllegalAccessError {
		// TODO Auto-generated method stub

	}

	public String set(int idx, IExpression valeur) {
		// TODO Auto-generated method stub
		return null;
	}

	public IExpression get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Récupération de l'ID
	 */
	public String getIdentifiant(int idx) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean contient(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	public double calcule(IPile pile, String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean estCalculable(String id) {
		// TODO Auto-generated method stub
		return false;
	}

}
