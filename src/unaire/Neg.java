package unaire;

import java.util.NoSuchElementException;
import java.util.Stack;

import calculette.IElement;
import calculette.IIdentifiants;
import calculette.IPile;
import calculette.unaires.INeg;

public class Neg implements INeg {

	public Double calcule(IPile evaluations, IIdentifiants ids)
			throws IllegalStateException {
		
		Double nombre = evaluations.retire();
		Double resultat = -nombre;

		return resultat;
	}

	public String toStringInfix(Stack<String> chaines) {
		return "neg";
	}

	public void analyse(Stack<IElement> elements, IIdentifiants ids)
			throws NoSuchElementException {
		// TODO Auto-generated method stub

	}

}
