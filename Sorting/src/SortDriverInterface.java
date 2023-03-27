
public interface SortDriverInterface {
static enum ArrayType{Equal, Random, Increasing, Decreasing, IncreasingAndRandom};
	

static enum SortType{BubbleSort, SelectionSort, InsertionSort};
	
Integer [] createArray(ArrayType arrayType, int arraySize);
Object[] runSort(SortType sortType, ArrayType arrayType, int arraySize, int numberOfTimes);

}
