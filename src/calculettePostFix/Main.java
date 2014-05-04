package calculettePostFix;

import java.util.Scanner;
import java.util.Stack;

import operateurs.*;
import unaire.*;
import calculette.*;

public class Main {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// Test Apperture = new Test();

		String pileCalc = null, restart = null;
		Stack<IElement> stack = new Stack<IElement>();
		
		do {
		do {
			System.out.println("Voulez-vous afficher la pile des calculs effectués ? (Oui/Non) : ");
			pileCalc = scan.nextLine();
			pileCalc = pileCalc.toLowerCase();
		} while (!("oui".equalsIgnoreCase(pileCalc) || "non".equalsIgnoreCase(pileCalc)));

		boolean affichage_pile = "oui".equalsIgnoreCase(pileCalc);

		System.out.println("Veuillez saisir l'expression");
		String line = scan.nextLine();
		System.out.println("Expression à calculer : " + line );
		
		// on découpe en morceau la chaine
		for(String token : line.split(" ") ) {
			IElement result = addElement(token);
			if( result != null ) {
				stack.push(result);
			}
		}
		
		// on vérifie l'expression créé
		try {
			// Variable pour les calculs
			Duracell pile = new Duracell();
			Identifiants ids = new Identifiants();

			UneExpression une = new UneExpression(stack);
			
			une.analyse(ids);
			System.out.println("Analyse passée");

			System.out.println("Expression parsée : " + une.toStringInfix());
				
			// calcul
			double result = une.calcule(pile, ids, affichage_pile);
			System.out.println("Resultat : " + result);
		} catch (Exception e) {
			System.out.println("Unknown exception : \n" + e.toString());
		}
		
		//plusieurs calculs
		System.out.println("Voulez vous effectuer un nouveau calcul ? (Oui/Non) : ");
		restart= scan.nextLine();
		restart = restart.toLowerCase();
	} while ("oui".equalsIgnoreCase(restart));
		System.out.println("Au revoir");
	}

	
	private static IElement addElement(String element) {
		switch (element) {
		case "+":
			return new Add();
		case "-":
			return new Sous();
		case "*":
			return new Mult();
		case "/":
			return new Div();
		case "^":
			return new Puiss();
		case "cos":
			return new Cos();
		case "neg":
			return new Neg();
		}
		try {
			Double temp = Double.valueOf(element);
			return new Nombre(temp);
		} catch (Exception e) {
			System.out.println("Unknown exception : \n" + e.toString());
		}
		return null;
	}
}