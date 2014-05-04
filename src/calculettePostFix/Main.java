package calculettePostFix;

import java.io.*;
import java.util.*;

import operateurs.*;
import unaire.*;
import calculette.*;

public class Main {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// Test Apperture = new Test();

		String pileCalc = null, restart = null;

		do {
			do {
				System.out
						.println("Voulez-vous afficher la pile des calculs effectués ? (Oui/Non) : ");
				pileCalc = scan.nextLine();
				pileCalc = pileCalc.toLowerCase();
			} while (!("oui".equalsIgnoreCase(pileCalc) || "non"
					.equalsIgnoreCase(pileCalc)));

			boolean affichage_pile = "oui".equalsIgnoreCase(pileCalc);

			// Variable pour les calculs
			Duracell pile = new Duracell();
			Identifiants ids = new Identifiants();

			UneExpression une = lireExpression(ids, null);
			// on vérifie l'expression créé
			try {
				une.analyse(ids);
				
				// on copie l'expression dans le fichier txt
				resTXT("\r\nExpression à calculer : " + une.toStringInfix() + " = ");

				// calcul
				double result = une.calcule(pile, ids, affichage_pile);
				System.out.println("Resultat : " + result + ids);
				resTXT(new Double(result).toString() + ids.toString());
			} catch (NoSuchElementException e) {
				// en cas d'anomalie lors de l'analyse ou du calcul de
				// l'expression
				System.out.println("Unknown exception : \n" + e.toString());
			} catch (DivideByZeroException e) {
				errorsTXT("\r\nL'expression : " + une.toStringInfix()
						+ " impossible de diviser par 0\n");
			} catch (Exception e) {
				System.out.println("Unknown exception : \n" + e.toString());
			}

			// plusieurs calculs
			System.out
					.println("Voulez vous effectuer un nouveau calcul ? (Oui/Non) : ");
			restart = scan.nextLine();
			restart = restart.toLowerCase();
		} while ("oui".equalsIgnoreCase(restart));
		System.out.println("Au revoir");
	}

	private static UneExpression lireExpression(IIdentifiants ids,
			String variable) {
		Stack<IElement> stack = new Stack<IElement>();

		System.out.println("Veuillez saisir l'expression");
		String line = scan.nextLine();
		System.out.println("Expression à calculer : " + line);

		// on découpe en morceau la chaine
		for (String token : line.split(" ")) {
			IElement result = addElement(token, ids);
			if (result != null) {
				stack.push(result);
			}
		}

		// Si l'expression contient des variables, il faut demander leur
		// définition
		if (ids.getNombre() > 0 && variable == null) {
			Set<String> noms = ids.getAll();
			for (Iterator<String> iter = noms.iterator(); iter.hasNext();) {
				String name = iter.next();
				if (name.equals(variable)) {
					// on ne peut pas rentrer l'expression de la même variable
					System.out.println("variable " + name
							+ " en cours de traitement ");
				} else {
					// il faut vérifier si la variable a déjà été rentrée
					if (ids.get(name).estVide()) {
						System.out
								.println("Veuillez saisir la valeur de la variable "
										+ name + " : ");
						ids.set(name, lireExpression(ids, name));
					} else {
						System.out.println("La valeur de la variable " + name
								+ " est déjà rentrée : "
								+ ids.get(name).toStringInfix());
					}
				}
			}
		}

		System.out.println("fin de traitement de l'expresion");
		return new UneExpression(stack);
	}

	private static IElement addElement(String element, IIdentifiants ids) {
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

		// on essaie de parser l'element en un nombre
		try {
			Double temp = Double.valueOf(element);

			// le parsing a reussi, on retourne un Element Nombre
			return new Nombre(temp);
		} catch (Exception e) {
			// le parsing n'a pas réussi, ce n'est pas un nombre, on passe au
			// traitement suivant (= les variables)
			// a enlever avant de livrer le projet :)
			// System.out.println("Unknown exception : \n" + e.toString());
			// test pour verifier si l'element ne contient que des lettres (nom
			// d'une variable)
			if (element.matches("[a-zA-Z]+")) {
				ids.ajoute(element);
				return new Variable(element);
			}
		}
		return null;
	}

	private static void resTXT(String texte) {
		logTXT("Résultats.txt", texte);
	}

	private static void errorsTXT(String texte) {
		logTXT("Erreurs.txt", texte);
	}

	// sous fonction pour alléger le code
	private static void logTXT(String nom_fichier, String texte) {
		File logFile = new File(nom_fichier);
		BufferedWriter writer = null;

		try {
			writer = new BufferedWriter(new FileWriter(logFile, true));
			writer.write(texte);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// On ferme le fichier quoi qu'il advienne
				writer.close();
			} catch (Exception e) {
				System.out.println("Impossible de créer le fichier");
			}
		}
	}
}