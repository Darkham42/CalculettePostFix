package calculettePostFix;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

import calculette.IElement;
import calculette.IExpression;
import calculette.IIdentifiants;
import calculette.IPile;

/**
 * La classe <b>UneExpression</b> permet de gérer une expression
 * @author Thomas
 *
 */
public class UneExpression implements IExpression {

	//Définition d'une expression
	private Stack<IElement> mExpression;
	
	//Initialisation d'une expression
	public UneExpression(Stack<IElement> mExpression) {
		super();
		this.mExpression = mExpression;
	}

	/**
	 * Permet de ...
	 */
	public void analyse(IIdentifiants ids) throws NoSuchElementException {
		// TODO Auto-generated method stub

	}

	/**
	 * Permet d'effectuer le calcul entre deux valeurs suivant l'opérateur
	 */
	public double calcule(IPile pile, IIdentifiants ids) {
		return calcule(pile, ids, false);
	}

	/**
	 * Permet d'afficher lévolution de la pile durant le calcul
	 * @param pile
	 * @param ids
	 * @param displaySteps
	 * @return
	 */
	public double calcule(IPile pile, IIdentifiants ids, boolean displaySteps) {
		System.out.println("Expression : " + toStringInfix() + " with " + ids);

		for( Iterator<IElement> iter = mExpression.iterator(); iter.hasNext(); ) {
			IElement element = iter.next();
			if( displaySteps ) { System.out.println("Pile avant : " + pile.toString()); }

			if( displaySteps ) { System.out.println("Processing element : " + element.toString()); }
			pile.ajoute(element.calcule(pile, ids));

			if( displaySteps ) { System.out.println("Pile après : " + pile.toString()); }
		}

		return pile.retire();
	}

	/**
	 * Permet la construction de l'expression sous la forme Infix
	 */
	public String toStringInfix() {
		if( mExpression != null ) {
			Stack<String> chaines = new Stack<String>();
			
			for( Iterator<IElement> iter = mExpression.iterator(); iter.hasNext(); ) {
				IElement element = iter.next();
				chaines.push(element.toStringInfix(chaines));
			}
			
			StringBuffer sb = new StringBuffer();
			for( Iterator<String> iter = chaines.iterator(); iter.hasNext(); ) {
				String s = iter.next();
				sb.append(s);
			}
			return sb.toString();
		}
		return "";
	}

	/**
	 * Permet de vérifier si l'expression est vide
	 */
	public boolean estVide() {
		return mExpression.empty();
	}

}
