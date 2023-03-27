public interface TestTimesInterface {
	void addTestTime(long testTime);
	double getAverageTestTime();
	long getLastTestTime();
	long[] getTestTimes();
	void resetTestTimes();

}


