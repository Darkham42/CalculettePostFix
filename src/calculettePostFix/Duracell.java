package calculettePostFix;

import java.util.NoSuchElementException;
import java.util.Stack;

import calculette.IPile;

/**
 * La classe <b>Duracell</b> permet de gérer la pile
 * 
 * @author Thomas
 * 
 */
public class Duracell implements IPile {

	// Définition d'une pile
	private Stack<Double> mPile;

	// Initialisation de la pile
	public Duracell() {
		super();
		this.mPile = new Stack<Double>();
	}

	/**
	 * On ajoute un nombre à la pile
	 */
	public void ajoute(Double valeur) {
		mPile.add(valeur);
	}

	/**
	 * On retire le dernier nombre placé dans la pile
	 */
	public Double retire() throws NoSuchElementException {
		if (mPile.empty()) {
			throw new NoSuchElementException();
		} else {
			return mPile.pop();
		}
	}

	/**
	 * On test si la pile est vide
	 */
	public boolean estVide() {
		return mPile.empty();
	}

	/**
	 * Affichage de la pile
	 */
	public String toString() {
		return mPile.toString();
	}
}
