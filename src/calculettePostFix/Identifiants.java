package calculettePostFix;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import calculette.IExpression;
import calculette.IIdentifiants;
import calculette.IPile;

/**
 * La classe <b>Identifiants</b> permet de gérer les variables
 * 
 * @author Thomas
 * 
 */
public class Identifiants implements IIdentifiants {

	// Création d'un HashMap, un tableau avec des index nommés
	private HashMap<String, IExpression> mTable = new HashMap<String, IExpression>();

	/**
	 * Permet de récupérer le nombre de variable dans le tableau
	 */
	public int getNombre() {
		return mTable.size();
	}

	/**
	 * Permet de déclarer une variable
	 */
	public void ajoute(String id) throws IllegalAccessError {
		mTable.put(id, new UneExpression(null));
	}

	/**
	 * Permet de donner une valeur à la variable
	 */
	public String set(String id, IExpression valeur) {
		mTable.put(id, valeur);
		return id;
	}

	/**
	 * Retourne le nom de la variable spécifiée.
	 * 
	 */
	public Set<String> getAll() {
		return mTable.keySet();
	}

	/**
	 * Permet de récupérer la valeur de la variable
	 */
	public IExpression get(String id) {
		return mTable.get(id);
	}

	/**
	 * Permet de vérifier si la variable existe
	 */
	public boolean contient(String id) {
		return mTable.containsKey(id);
	}

	/**
	 * Permet de calculer l'expression par rapport à la variable
	 */
	public double calcule(IPile pile, String id) {
		return mTable.get(id).calcule(pile, this);
	}

	/**
	 * Permet de vérifier si la variable est calculable
	 */
	public boolean estCalculable(String id) {

		try {
			mTable.get(id).analyse(null);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Permet de construire la chaine avec la liste des variable et leurs
	 * expressions
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer(" avec {");
		Set<String> keys = mTable.keySet();

		for (Iterator<String> iter = keys.iterator(); iter.hasNext();) {
			String name = iter.next();

			sb.append(" ");
			sb.append(name);
			sb.append(" = ");
			sb.append(mTable.get(name).toStringInfix());
		}

		sb.append(" }");
		return sb.toString();
	}
}
