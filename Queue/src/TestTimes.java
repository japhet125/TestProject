import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;

public class TestTimes implements TestTimesInterface {
		
		private final int MAX_NUMBER_OF_MEMORY= 10;
		private final int MAX_NUMBER_OF_ELEMENTS = 10;
		private long[] testTimes = new long[MAX_NUMBER_OF_ELEMENTS];
		private int numTestTimes = 0;
		private double numMemoryUsage=0;
		private double [] memoryUsage = new double [MAX_NUMBER_OF_MEMORY];
        private TimeUnits timeUnits;
        private double seconds= 0;
        private double milliSeconds = 0;
        private double microSeconds= 0;
        private MemoryUnits memoryUnits;
        private double kiloBytes = 1024;
        private double megaBytes= 1024*1024;
        
		
		@Override
		public void resetTestTimes() {
			for ( int i = 0 ; i < this.testTimes.length ; i++ ) {
				this.testTimes[i] = 0;
			}
			this.numTestTimes = 0;
		}

		@Override
		public void addTestTime(long testTime) {
			Runtime run= Runtime.getRuntime();
			
			if (this.numTestTimes == this.testTimes.length) {
				for ( int i = 0 ; i <= this.testTimes.length - 2 ; i++ ) {
					this.testTimes[i] = this.testTimes[i+1];
				}
				this.testTimes[9] = testTime;
				
				if(this.numMemoryUsage==this.memoryUsage.length) {
					for(int k=0; k<=this.memoryUsage.length-2 ; k++) {
						this.memoryUsage[k]= this.memoryUsage[k+1];
					}
				}
				double memory=run.totalMemory()-run.freeMemory();
				memoryUsage[9]=memory;
			
			} else {  
				this.testTimes[this.numTestTimes++] = testTime;
				double memory=run.totalMemory()-run.freeMemory();
				this.memoryUsage[(int)this.numMemoryUsage++]= memory;
			}
		}

		@Override
		public double getAverageTestTime() {
			double total = 0;
			double arr[]=getTestTimes();
			
			for ( int i = 0 ; i < this.numTestTimes ; i++ ) {
				total = total + arr[i];
			}
			
			double runTestCase= (double)(total/numTestTimes);
			return runTestCase;	
		}
		
// new use of testtimes
		@Override
		public TestTimesInterface.TimeUnits getTimeUnits() {
			
			return this.timeUnits;
		}

		@Override
		public void setTimeUnits(TestTimesInterface.TimeUnits timeUnits)  {
			/*for(TimeUnit unit: TimeUnit.values()) {
				
			double Seconds=	TimeUnit.SECONDS.toSeconds(MAX_NUMBER_OF_ELEMENTS);
		double MicroSeconds=		TimeUnit.MICROSECONDS.toSeconds(numTestTimes);
			double MilliSeconds=	TimeUnit.MILLISECONDS.toSeconds(numTestTimes);
			double NanoSeconds= TimeUnit.NANOSECONDS.toSeconds(numTestTimes);
				}*/
			this.timeUnits= timeUnits;
		}
		@Override
		public TestTimesInterface.MemoryUnits getMemoryUnits() {
			
			return this.memoryUnits;
		}

		@Override
		public void setMemoryUnits(TestTimesInterface.MemoryUnits memoryUnits) {
			/*for(MemoryUnits unit: MemoryUnits.values()) {
				double Bytes= MemoryUnits.Bytes.compareTo(memoryUnits);
				double KiloBytes= MemoryUnits.KiloBytes.compareTo(memoryUnits);
				double MegaBytes= MemoryUnits.MegaBytes.compareTo(memoryUnits);
			}*/
			this.memoryUnits= memoryUnits;
		}

		@Override
		public double getLastTestTime() {
			
			return getTestTimes()[this.numTestTimes - 1];
		}

		@Override
		public double getLastMemoryUsage() {
			double arr[]=getMemoryUsages();
			return arr[memoryUsage.length-1];
}

		double[] getTimes(long l)
		{
			DecimalFormat df=new DecimalFormat("0.0");
			double[] array = new double[this.testTimes.length];
			for ( int i = 0 ; i < this.testTimes.length ; i++ ) {
				array[i] = Double.parseDouble(df.format(this.testTimes[i]/l));
			}
			return array;
		}
		
		// 3.0  3.0000000000
		@Override
		public double[] getTestTimes() {
			
			double [] arr=null;
			if(timeUnits==TimeUnits.Seconds) 
			{
				arr=getTimes(1000000000);
			}
			else if(timeUnits==TimeUnits.MicroSeconds)
			{
				arr=getTimes(1000);
			}
			else if(timeUnits==TimeUnits.MilliSeconds)
			{
				arr=getTimes(1000000);
			}	
			else arr=getTimes(1);
			
			return arr;
		}
	
		
		double[] getMemory(long l)
		{
			double[] array = new double[this.memoryUsage.length];
			for ( int i = 0 ; i < this.memoryUsage.length ; i++ ) {
				array[i] = Double.parseDouble(String.valueOf(this.memoryUsage[i]/l));
			}
			return array;
		}
		
		
		
		@Override
		public double[] getMemoryUsages() {
			
			double arr[]=null;
			if(memoryUnits==MemoryUnits.MegaBytes)
			{
				arr=getMemory(1024*1024);
			}
			else if(memoryUnits==MemoryUnits.KiloBytes)
			{
				arr=getMemory(1024);
			}
			else arr=getMemory(1);
			return arr;
					}

		@Override
		public double getAverageMemoryUsage() {
			double total = 0;
			
			double arr[]=getMemoryUsages();
			
			for ( int i = 0 ; i < this.numMemoryUsage ; i++ ) {
				total = total + arr[i];
			}
				return total/this.numMemoryUsage;
			}
		
	}

