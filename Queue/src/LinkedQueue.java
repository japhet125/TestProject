import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Vector;

public class LinkedQueue<E> implements QueueInterface<E> {
	
	private Node<E> front = null;
	private Node<E> back = null;
	private int count = 0;

	@Override
	public Iterator<E> iterator() {
		Vector<E> vector = new Vector<E>(this.count);
		Node<E> curNode = this.front;
		while (curNode != null) {
			vector.addElement(curNode.getElement());
			curNode = curNode.getNext();
		}
		ElementIterator<E> iterator = new ElementIterator<E>(vector);
		return iterator;
	}

	@Override
	public boolean isEmpty() {
		return (this.count == 0);
	}

	@Override
	public int size() {
		return this.count;
	}

	@Override
	public QueueInterface<E> copy() {
		QueueInterface<E> newQueue= new LinkedQueue<E>();
		Node<E> curNode =this.front;
		while(curNode!=null) {
			newQueue.enqueue(curNode.getElement());
			curNode= curNode.getNext();
		}
		return newQueue;
	
	}

	@Override
	public void enqueue(E element) throws IllegalStateException, NullPointerException {
		if (element != null) {
			Node<E> newNode = new Node<E>(element);
			if (this.isEmpty()) {
				this.front = newNode;
				this.back = newNode;
			} else {
				this.back.setNext(newNode);
				newNode.setPrevious(this.back);
				this.back = newNode;
			}
			this.count++;
		} else {
			throw new NullPointerException("Unable to add null element to LinkedQueue");
		}
	}

	@Override
	public E peek() {
		if (this.isEmpty()) {
			return null;
		} else {
			return this.front.getElement();
		}

	}

	@Override
	public E dequeue() {
		if (this.isEmpty()) {
			return null;
		} else {
			E element = this.front.getElement();
			if (this.count > 1) {
				Node<E> newFront = this.front.getNext();
				newFront.setPrevious(null);
				this.front = newFront;
				this.count--;
			} else {
				this.removeAll();
			}
			return element;
		}
	}

	@Override
	public E dequeue(int index) throws NoSuchElementException {
		if (this.isValidIndex(index)) {
			if (index == 0) {
				return this.dequeue();
			} else if (index == this.count - 1) {
				E element = this.back.getElement();
				Node<E> previous = this.back.getPrevious();
				this.back = previous;
				this.back.setNext(null);
				this.count--;
				return element;
			} else {
			   Node<E> curNode = this.front;
			   int curIndex = 0;
			   while (curIndex != index) {
					curNode = curNode.getNext();
					curIndex++;
				}
//					Node<E> previous = curNode.getPrevious();
//					Node<E> next = curNode.getNext();
//					previous.setNext(next);
//					next.setPrevious(previous);
				E element = this.back.getElement();
				curNode.getPrevious().setNext(curNode.getNext());
				curNode.getNext().setPrevious(curNode.getPrevious());
				this.count--;
				return element;
			}
		} else {
			throw new NoSuchElementException("Invalid index = " + index + " No Such Element In LinkedQueue");
		}
	}

	@Override
	public void removeAll() {
		this.front = null;
		this.back = null;
		this.count = 0;
	}

	
	@Override
	public String toString() {
		String s = new String("LinkedQueue\n");
		if (this.front != null) {
			s = s + "Front: " + this.front.getElement() + "\n";
		} else {
			s = s + "Front: null\n";
		}
		if (this.back != null) {
			s = s + "Back:  " + this.back.getElement() + "\n";
		} else {
			s = s + "Back:  null\n";
		}
		s = s + "Count: " + this.count + "\n";
		s = s + "Elements: {";
		Node<E> curNode = this.front;
		while (curNode != null) {
			s = s + curNode.getElement();
			if (curNode != this.back) {
				s = s + ", ";
			}
			curNode = curNode.getNext();
		}
		s = s + "}";
		return s;
	}

	private boolean isValidIndex (int index) {
		return ((index >= 0) && (index < this.count));
	}

	
}

