
public class SearchDriver implements SearchDriverInterface {


    public int[] getListOfNumbers() {
        int[] arr = new int[10000000];
        for (int i = 0; i < 10000000; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }

   
   

    public int[] getTargets() {
        int[] arr = { 500, 10000, 100000, 1000000, 5000000, 7500000, 10000000 };

        return arr;
    }

   
    public TestTimes runBinarySearch(int[] listOfNumbers, int target, int numberOfTimes) {
        
        BinarySearch search = new BinarySearch();
        TestTimes t=new TestTimes();

        for (int i = 0; i < numberOfTimes; i++) {
            long startTime = System.nanoTime(); // Get start time
            System.out.println("Found " + target + " at " + search.search(listOfNumbers, target));
            long endTime = System.nanoTime();             t.addTestTime(endTime - startTime);
        }

        return t;
    }

   
   
    public TestTimes runLinearSearch(int[] listOfNumbers, int target, int numberOfTimes) {
        
        LinearSearch search = new LinearSearch();
TestTimes t=new TestTimes();        

        for (int i = 0; i < numberOfTimes; i++) {
            long startTime = System.nanoTime(); // Get start time
            System.out.println("Found " + target + " at " + search.search(listOfNumbers, target));
            long endTime = System.nanoTime(); // Get end time
            t.addTestTime(endTime - startTime);
        }

        return t;
    }
}