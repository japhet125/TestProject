
public class BetterArray <I>{
private int INITIAL_ARRAY_SIZE = 100;
	
	private Object[] myArray = new Object[INITIAL_ARRAY_SIZE];
	private int numElements = 0;
	
	
	public int size() {
		return this.numElements;
	}
	
	public boolean isEmpty() {
		return (this.numElements == 0);
	}
	
	public void add(I element) {
		if (isArrayFull()) {
			this.resizeArray();
 		} 
		this.myArray[this.numElements++] = element;
	}
	
	public void add(I element, int index) throws IndexOutOfBoundsException {
		if (isValidIndex(index)) {
			if (isArrayFull()) {
				this.resizeArray();
	 		} 	
			for ( int i = this.numElements ; i > index ; i-- ) {
				this.myArray[i] = this.myArray[i-1];
			}
			this.myArray[index] = element;
			this.numElements++;
		} else if (index == this.numElements) {
			this.add(element);
		} else {
			throw new IndexOutOfBoundsException("index = " + index + " is invalid");
		}
	}
	
	public I get(int index) throws IndexOutOfBoundsException {
		if (isValidIndex(index)) {
			return (I) this.myArray[index];
		} else {
			throw new IndexOutOfBoundsException("index = " + index + " is invalid");
		}
	}
	
	public I replace(I element, int index) throws IndexOutOfBoundsException {
		if (isValidIndex(index)) {
			I elementToReturn = (I) this.myArray[index];
			this.myArray[index] = element;
			return elementToReturn;
		} else {
			throw new IndexOutOfBoundsException("index = " + index + " is invalid");
		}
	}

	public I remove(int index) {
		if (isValidIndex(index)) {
			I element = (I) this.myArray[index];
			for ( int i = index+1 ; i < numElements ; i++ ) {
				this.myArray[i-1] = this.myArray[i];
			}
			this.numElements--;
			return element;
		} else {
			throw new IndexOutOfBoundsException("index = " + index + " is invalid");
		}
	}
	
	
	public void removeAll() {
		for ( int i = 0 ; i < this.myArray.length ; i++ ) {
			this.myArray[i] = 0;
		}
		this.numElements = 0;
	}
	
	public void swap(int index1, int index2) {
		if (isValidIndex(index1) && isValidIndex(index2) && (index1 != index2)) {
			I temp = (I) this.myArray[index1];
			this.myArray[index1] = this.myArray[index2];
			this.myArray[index2] = temp;
		}
	}

	@Override
	public String toString() {
		String s = "BetterArray: \n myArray.length = " + this.myArray.length +  "\n numElements = " + this.numElements + "\n{";
		for ( int i = 0 ; i < this.numElements ; i++ ) {
			s = s + this.myArray[i];
			if (i != this.numElements - 1) {
				s = s + ", ";
			}
		}
		s = s + "}";
		return s;
	}
		
	/********************************/
	/*     private methods          */
	/********************************/

	private void resizeArray() {
		Object[] newArray = new Object[this.myArray.length * 2];
		for ( int i = 0 ; i < this.myArray.length ; i++ ) {
			newArray[i] = this.myArray[i];
		}
		this.myArray = newArray;
	}
	
	private boolean isArrayFull() {
		if (this.numElements >= this.myArray.length) {
			return true;
 		} else {
 			return false;
 		}
	}
	
	private boolean isValidIndex(int index) {
		if ((index >= 0) && (index < this.numElements)) {
			return true;
		} else {
			return false;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}