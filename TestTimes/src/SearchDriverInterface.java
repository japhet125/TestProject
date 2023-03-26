
public interface SearchDriverInterface {
	int[] getListOfNumbers();
	int[] getTargets();
	TestTimes runBinarySearch(int []listOfNumbers, int target, int numberOfTimes);
TestTimes runLinearSearch(int []listOfNumbers, int target, int numberofTimes);
}
