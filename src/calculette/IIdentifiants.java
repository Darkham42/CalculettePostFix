package calculette;

import java.util.NoSuchElementException;
import java.util.Set;

/**
 * Mémorise les identifiants et leur valeur
 */
public interface IIdentifiants {

	/**
	 * Retourne le nombre d'identifiants définis
	 * 
	 * @return le nombre d'identifiants définis
	 */
	public int getNombre();

	/**
	 * Ajoute un identifiant à l'ensemble des identifiants connus. Un appel à
	 * {@link #get(String)} doit alors retourner {@code null} pour cet
	 * identifiant.
	 * 
	 * @param id
	 *            le nom de l'identifiant à ajouter
	 * @throws IllegalAccessError
	 *             si l'identifiant est déjà présent
	 */
	public void ajoute(String id) throws IllegalAccessError;

	/**
	 * Affecte une expression à un identifiant donné par son numéro.
	 * 
	 * @param idx
	 *            le numéro de l'identifiant à modifier
	 * @param valeur
	 *            la valeur de l'expression à stocker
	 * @return le nom de l'identifiant défini
	 */
	public String set(String id, IExpression valeur);

	/**
	 * Retourne la valeur de l'identifiant spécifié.
	 * 
	 * @param id
	 *            l'identifiant à rechercher
	 * @return sa valeur ou {@code null} si elle n'est pas définie.
	 */
	public IExpression get(String id);

	/**
	 * Retourne le nom de toutes les variables connues.
	 * 
	 * @return une liste avec les noms des variables
	 */
	public Set<String> getAll();

	/**
	 * Teste si l'identifiant donné est défini
	 * 
	 * @param id
	 *            le nom de l'identifiant à rechercher
	 * @return vrai si l'identifiant existe
	 */
	public boolean contient(String id);

	/**
	 * Renvoie la valeur calculée d'un identifiant
	 * 
	 * @param pile
	 *            la pile d'évaluation à utiliser
	 * @param id
	 *            le nom de l'identifiant à évaluer
	 * @return la valuer calculée.
	 * @throws NoSuchElementException
	 *             si l'identifiant n'est pas défini.
	 * @throws IllegalStateException
	 *             si l'identifiant n'est pas calculable.
	 */
	public double calcule(IPile pile, String id);

	/**
	 * Teste si un identifiant est calculable
	 * 
	 * @param id
	 *            le nom de l'identifiant à évaluer
	 * @return vrai ssi l'identifiant est défini comme une expression calculable
	 * @throws NoSuchElementException
	 *             si l'identifiant n'est pas défini.
	 */
	public boolean estCalculable(String id);

	/**
	 * Retourne une chaîne listant tous les identifiants dans leur ordre
	 * d'ajout, avec leur expression.
	 * 
	 * @return une chaîne "{ id1=v1, id2=v2, ... }".
	 */
	@Override
	public String toString();

}