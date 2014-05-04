package unaire;

import java.util.NoSuchElementException;
import java.util.Stack;

import calculette.IElement;
import calculette.IIdentifiants;
import calculette.IPile;
import calculette.unaires.ICos;
import calculettePostFix.ArgumentMissException;

public class Cos implements ICos {

	public Double calcule(IPile evaluations, IIdentifiants ids)
			throws IllegalStateException {

		Double nombre = evaluations.retire();
		Double resultat = Math.cos(nombre);

		return resultat;
	}

	public String toStringInfix(Stack<String> chaines) {
		String arg1 = chaines.pop();
		return "cos(" + arg1 + ")";
	}

	public String toString() {
		return "cos";
	}

	public void analyse(Stack<IElement> elements, IIdentifiants ids)
			throws NoSuchElementException {

		// l'opérateur a besoin de 1 argument valable
		if( elements.empty() ) {
			// il manque le 1er argument
			throw new ArgumentMissException("Il manque le 1er argument");
		}
		IElement argument = elements.pop();
		argument.analyse(elements, ids);

	}

}
