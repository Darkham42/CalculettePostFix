package unaire;

import java.util.NoSuchElementException;
import java.util.Stack;

import calculette.IElement;
import calculette.IIdentifiants;
import calculette.IPile;
import calculette.unaires.ICos;

public class Cos implements ICos {

	public Double calcule(IPile evaluations, IIdentifiants ids)
			throws IllegalStateException {
		
		Double nombre = evaluations.retire();
		Double resultat = Math.cos(nombre);

		return resultat;
	}

	public String toStringInfix(Stack<String> chaines) {
		return "cos";
	}

	public void analyse(Stack<IElement> elements, IIdentifiants ids)
			throws NoSuchElementException {
		// TODO Auto-generated method stub

	}

}
