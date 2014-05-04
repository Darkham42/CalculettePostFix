package operateurs;

import java.util.NoSuchElementException;
import java.util.Stack;

import calculette.IElement;
import calculette.IIdentifiants;
import calculette.IPile;
import calculette.binaires.ISoustration;
import calculettePostFix.ArgumentMissException;

/**
 * La classe <b>Sous</b> permet de faire des soustractions
 * 
 * @author Thomas
 * 
 */
public class Sous implements ISoustration {

	/**
	 * Permet d'effectuer une soustraction en utilisant 2 arguments issus de la
	 * pile
	 */
	public Double calcule(IPile evaluations, IIdentifiants ids)
			throws IllegalStateException {

		Double arg1 = evaluations.retire();
		Double arg2 = evaluations.retire();
		Double resultat = arg2 - arg1;

		return resultat;
	}

	public String toStringInfix(Stack<String> chaines) {
		String arg1 = chaines.pop();
		String arg2 = chaines.pop();
		return "( " + arg2 + " - " + arg1 + " )";
	}

	public String toString() {
		return "-";
	}

	public void analyse(Stack<IElement> elements, IIdentifiants ids)
			throws NoSuchElementException {

		// l'opérateur a besoin de 2 arguments valables
		if( elements.empty() ) {
			// il manque le 2nd argument
			throw new ArgumentMissException("Il manque le 1er argument");
		}
		IElement argument = elements.pop();
		argument.analyse(elements, ids);

		if( elements.empty() ) {
			// il manque le 2nd argument
			throw new ArgumentMissException("Il manque le 2nd argument");
		}
		argument = elements.pop();
		argument.analyse(elements, ids);

	}

}
