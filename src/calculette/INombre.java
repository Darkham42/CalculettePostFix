package calculette;

import java.util.NoSuchElementException;
import java.util.Stack;

public interface INombre extends IElement {

	public Double calcule(IPile evaluations, IIdentifiants ids)
			throws NoSuchElementException;

	public String toStringInfix(Stack<String> chaines);

	public void analyse(Stack<IElement> elements, IIdentifiants ids)
			throws IllegalStateException;

}
