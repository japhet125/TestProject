import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Vector;

public class ArrayBasedQueue<E> implements QueueInterface<E> {

	private int MAX_ARRAY_SIZE = 10_000;
	private int INVALID_INDEX = -1;
	private Object[] array;
	
	private int front = INVALID_INDEX;
	private int back = INVALID_INDEX;
	
	private int count = 0;
	
	public ArrayBasedQueue() {
		this.array = new Object[MAX_ARRAY_SIZE];
	}
	
	public ArrayBasedQueue(int size) {
		this.array = new Object[size];
	}
	
	@Override
	public Iterator<E> iterator() {
		Vector<E> vector = new Vector<E>(this.count);
		int curIndex = 0;
		while (curIndex < this.count) {
			int realIndex = this.realIndexAt(this.front, curIndex);
			vector.add((E) this.array[realIndex]);
			curIndex++;
		}
		
		ElementIterator<E> elementIterator = new ElementIterator<E>(vector);
		return elementIterator;
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
		ArrayBasedQueue<E> newQueue= new ArrayBasedQueue<>();
		
			
		for(int i=0; i<count;i++) {
	newQueue.enqueue((E)array[i]);

			}
			return newQueue;
		
	}

	@Override
	public void enqueue(E element) throws IllegalStateException, NullPointerException {
		if (element != null) {
			if (this.isEmpty()) {
				this.array[0] = element;
				this.front = 0;
				this.back = 0;
				this.count++;
			} else {
				if (!this.arrayIsFull()) {
					this.back = this.incrementIndex(this.back);
					this.array[this.back] = element;
					this.count++;
				} else {
					throw new IllegalStateException("Unable to add element to ArrayBasedQueue due to space limitations");
				}
			}
		} else {
			throw new NullPointerException("Unable to add a null element to the queue, operation is not allowed");
		}
	}

	@Override
	public E peek() {
		if (!this.isEmpty()) {
			return (E) this.array[this.front];
		} else {
			return null;
		}
	}

	@Override
	public E dequeue() {
		if (!this.isEmpty()) {
			E element = (E) this.array[this.front];
			this.front = this.incrementIndex(this.front);
			this.count--;
			return element;
		} else {
			return null;
		}
	}

	@Override
	public E dequeue(int index) throws NoSuchElementException {
		if (this.isValidIndex(index)) {
			if (index == 0) {
				E element = this.dequeue();
				return element;
			} else if (index == this.count - 1) {
				E element = (E) this.array[this.back];
				this.back = this.decrementIndex(this.back);
				this.count--;
				return element;
			} else {
				int realIndex = this.realIndexAt(this.front, index);
				E element = (E) array[realIndex];
				int curIndex = index;
				while (curIndex < (this.count - 1)) {
					int destIndex = this.realIndexAt(this.front, curIndex);
					int sourceIndex = this.realIndexAt(this.front, curIndex + 1);
					this.array[destIndex] = this.array[sourceIndex];
					curIndex++;
				}
				this.back = this.decrementIndex(this.back);
				this.count--;
				return element;
			}
		} else {
			throw new NoSuchElementException("Invalid index = " + index + " Queue only has " + this.count + " elements.");
		}
	}

	@Override
	public void removeAll() {
		this.count = 0;
		this.front = INVALID_INDEX;
		this.back = INVALID_INDEX;
	}

	
	
	@Override
	public String toString() {
		String s = new String("ArrayBasedQueue:\n");
		s = s + "Count = " + this.count + "\n";
		if (this.front == INVALID_INDEX) {
			s = s + "Front Index = " + this.front + " \t" + "Front Element = null\n";
		} else {
			if (this.front < 10) {
				s = s + "Front Index = " + this.front + " \t" + "Front Element = " + this.array[this.front] + "\n";
			} else {
				s = s + "Front Index = " + this.front + "\t" + "Front Element = " + this.array[this.front] + "\n";
				
			}
		}
		if (this.back == INVALID_INDEX) {
			s = s + "Back Index  = " + this.back + " \t" +  "Back Element  = null\n{";
		} else {
			if (this.back < 10) {
				s = s + "Back Index  = " + this.back + " \t" +  "Back Element  = " + this.array[this.back] + "\n{";
			} else {
				s = s + "Back Index  = " + this.back + "\t" +  "Back Element  = " + this.array[this.back] + "\n{";
			}
		}
		int curIndex = 0;
		while (curIndex < this.count) {
			int realIndex = this.realIndexAt(this.front, curIndex);
			s = s + this.array[realIndex];
			if (curIndex != this.count - 1) {
				s = s + ", ";
			} 
			curIndex++;
		}
		s = s + "}";
		return s;
	}

	private boolean arrayIsFull() {
		return (this.count == this.array.length);
	}
	
	private int incrementIndex(int index) {
		return ++index % this.array.length;
	}
	
	private int decrementIndex(int index) {
		if (index == 0) {
			return this.array.length - 1;
		} else {
			return --index;
		}
	}
	
	private boolean isValidIndex (int index) {
		return ((index >= 0) && (index < this.count));
	}
	
	private int realIndexAt(int head, int index) {
		return (head + index) % this.array.length;
	}
	
	
	
	
	
	
	
	
	
	
}
