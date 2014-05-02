package calculettePostFix;

import java.util.Scanner;

import calculettePostFix.Duracell;

public class Main {
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		try {
			double formule = Double.NaN;
			do {
				formule = getValue();
			} while (Double.isNaN(formule));
			System.out.println("Vous avez saisi : " + formule);
			Duracell pile = new Duracell();
			System.out.println(pile.estVide());
			pile.ajoute(formule);
			System.out.println(pile.estVide());
			pile.ajoute(42D);
			System.out.println(pile.estVide());
			pile.retire();
			pile.retire();
			System.out.println(pile.estVide());
		}
		catch (Exception e) {
            System.out.println("Exception inconnue : \n" + e.toString());
        }
	}
		
	private static Double getValue() {
		try {
			System.out.println("Veuillez saisir un chiffre :");
			return scan.nextDouble();
		}
		catch (Exception e) {
			System.out.println("Valeur invalide : " + scan.nextLine());
			return Double.NaN;
		}
	}
}