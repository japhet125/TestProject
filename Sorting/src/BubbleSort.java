
public class BubbleSort implements SortInterface{
	
	@Override
	public void sort(Integer [] arrayToSort) {
		// TODO Auto-generated method stub
			int last= arrayToSort.length;
			//int temp=0;
			//while(last>=1){
				for (int i=0; i<last; i++) {
					for(int j=0; j<last-1; j++) {
					if (arrayToSort[j]>arrayToSort[j+1]) {
					int	temp=arrayToSort[j];
						arrayToSort[j]=arrayToSort[j+1];
						arrayToSort[j+1]= temp;
		
		
	}
					
			}
		//	last--;
			}
			//break;
	}

	}
//}
	