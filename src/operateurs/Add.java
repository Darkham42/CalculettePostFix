package operateurs;

import java.util.NoSuchElementException;
import java.util.Stack;

import calculette.IElement;
import calculette.IIdentifiants;
import calculette.IPile;
import calculette.binaires.IAddition;

/**
 * La classe <b>Add</b> permet de faire des additions
 * @author Thomas
 *
 */
public class Add implements IAddition {

	/**
	 * Permet d'effectuer une addition en utilisant 2 arguments issus de la pile 
	 */
	public Double calcule(IPile evaluations, IIdentifiants ids)
			throws IllegalStateException {

		Double arg1 = evaluations.retire();
		Double arg2 = evaluations.retire();
		Double resultat = arg1 + arg2;

		return resultat;
	}

	/**
	 * Permet de construire sous forme Infix une représentation de l'addition
	 */
	public String toStringInfix(Stack<String> chaines) {
		String arg1 = chaines.pop();
		String arg2 = chaines.pop();
		return "( " + arg2 + " + " + arg1 + " )";
	}

	/**
	 * Permet de récupérer le morceau de chaine qui représente l'addition
	 */
	public String toString() {
		return "+";
	}

	/**
	 * Permet de vérifier si l'addition est effectuable ou non
	 */
	public void analyse(Stack<IElement> elements, IIdentifiants ids)
			throws NoSuchElementException {
		// TODO Auto-generated method stub

	}

}
