import java.util.Arrays;
import java.util.Random;

public class SortDriver implements SortDriverInterface {

	public static void main(String[] args) {
		SortDriver d= new SortDriver();
	int[]arraySizes= {1000,10000};
	int testTime=10;
	for(int arraySize: arraySizes) {
		
		for(SortDriver.ArrayType arrayType: SortDriver.ArrayType.values()) {
			for(SortDriver.SortType sortType: SortDriver.SortType.values()) {
				//Object[]object= new Object[20];
				Object[] object= d.runSort(sortType,arrayType, arraySize,10);
				System.out.println((sortType));
				System.out.println((arrayType));
				System.out.println((arraySize));
				for(int i=0; i<testTime; i++) {
					
					System.out.print(object[i]+ " ");
					
				}
				System.out.print("       "+ object[testTime]);
				System.out.println();
				
		
		
		
		
	
}

		}
		}
	}

	@Override
	public Integer[] createArray(SortDriverInterface.ArrayType arrayType, int arraySize) {
		
			Integer[]array= new Integer[arraySize];
			Random r= new Random();
			int maxLimit=1000000;
			int sum=0;
			switch(arrayType) {
			case Equal:
				for(int i=0; i<array.length; i++) {
					array[i]=1;
				}
				break;
			case Increasing:
				for(int i=0; i<array.length; i++) {
					array[i]=sum+=1;
				}
				break;
			case Decreasing:
				for(int i=0; i<array.length; i++) {
					array[i]=arraySize-=1;
				}
				break;
			case Random:
				for(int i=0; i<array.length; i++) {
					array[i]=r.nextInt(maxLimit);
				} break;
			case IncreasingAndRandom:
				double percent=0.90*arraySize;
				int value =(int)percent;
				for(int i=0; i<array.length;i++) {
					array[i]=sum+=1;
				}
				for(int i=value; i<array.length; i++) {
					array[i]=r.nextInt(maxLimit);
				}
				break;
			}
			
			
			
			return array;
		}
		
		
	@Override
	public Object[] runSort(SortDriverInterface.SortType sortType, SortDriverInterface.ArrayType arrayType,
			int arraySize, int numberOfTimes) {
			
			Object[]object= new Object[(numberOfTimes*2)+1];
			SortDriver d= new SortDriver();
			
			TestTimes testTimes= new TestTimes();
			for(int i=0; i<numberOfTimes*2; i+=2) {
				Integer[] unsortedArr= d.createArray(arrayType, arraySize);
				Integer[] copyOj= d.createArray(arrayType, arraySize);
				//object[
				long startTime=System.nanoTime();
				switch(sortType) {
				case BubbleSort:
					BubbleSort bubbleSort= new BubbleSort();
					bubbleSort.sort(unsortedArr);

					break;
				case InsertionSort:
					InsertionSort insertionSort= new InsertionSort();
					insertionSort.sort(unsortedArr);
				
					break;
				case SelectionSort:
					SelectionSort selectionSort= new SelectionSort();
					selectionSort.sort(unsortedArr);
					break;
				}
				long endTime= System.nanoTime();
				long time= (endTime-startTime);
				testTimes.addTestTime(time);
				//object[i+1]=unsortedArr;
			}
			long []arr= testTimes.getTestTimes();
		for(int i=0; i<arr.length; i++)
		object[i]= arr[i];
				object[numberOfTimes]=testTimes.getAverageTestTime();
				
			return object;
		}

	
	
		
	}
	
	

