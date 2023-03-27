
public class InsertionSort implements SortInterface{
	
	int i=1;
	int j=1;
	@Override
	public void sort(Integer[] arrayToSort) {
		// TODO Auto-generated method stub
		for(int i=1; i<arrayToSort.length;i++) {
			int temp= arrayToSort[i];
			j=i-1;
			while( j>=0&&arrayToSort[j]>temp) {
				arrayToSort[j+1]=arrayToSort[j];
				j--;
			}
			arrayToSort[j+1]=temp;
		}
	

}
}