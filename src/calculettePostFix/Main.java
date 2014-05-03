package calculettePostFix;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

import operateurs.Add;
import operateurs.Div;
import operateurs.Mult;
import operateurs.Sous;
import unaire.Cos;
import unaire.Neg;
import calculette.IElement;
import calculette.IIdentifiants;
import calculette.IPile;
import calculette.Nombre;

public class Main {
	static Scanner scan = new Scanner(System.in);
	
	public static boolean testIds() {
		Stack<IElement> expression = new Stack<IElement>();
		Duracell pile = new Duracell();
		IIdentifiants ids = new Identifiants();

		// déclaration de la variable a
		Identifiants.ajoute("a");

		Stack<IElement> expression_var = new Stack<IElement>();
		expression_var.push(new Nombre(1D));
		Identifiants.set("a", new UneExpression(expression_var));
		
		expression.push(new Variable("a"));
		UneExpression _expression = new UneExpression(expression);
		
		return _expression.calcule(pile, ids) == (1D);
	}

	public static boolean testAdd() {
		Stack<IElement> expression = new Stack<IElement>();
		Duracell pile = new Duracell();

		expression.push(new Nombre(1D));
		expression.push(new Nombre(2D));
		expression.push(new Add());

		UneExpression _expression = new UneExpression(expression);
		
		return _expression.calcule(pile, null) == (1D + 2D);
	}
	
	public static boolean testSous() {
		Stack<IElement> expression = new Stack<IElement>();
		Duracell pile = new Duracell();

		expression.push(new Nombre(1D));
		expression.push(new Nombre(2D));
		expression.push(new Sous());
		
		UneExpression _expression = new UneExpression(expression);
		return _expression.calcule(pile, null, true) == (1D - 2D);
	}

	public static boolean testMult() {
		Stack<IElement> expression = new Stack<IElement>();
		Duracell pile = new Duracell();

		expression.push(new Nombre(3D));
		expression.push(new Nombre(2D));
		expression.push(new Mult());
		
		UneExpression _expression = new UneExpression(expression);
		return _expression.calcule(pile, null) == (3D * 2D);
	}

	public static boolean testDiv() {
		Stack<IElement> expression = new Stack<IElement>();
		Duracell pile = new Duracell();

		expression.push(new Nombre(3D));
		expression.push(new Nombre(2D));
		expression.push(new Div());
		
		UneExpression _expression = new UneExpression(expression);
		return _expression.calcule(pile, null) == (3D / 2D);
	}

	public static boolean testNeg() {
		Stack<IElement> expression = new Stack<IElement>();
		Duracell pile = new Duracell();

		expression.push(new Nombre(3D));
		expression.push(new Neg());
		
		UneExpression _expression = new UneExpression(expression);
		return _expression.calcule(pile, null) == (-3D);
	}

	public static boolean testCos() {
		Stack<IElement> expression = new Stack<IElement>();
		Duracell pile = new Duracell();

		expression.push(new Nombre(3D));
		expression.push(new Cos());
		
		UneExpression _expression = new UneExpression(expression);
		return _expression.calcule(pile, null) == (Math.cos(3D));
	}

	public static void main(String[] args) {
		try {
			System.out.println("Test + : " + testAdd());
			System.out.println("Test / : " + testDiv());
			System.out.println("Test - : " + testSous());
			System.out.println("Test * : " + testMult());
			System.out.println("Test ^ : " + testAdd());
			System.out.println("Test neg : " + testNeg());
			System.out.println("Test cos: " + testCos());
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