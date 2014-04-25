package calculettePostFix;

import java.util.NoSuchElementException;
import java.util.Stack;

import calculette.IElement;
import calculette.IIdentifiants;
import calculette.IPile;
/**
 * La classe <b>Un élément</b> permet de réprésenter les élements figurant dans la pile
 * @author Thomas
 *
 */
public class UnElement implements IElement {

	private double nombre;
	
	
	public double getNombre() {
		return nombre;
	}
	public void setNombre(double nombre) {
		this.nombre = nombre;
	}
	
	
	//Initialisation d'un nombre
	public UnElement(double nombre) {
		super();
		this.nombre = nombre;
	}

	public double calcule(IPile evaluations, IIdentifiants ids)
			throws IllegalStateException {
		// TODO Auto-generated method stub
		return 0;
	}

	public String toStringInfix(Stack<String> chaines) {
		// TODO Auto-generated method stub
		return null;
	}

	public void analyse(Stack<IElement> elements, IIdentifiants ids)
			throws NoSuchElementException {
		// TODO Auto-generated method stub
	}
}