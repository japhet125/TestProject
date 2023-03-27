import java.util.Random;
public class ListDriver  implements ListDriverInterface{

	@Override
	public ListInterface<Integer> createList(ListDriverInterface.ListType listType,
			ListDriverInterface.TestType forTestType) {
		ListInterface<Integer> list= null;
		switch(listType) {
		case ArrayBasedList:
			listType=ListType.ArrayBasedList;
			list= new ArrayBasedList<Integer>();
		
			
			break;
		case LinkedList:
			listType= ListType.LinkedList;
			list= new LinkedList<Integer>();
			
			break;

	}
	
		if(forTestType== TestType.AddSortedOdd ||forTestType==TestType.AddAllAtIndexZero||forTestType==TestType.AddAll) {
			return ( list);
			
		}
		
		if(forTestType==TestType.RemoveAllEven || forTestType==TestType.RemoveAllOdd) {
			return initializeList(list, 1,10000,1);
			
		}
		if(forTestType==TestType.AddSortedEven ) {
			return initializeList(list,1,9999,2);
		}
		return list;
	}
		
	


	@Override
	public ListInterface<Integer> initializeList(ListInterface<Integer> list, int firstNumber, int lastNumber,
			int increment) {
		if(increment==0) {
			return list;
		}
		else {
			for(int i= firstNumber; i<=lastNumber; i=i+increment) {
				list.add(i);
			}
		}
		return list;
	}

	@Override
	public double memoryUsage() {
		Runtime run= Runtime.getRuntime();
		double memory=run.totalMemory()-run.freeMemory();
		memory=memory/1024;
		memory=memory/1024;
		return memory;
	}

	@Override
	public Object[] runTestCase(ListDriverInterface.ListType listType, ListDriverInterface.TestType testType,
			int numberOfTimes) {
		Object[] arr= new Object[(numberOfTimes*2)+1];
		//ListDriver list= new ListDriver();
		TestTimes test= new TestTimes();
		ListInterface<Integer> list= createList(listType, testType);
		ListInterface<Integer> copyList=list.copy();
	    arr[0]=copyList;
		//int p=1;
		for(int i=0; i<=numberOfTimes*2; i++) {
			
			//System.out.println("Control is inside this outer for loop.");
			long startTime=System.nanoTime();
		if(	testType== TestType.AddAll) {
			for(int j=1; j<=numberOfTimes; j++) {
				
				list.add(j);
			}
			
		}
		if(testType== TestType.AddAllAtIndexZero) {
			for(int j=1; j<=numberOfTimes; j++) {
				list.add(j,0);
			}
		}
		if(testType== TestType.AddSortedEven) {
			for(int j=1; j<=numberOfTimes; j++) {
				list.addSorted(j);
			}
		}
		if(testType==TestType.AddSortedOdd) {
			for(int j=1; j<=numberOfTimes; j++) {
				list.addSorted(j);
			}
		}
		if(testType==TestType.RemoveAllEven) {
			for(int j=0; j<list.size(); j++) {
				for(int k=list.size()-1; k>=0; k-=2)
			list.remove(k);
			}
		}
		if(testType== TestType.RemoveAllOdd) {
			for(int j=0; j<list.size(); j++) {
				for(int k=list.size()-2; k>=0; k-=2)
			 list.remove(k);
			}
			
		}
		
		long endTime= System.nanoTime();
		long time= (endTime-startTime);
		test.addTestTime(time);
		if(i<(numberOfTimes*2)) arr[i++]=list.copy();
		}
		
		arr[numberOfTimes*2]=test;
		
		return arr;
	}
	
public static void main(String args[]){

			ListDriver list= new ListDriver();
		int listSizes= 10000;
		int runTime=10;
	//	for(int ListSize: listSizes) {
			
			for(ListDriver.TestType testType: ListDriver.TestType.values()) {
				for(ListDriver.ListType listType: ListDriver.ListType.values()) {
				//Object[]obj= new Object[20];
		        	Object[] obj= list.runTestCase(listType,testType, 10000);
		        	TestTimes test=(TestTimes) obj[1];
		        	long testTimes[]=test.getTestTimes();
		    	    
					System.out.println((listType));
					System.out.println((testType));
					System.out.println((listSizes));
					
					
					for(int i=0;i<testTimes.length;i++) 
					{
						long l=(long) testTimes[i];
						double a= (double)(testTimes[i])/1000000000;
						System.out.printf("%.5f ",a);
					}
					
					System.out.printf("%.5f ",(double)test.getAverageTestTime()/1000000000);
					System.out.printf("%.5f",obj[2]);
					
				//	System.out.print("       "+ obj[i]);
					System.out.println();
					
			
			
			
}
		
	}

			}
		}


