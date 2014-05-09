package operateurs;

import java.util.NoSuchElementException;
import java.util.Stack;

import calculette.IElement;
import calculette.IIdentifiants;
import calculette.IPile;
import calculette.binaires.IPuissance;
import calculettePostFix.ArgumentMissException;

/**
 * La classe <b>Puiss</b> permet de faire d'effectuer un calcul de puissance
 * 
 * @author Thomas
 * 
 */
public class Puiss implements IPuissance {

	/**
	 * Permet d'effectuer un calcul de puissance sur un argument en utilisant un
	 * autre argument, tous les deux sont issus de la pile
	 */
	public Double calcule(IPile evaluations, IIdentifiants ids)
			throws IllegalStateException {

		Double arg1 = evaluations.retire();
		Double arg2 = evaluations.retire();
		Double resultat = Math.pow(arg2, arg1);

		return resultat;
	}

	public String toStringInfix(Stack<String> chaines) {
		String arg1 = chaines.pop();
		String arg2 = chaines.pop();
		return "( " + arg2 + " ^ " + arg1 + " )";
	}

	public String toString() {
		return "^";
	}

	public void analyse(Stack<IElement> elements, IIdentifiants ids)
			throws NoSuchElementException {

		if (elements.empty()) {
			throw new ArgumentMissException("Il manque le 1er argument");
		}
		IElement argument = elements.pop();
		argument.analyse(elements, ids);

		if (elements.empty()) {
			throw new ArgumentMissException("Il manque le 2nd argument");
		}
		argument = elements.pop();
		argument.analyse(elements, ids);

	}

}
