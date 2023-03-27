public class QueueDriver implements QueueDriverInterface {

	
	
	public static void main(String[] args) {
		LinkedQueue<String> linked= new LinkedQueue();
		QueueDriver queue=new QueueDriver();
		ArrayBasedQueue<String> arr= new ArrayBasedQueue();
		int runTestCase=10000;
		int run=10;
		
		
		
			for(TestType testType : TestType.values())
			{
			
			Object object1[]=queue.runTestCase(QueueType.ArrayBasedQueue,testType,10);
			Object object2[]=queue.runTestCase(QueueType.LinkedQueue, testType, 10);
				
			if(testType==TestType.Enqueue)
			System.out.println("Enqueue");
			else if(testType==TestType.Dequeue)
					System.out.println("Dequeue");
			else 
				System.out.println("Dequeue Random");
			
			
			TestTimes testTime1=(TestTimes)object1[object1.length-1];
			TestTimes testTime2=(TestTimes)object2[object2.length-1];
			
			testTime1.setTimeUnits(TestTimesInterface.TimeUnits.MicroSeconds);			
			testTime2.setTimeUnits(TestTimesInterface.TimeUnits.MicroSeconds);			
			
			testTime1.setMemoryUnits(TestTimesInterface.MemoryUnits.KiloBytes);			
			testTime2.setMemoryUnits(TestTimesInterface.MemoryUnits.KiloBytes);			
			
			
			double[] data1=testTime1.getTestTimes();
			double[] data2=testTime2.getTestTimes();
			
		System.out.println("Runtime : ");
		System.out.print("ArrayBasedQueue : ");
		for(double d:data1) System.out.print(d+"  ");
		System.out.print(testTime1.getAverageTestTime());
		System.out.println();
		System.out.print("LinkedQueue : ");
		for(double d:data2) System.out.print(d+"  ");
		System.out.println(testTime2.getAverageTestTime());
		
		System.out.println("\n\n\n");
		
		data1=testTime1.getMemoryUsages();
		data2=testTime2.getMemoryUsages();
		
	System.out.println("Memory Usage : ");
	System.out.print("ArrayBasedQueue : ");
	for(double d:data1) System.out.print(d+"  ");
	System.out.print(testTime1.getAverageMemoryUsage());
	System.out.println();
	System.out.print("LinkedQueue : ");
	for(double d:data2) System.out.print(d+"  ");
	System.out.println(testTime2.getAverageMemoryUsage());
	System.out.println("\n\n\n");
			}
				
		
		
		
	}
	
	
	
	@Override
	public QueueInterface<String> createQueue(QueueDriverInterface.QueueType queueType,
			QueueDriverInterface.TestType testType) {
		int enqueue=10000;
		int dequeue=10000;
		int dequeueRandom=10000;
		QueueInterface<String> queue= null;
		switch(queueType) {
		case ArrayBasedQueue:
			//queueType=QueueType.ArrayBasedQueue;
			queue= new ArrayBasedQueue<String>();
			break;
		case LinkedQueue:
			//queueType= QueueType.LinkedQueue;
			queue= new LinkedQueue<String>();
			
			break;
	}
		
		// Software developer 
		
		// Data Analyst
		if(testType== TestType.Enqueue) {
			
		}
		if(testType== TestType.Dequeue) {
			for(int i=1;i<=10000;i++) {
				queue.enqueue("String "+i);
			}
		}
		if(testType== TestType.DequeueRandom) {
			for(int i=1;i<=10000;i++) {
				queue.enqueue("String "+i);
			}
		}
		return queue;
	}


	@Override
	public Object[] runTestCase(QueueDriverInterface.QueueType queueType, QueueDriverInterface.TestType testType,
			int numberOfTimes) {
		Object[]object= new Object[(numberOfTimes*2)+1];
		TestTimes testTimes= new TestTimes();
		int j=0;
		QueueInterface<String> queue=null;
		
		
		for(int i=0; i<numberOfTimes; i++) {
			
		switch(queueType) {
		case ArrayBasedQueue:
			queue= new ArrayBasedQueue<>();
			queue=createQueue(queueType,testType);
			break;
		case LinkedQueue:
			queue=new LinkedQueue<>();
			queue=createQueue(queueType,testType);
			break;
		}
		
		if(queueType==QueueDriverInterface.QueueType.ArrayBasedQueue)object[j]=(ArrayBasedQueue<String>)queue.copy();	
		else object[j]=(LinkedQueue<String>) queue.copy();
		
		j++;
		
		long startTime=System.nanoTime();
		
		switch(testType) {
		case Enqueue:
			for(int p=1;p<=10000;p++) queue.enqueue("String "+p);
			break;
		case Dequeue:
			for(int d=0;d<10000;d++) queue.dequeue();
			break;
		case DequeueRandom:
			for(int d=9999;d>=0;d--) queue.dequeue(d);
			break;
		}
		
		
		if(queueType==QueueDriverInterface.QueueType.ArrayBasedQueue)object[j]=(ArrayBasedQueue<String>)queue.copy();	
		else object[j]=(LinkedQueue<String>) queue.copy();
		
		j++;
		
		long endTime= System.nanoTime();
		long time= (endTime- startTime);
		testTimes.addTestTime(time);
		}

			object[object.length-1]=testTimes;
			return object;
}
}
