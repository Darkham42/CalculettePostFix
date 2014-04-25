package calculettePostFix;

import java.util.NoSuchElementException;
import java.util.Stack;

import calculette.IElement;
import calculette.IPile;

/**
 * La classe <b>Duracell</b> permet de gérer la pile
 * @author Thomas
 *
 */
public class Duracell implements IPile {

	//Définition d'une pile
	private Stack<IElement> pile;
	
	//Initialisation de la pile
	public Duracell() {
		super();
		this.pile = new Stack<IElement>();
	}
	/**
	 * On ajoute un nombre à la pile
	 */
	public void ajoute(Double valeur) {
		UnElement nombre = new UnElement(valeur);
		pile.add(nombre);
	}

	/**
	 * On retire le dernier nombre placé dans la pile
	 */
	public Double retire() throws NoSuchElementException {
		if (pile.empty()) {
			throw new NoSuchElementException();
		}
		else {
			UnElement supPile = (UnElement) pile.pop();
			return supPile.getNombre();	
		}
	}

	/**
	 * On test si la pile est vide
	 */
	public boolean estVide() {
		return pile.empty();
	}
}
