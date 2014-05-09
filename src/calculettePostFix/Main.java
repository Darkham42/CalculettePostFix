package calculettePostFix;

import java.util.*;

import operateurs.*;
import unaire.*;
import calculette.*;

public class Main {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// Test AppertureScience = new Test();

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
			// On vérifie l'expression créé
			try {
				// Calcul
				double result = une.calcule(pile, ids, affichage_pile);

				System.out.println("Resultat : " + result + ids);
				LogFile.resTXT("\r\nExpression à calculer : "
						+ une.toStringInfix() + " = "
						+ new Double(result).toString() + ids.toString());
			} catch (NoSuchElementException e) {
				// En cas d'anomalie lors de l'analyse
				// Ou lors du calcul de l'expression
				LogFile.errorsTXT("Unknown exception : \n" + e.toString());
			} catch (DivideByZeroException e) {
				LogFile.errorsTXT("\r\nL'expression : " + une.toStringInfix()
						+ " impossible de diviser par 0\n");
			} catch (OperatorMissException e) {
				LogFile.errorsTXT("\r\n Il semble manquer un opérateur à l'expression : "
						+ une.toStringInfix());
			} catch (Exception e) {
				System.out.println("Unknown exception : \n" + e.toString());
			}

			// Pour permettre à l'utilisateur d'effectuer plusieurs calculs
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

		System.out.println("Veuillez saisir l'expression :");
		String express = scan.nextLine();
		String lastToken = null;
		System.out.println("Expression à calculer : " + express);

		try {
			// On découpe en morceau l'expression
			for (String token : express.split(" ")) {
				lastToken = token; // On garde le dernier élément au cas où
									// c'est un mauvais caractère
				IElement result = addElement(token, ids);
				if (result != null) {
					stack.push(result);
				}
			}

			// Dans le cas où l'expression contient des variables
			// On demande leur définition
			if (ids.getNombre() > 0 && variable == null) {
				Set<String> noms = ids.getAll();
				for (Iterator<String> iter = noms.iterator(); iter.hasNext();) {
					String name = iter.next();
					if (name.equals(variable)) {
						// On ne peut pas rentrer l'expression de la même
						// variable
						System.out.println("variable " + name
								+ " en cours de traitement ");
					} else {
						// On vérifie si la variable a déjà été rentrée
						if (ids.get(name).estVide()) {
							System.out
									.println("Veuillez saisir la valeur de la variable "
											+ name + " : ");
							ids.set(name, lireExpression(ids, name));
						} else {
							System.out.println("La valeur de la variable "
									+ name + " est déjà rentrée : "
									+ ids.get(name).toStringInfix());
						}
					}
				}
			}

			UneExpression resultat = new UneExpression(stack);
			resultat.analyse(ids);
			return resultat;
		} catch (ArgumentMissException e) {
			LogFile.errorsTXT("\r\n Il semble manquer un argument à l'expression : "
					+ express + "\n");
		} catch (CharInvalidException e) {
			LogFile.errorsTXT("\r\n L'expression : " + express
					+ " contient un caractère non valide (" + lastToken + ")\n");
		}

		return lireExpression(ids, variable);
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

		// On essaie de parser l'element en un nombre
		try {
			Double temp = Double.valueOf(element);

			// Le parsing a reussi, on retourne un Element Nombre
			return new Nombre(temp);
		} catch (Exception e) {

			// On effectue un test afin de vérifier si l'élément ne contient que
			// des lettres (Nom d'une Variable !)
			if (element.matches("[a-zA-Z]+")) {
				ids.ajoute(element);
				return new Variable(element);
			}
		}

		// Element inconnu dans l'expression
		throw new CharInvalidException();
	}
}