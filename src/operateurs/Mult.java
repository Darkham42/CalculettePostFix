package operateurs;

import java.util.NoSuchElementException;
import java.util.Stack;

import calculette.IElement;
import calculette.IIdentifiants;
import calculette.IPile;
import calculette.binaires.IMultiplication;

public class Mult implements IMultiplication {

	public Double calcule(IPile evaluations, IIdentifiants ids)
			throws IllegalStateException {

		Double arg1 = evaluations.retire();
		Double arg2 = evaluations.retire();
		Double resultat = arg1 * arg2;

		return resultat;
	}

	public String toStringInfix(Stack<String> chaines) {
		return "*";
	}

	public void analyse(Stack<IElement> elements, IIdentifiants ids)
			throws NoSuchElementException {
		// TODO Auto-generated method stub

	}

}
