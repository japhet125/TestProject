
public class BinarySearch implements SearchInterface {
	
	@Override
	public int search(int[] listOfNumbers,int target) {
			int last= listOfNumbers.length-1;
			int first= 0;
			while(first<=last) {
				int middle= (first+last)/2;
				if(listOfNumbers[middle]== target) {
					return middle;
				}else if(listOfNumbers[middle]> target) {
					last= middle-1;
				}else { first= middle +1;
			} 
			
			}
			return -1;
			
	
	}
}