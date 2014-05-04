package calculette;

import java.util.NoSuchElementException;

/**
 * Représente une expression post-fixée.
 */
public interface IExpression {

	/**
	 * Analyse cette expression et vérifie si elle est légale. Répertorie les
	 * identifiants dont elle a besoin.
	 * 
	 * @param ids
	 *            les identifiants en cours. Sera éventuellement modifié par
	 *            l'ajout de nouveaux identifiants.
	 * @throws NoSuchElementException
	 *             si cette expression est incorrecte.
	 */
	public void analyse(IIdentifiants ids) throws NoSuchElementException;

	/**
	 * Calcule la valeur de cette expression
	 * 
	 * @param pile
	 *            la pile d'évaluation. Sera modifiée par l'expression
	 * @param ids
	 *            les identifiants connus
	 * @return la valeur de cette expression
	 * @throws IllegalStateException
	 *             si l'expression est incalculable
	 */
	public double calcule(IPile pile, IIdentifiants ids);

	/**
	 * Construit une représentation infixe de cette expression
	 * 
	 * @return la chaîne représentant cette expression de manière infixe.
	 */
	public String toStringInfix();

	/**
	 * Construit une représentation postfixe de cette expression
	 * 
	 * @return la chaîne représentant cette expression de manière postfixe.
	 */
	@Override
	public String toString();

	/**
	 * Teste si l'expression est vide.
	 * 
	 * @return vrai ssi cette expression ne contient aucun élément.
	 */
	public boolean estVide();

}