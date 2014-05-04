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
	 * Permet de tester si l'expression est bien formé
	 */
	public void analyse(IIdentifiants ids) throws NoSuchElementException {
		try {
			// une copie de la pile pour vérifier l'expression
			Stack<IElement> copie = (Stack<IElement>) mExpression.clone();
			
			// on dépile le premier element
			IElement premier = copie.pop();
			
			// on démarre l'analyse. En cas d'erreur, une exception est généréee
			premier.analyse(copie, ids);
		} catch(Exception e) {
			// on ignore la 1ere execption et on lance celle-ci
			throw new NoSuchElementException();
		}
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
			pile.ajoute(element.calcule(pile, ids));

			if( displaySteps ) { System.out.println("Pile après : " + pile.toString()); }
		}

		// test à ajouter : est-ce qu'il reste uniquement un seul element dans la pile ?
		double resultat = pile.retire();
		
		if( !pile.estVide() ) {
			System.out.println("Attention, l'expression semble incomplète, il reste des éléments sur la pile de calcul");
		}
		return resultat;
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
		if( mExpression != null) {
			return mExpression.empty();
		}
		return true;
	}

}
