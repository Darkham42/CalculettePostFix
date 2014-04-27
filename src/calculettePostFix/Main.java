package calculettePostFix;

import java.util.Scanner;

import calculettePostFix.Duracell;

public class Main {
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Veuillez saisir un chiffre :");
		double formule = scan.nextDouble();
		System.out.println("Vous avez saisi : " + formule);
		Duracell pile = new Duracell();
		pile.estVide();
		pile.ajoute(52D);
		System.out.println("Voici la pile :" + pile);
		pile.estVide();
		pile.ajoute(42D);
		pile.estVide();
		pile.retire();
		pile.retire();
		pile.estVide();
	}
}
