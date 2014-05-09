package calculettePostFix;

import java.util.NoSuchElementException;
import java.util.Stack;

import calculette.IElement;
import calculette.IIdentifiants;
import calculette.IPile;

/**
 * La classe <b>Variable</b> permet de représenter une variable
 * 
 * @author Thomas
 * 
 */
public class Variable implements IElement {

	// Définition d'une variable
	private String mName;

	// Initialisation de la variable
	public Variable(String name) {
		mName = name;
	}

	/**
	 * Permet de calculer la valeur de la variable via son identifiant
	 */
	public Double calcule(IPile evaluations, IIdentifiants ids)
			throws IllegalStateException {
		return ids.calcule(evaluations, mName);
	}

	/**
	 * Permet de construire sous forme Infix une représentation de la variable
	 */
	public String toStringInfix(Stack<String> chaines) {
		return mName;
	}

	/**
	 * Permet de récupérer le morceau de chaine qui réprésente la pile
	 */
	public String toString() {
		return mName;
	}

	/**
	 * Permet de vérifier si la variable est calculable
	 */
	public void analyse(Stack<IElement> elements, IIdentifiants ids)
			throws NoSuchElementException {
	}

}
