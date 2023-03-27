
public class Main {
public static void main(String gg[])
{

	TestTimes t=new TestTimes();
	t.addTestTime(32432);
	t.addTestTime(32432);
	t.addTestTime(32432);
t.addTestTime(32432);
t.addTestTime(32432);
t.addTestTime(32432);
t.addTestTime(32432);
t.addTestTime(32432);
t.addTestTime(32432);
t.addTestTime(32432);
t.addTestTime(32432);
double d[]=t.getTestTimes();
double aveg[]=t.getMemoryUsages();

for(int i=0;i<d.length;i++)
{
System.out.println("TestTime : "+d[i]);
System.out.println("Memory usage : "+aveg[i]);

}
}
}
