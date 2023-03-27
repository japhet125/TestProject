import java.util.Collections;

public class ArrayBasedList <I extends Comparable <? super I>> implements ListInterface <I> {
	private int INITIAL_ARRAY_SIZE= 100;
	private Object[] myArray= new Object[INITIAL_ARRAY_SIZE];
	private int numElements=0;


	@Override
	public void add(I element) {
		if(isArrayFull()) {
			this.resizeArray();
		}
		this.myArray[this.numElements++]= element;
		
		
	}

	@Override
	public void add(I element, int index) throws IndexOutOfBoundsException {
		if(isValidIndex(index)) {
			if(isArrayFull()) {
				this.resizeArray();
			}
			for (int i= this.numElements; i>index; i--) {
				this.myArray[i]= myArray[i-1];
			}
			this.myArray[index]= element;
			this.numElements++;
		} else if(index== this.numElements) {
			this.add(element);
	}else {
		throw new IndexOutOfBoundsException("index ="+ index +"is invalid");
	}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void addSorted(I element) {
		
		if(isArrayFull()) {
			this.resizeArray();
		}
		
		if(this.isEmpty()) {
			this.add(element);
		} else {
			int i=0;
			// elements=5
			// 1 2 3 4 5  6  7  8 
			// compareTo return 1 when left element is greater
			while(i<numElements) {
				
				if(myArray[i]==null || element.compareTo((I)myArray[i])<0) {
					break;
				}
				i++;
			}
			
			/*if(i==numElements) {
		
				myArray[i]=element;
				numElements++;
			}
			else {
				
				//i
				int j=numElements-1;
				// 1 2 3 5 6 7  8
				while(j>i) {
					myArray[j]=myArray[j-1];
					j--;
				}
				myArray[i]=element;
				numElements++;
			}
			*/
			add(element,i);
			}
	}
	@Override
	public ListInterface<I> copy() {
		ArrayBasedList<I> newList= new ArrayBasedList<>();
	//	int i=0;
		//while(i<numElements) {
			for(int i=0; i<numElements;i++) {
newList.add((I)myArray[i]);

		}
		return newList;
	
	}

	@SuppressWarnings("unchecked")
	@Override
	public I get(int index) throws IndexOutOfBoundsException{
		if (isValidIndex(index)) {
			return (I) this.myArray[index];
		} else {
			throw new IndexOutOfBoundsException("index = " + index + " is invalid");
		}
		
	}

	@Override
	public boolean isEmpty() {
		
		return (this.numElements==0);
	}

	@Override
	public I remove(int index) throws IndexOutOfBoundsException {
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

	@Override
	public void removeAll() {
		for ( int i = 0 ; i < this.myArray.length ; i++ ) {
			this.myArray[i] = 0;
		}
		this.numElements = 0;
		
	}

	@Override
	public I replace(I element, int index) {
		if (isValidIndex(index)) {
			I elementToReturn = (I) this.myArray[index];
			this.myArray[index] = element;
			return elementToReturn;
		} else {
			throw new IndexOutOfBoundsException("index = " + index + " is invalid");
		}
	}

	@Override
	public int size() {

		return this.numElements;
	}
	private boolean isArrayFull() {
		if(this.numElements>= this.myArray.length) {
			return true;
		}
		else {
			return false;
		}
	}
	private void resizeArray() {	
		Object [] newArray= new Object[this.myArray.length*2];
		for (int i=0; i<this.myArray.length; i++) {
			newArray[i]=this.myArray[i];
		}
		this.myArray= newArray;
	}
private boolean isValidIndex(int index) {	
	if((index>=0) && (index<this.numElements)) {
		return true;
	}
	else {
		return false;
	
	}
}

public int compareTo(Object object) {
	return this.compareTo(object);
}

}
