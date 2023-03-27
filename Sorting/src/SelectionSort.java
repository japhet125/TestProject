
public class SelectionSort implements SortInterface {

	@Override
	public void sort(Integer[] arrayToSort) {
		// TODO Auto-generated method stub
		//int last= array.length-1;
		for(int i=0; i<arrayToSort.length-1; i++) {
			int min=i;
			for(int j=i+1; j<arrayToSort.length; j++) {
				if(arrayToSort[j]<arrayToSort[min]) {
					min=j;
				}
				
			}
			if(min!=i) {
				int temp=arrayToSort[i];
				arrayToSort[i]=arrayToSort[min];
				arrayToSort[min]=temp;
				
			}
		
		}
		
	}


	
}
	


