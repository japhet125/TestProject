
	public class TestTimes implements TestTimesInterface{
		
		private final int MAX_NUMBER_OF_ELEMENTS = 10;
		private long[] testTimes = new long[MAX_NUMBER_OF_ELEMENTS];
		private int numTestTimes = 0;

		@Override
		public long getLastTestTime() {
			return this.testTimes[this.numTestTimes - 1];
		}

		@Override
		public long[] getTestTimes() {
			long[] array = new long[this.testTimes.length];
			for ( int i = 0 ; i < this.testTimes.length ; i++ ) {
				array[i] = this.testTimes[i];
			}
			return array;
		}

		@Override
		public void resetTestTimes() {
			for ( int i = 0 ; i < this.testTimes.length ; i++ ) {
				this.testTimes[i] = 0;
			}
			this.numTestTimes = 0;
		}

		@Override
		public void addTestTime(long testTime) {
			if (this.numTestTimes == this.testTimes.length) {
				for ( int i = 0 ; i <= this.testTimes.length - 2 ; i++ ) {
					this.testTimes[i] = this.testTimes[i+1];
				}
				this.testTimes[9] = testTime;
			} else {  
				this.testTimes[this.numTestTimes++] = testTime;
			}
		}

		@Override
		public double getAverageTestTime() {
			double total = 0;
			for ( int i = 0 ; i < this.numTestTimes ; i++ ) {
				total = total + this.testTimes[i];
			}
			if (this.numTestTimes == 0) {
				return 0.0;
			} else {
				return total/this.numTestTimes;
			}
		}
	}


