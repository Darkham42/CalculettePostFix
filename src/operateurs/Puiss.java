package operateurs;

import java.util.NoSuchElementException;
import java.util.Stack;

import calculette.IElement;
import calculette.IIdentifiants;
import calculette.IPile;
import calculette.binaires.IPuissance;

public class Puiss implements IPuissance {

	public Double calcule(IPile evaluations, IIdentifiants ids)
			throws IllegalStateException {

		Double arg1 = evaluations.retire();
		Double arg2 = evaluations.retire();
		Double resultat = Math.pow(arg2, arg1);

		return resultat;
	}

	public String toStringInfix(Stack<String> chaines) {
		return "^";
	}

	public void analyse(Stack<IElement> elements, IIdentifiants ids)
			throws NoSuchElementException {
		// TODO Auto-generated method stub

	}

}
