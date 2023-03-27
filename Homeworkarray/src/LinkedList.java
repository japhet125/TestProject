
public class LinkedList <I extends Comparable <? super I>> implements ListInterface <I> {

	private LinkedListNode<I> first = null;
	private LinkedListNode<I> last = null;
	private int count = 0;
	
	@Override
	public ListInterface<I> copy() {
		ListInterface<I> newList= new LinkedList<I>();
		LinkedListNode<I> curNode =this.first;
		while(curNode!=null) {
			newList.add(curNode.getElement());
			curNode= curNode.getNext();
		}
		return newList;
	}

	@Override
	public int size() {
		return this.count;
	}

	@Override
	public boolean isEmpty() {
		return (this.count == 0);
	}

	@Override
	public void add(I element) {
		LinkedListNode<I> newNode = new LinkedListNode<I>(element);
		if (this.isEmpty()) {
			this.first = newNode;
			this.last = newNode;
		} else {
			this.last.setNext(newNode);
			this.last = newNode;
		}
		this.count++;
	}

	@Override
	public void add(I element, int index) throws IndexOutOfBoundsException {
		if ((this.isEmpty()) && (index == 0)) {
			this.add(element);
		} else if (index == 0) {
			LinkedListNode<I> newNode = new LinkedListNode<I>(element);
			newNode.setNext(this.first);
			this.first = newNode;
			this.count++;
		} else if (this.isValidIndex(index)) {
			LinkedListNode<I> newNode = new LinkedListNode<I>(element);
			LinkedListNode<I> prevNode = null;
			LinkedListNode<I> curNode = this.first;
			int curIndex = 0;
			while (curIndex != index) {
				prevNode = curNode;
				curNode = curNode.getNext();
				curIndex++;
			}
			prevNode.setNext(newNode);
			newNode.setNext(curNode);
			count++;	
		} else if (index == this.count) {
			this.add(element);
		} else {
			throw new IndexOutOfBoundsException("index = " + index + " is invalid");
		}
	}

	@Override
	public void addSorted(I element) {
		if(this.isEmpty()) {
			this.add(element);
		} else {
			LinkedListNode<I> newNode = new LinkedListNode<I>(element);
			LinkedListNode<I> prevNode = null;
			LinkedListNode<I> curNode= this.first;
			while((curNode !=null)&&(curNode.getElement().compareTo(element)<0)) {
				prevNode = curNode;
				curNode= curNode.getNext();
			}
			if(prevNode== null) {
				newNode.setNext(this.first);
				this.first= newNode;
			} else if (curNode==null) {
				prevNode.setNext(newNode);
				this.last= newNode;
			} else {
				prevNode.setNext(newNode);
				newNode.setNext(curNode);
			}
			this.count++;
		}
		
	}

	@Override
	public I get(int index) throws IndexOutOfBoundsException {
		if (this.isValidIndex(index)) {
			LinkedListNode<I> curNode = this.first;
			int curIndex = 0;
			while (curIndex != index) {
				curNode = curNode.getNext();
				curIndex++;
			}
			return curNode.getElement();
		} else {
			throw new IndexOutOfBoundsException("index = " + index + " is invalid");
		}
	}

	@Override
	public I replace(I element, int index) throws IndexOutOfBoundsException {
		if (this.isValidIndex(index)) {
			LinkedListNode<I> curNode = this.first;
			int curIndex = 0;
			while (curIndex != index) {
				curNode = curNode.getNext();
				curIndex++;
			}
			I oldElement = curNode.getElement();
			curNode.setElement(element);
			return oldElement;
		} else {
			throw new IndexOutOfBoundsException("index = " + index + " is invalid");
		}
	}

	@Override
	public I remove(int index) throws IndexOutOfBoundsException {
		if (this.isValidIndex(index)) {
			if (index == 0) {
				I element = this.first.getElement();
				if (this.count == 1) {
					this.removeAll();
				} else {
					this.first = this.first.getNext();
					this.count--;
				}
				return element;
			} else if (index == this.count - 1) {
				LinkedListNode<I> prevNode = null;
				LinkedListNode<I> curNode = this.first;
				int curIndex = 0;
				while (curIndex != index) {
					prevNode = curNode;
					curNode = curNode.getNext();
					curIndex++;
				}
				this.last = prevNode;
				this.last.setNext(null);
				this.count--;
				return curNode.getElement();
			} else {
				LinkedListNode<I> prevNode = null;
				LinkedListNode<I> curNode = this.first;
				int curIndex = 0;
				while (curIndex != index) {
					prevNode = curNode;
					curNode = curNode.getNext();
					curIndex++;
				}
				prevNode.setNext(curNode.getNext());
				this.count--;
				return curNode.getElement();
			}
		} else {
			throw new IndexOutOfBoundsException("index = " + index + " is invalid");
		}
	
	}

	@Override
	public void removeAll() {
		this.first = null;
		this.last = null;
		this.count = 0;
	}

	@Override
	public String toString() {
		String s = new String("Linked List:\n");
		s = s + "Count = " + this.count + "\n";
		s = s + "{";
		LinkedListNode<I> curNode = this.first;
		while (curNode != null) {
			s = s + curNode.getElement();
			if (curNode != this.last) {
				s = s + ", ";
			}
			curNode = curNode.getNext();
		}
		s = s + "}";
		return s;
	}


	private boolean isValidIndex(int index) {
		if ((index >= 0) && (index < this.count)) {
			return true;
		} else {
			return false;
		}
	}

}