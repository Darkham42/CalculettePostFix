package calculettePostFix;

import java.util.NoSuchElementException;
import java.util.Stack;

import calculette.IElement;
import calculette.IIdentifiants;
import calculette.IPile;

public class Variable implements IElement {

	private String mName;

	public Variable(String name) {
		mName = name;
	}

	public Double calcule(IPile evaluations, IIdentifiants ids)
			throws IllegalStateException {
	
		return ids.calcule(evaluations, mName);
	}

	public String toStringInfix(Stack<String> chaines) {
		return mName;
	}

	public String toString() {
		return mName;
	}

	public void analyse(Stack<IElement> elements, IIdentifiants ids)
			throws NoSuchElementException {
		// TODO Auto-generated method stub

	}

}
