/**
 * 
 */
package calculette;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * @author mathieu
 *
 */
public class Nombre implements INombre {

	private Double mValue;
	
	public Nombre(Double value) {
		mValue = value;
	}

	/* (non-Javadoc)
	 * @see calculette.INombre#calcule(calculette.IPile, calculette.IIdentifiants)
	 */
	public Double calcule(IPile evaluations, IIdentifiants ids)
			throws NoSuchElementException {

		return mValue;
	}

	/* (non-Javadoc)
	 * @see calculette.INombre#toStringInfix(java.util.Stack)
	 */
	public String toStringInfix(Stack<String> chaines) {
		return mValue.toString();
	}

	/* (non-Javadoc)
	 * @see calculette.INombre#analyse(java.util.Stack, calculette.IIdentifiants)
	 */
	public void analyse(Stack<IElement> elements, IIdentifiants ids)
			throws IllegalStateException {

		// rien à effectuer pour l'analyse
	}

}
