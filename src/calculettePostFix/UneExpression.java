package calculettePostFix;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

import calculette.IElement;
import calculette.IExpression;
import calculette.IIdentifiants;
import calculette.IPile;

public class UneExpression implements IExpression {

	private Stack<IElement> mExpression;
	
	public UneExpression(Stack<IElement> mExpression) {
		super();
		this.mExpression = mExpression;
	}

	public void analyse(IIdentifiants ids) throws NoSuchElementException {
		// TODO Auto-generated method stub

	}

	public double calcule(IPile pile, IIdentifiants ids) {
		return calcule(pile, ids, false);
	}

	public double calcule(IPile pile, IIdentifiants ids, boolean displaySteps) {

		for( Iterator<IElement> iter = mExpression.iterator(); iter.hasNext(); ) {
			IElement element = iter.next();
			if( displaySteps ) { System.out.println("Pile avant : " + pile.toString()); }

			if( displaySteps ) { System.out.println("Processing element : " + element.toStringInfix(null)); }
			pile.ajoute(element.calcule(pile, ids));

			if( displaySteps ) { System.out.println("Pile après : " + pile.toString()); }
		}

		return pile.retire();
	}

	public String toStringInfix() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean estVide() {
		// TODO Auto-generated method stub
		return false;
	}

}
