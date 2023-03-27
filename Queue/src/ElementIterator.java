import java.util.Iterator;
import java.util.Vector;

public class ElementIterator<E> implements Iterator<E> {
	
	private Vector<E> elements;

	public ElementIterator(Vector<E> elements) {
		this.elements = elements;
	}
	
	@Override
	public boolean hasNext() {
		return (!elements.isEmpty());
	}

	@Override
	public E next() {
		E element = this.elements.remove(0);
		return element;
	}

}
