package Passenger;

public abstract class Elder extends Person implements Mover{
public Elder(int caloriesConsumed,int accumulatedCalories)
{
super(caloriesConsumed,accumulatedCalories);
}
public double metabolizeAccumulatedCalories()
{
int ac=super.getCaloriesAccumulator();
super.setCaloriesAccumulator(0);
return ac/300.0;
}
public void eat(Food[] food)
{
int cc=super.getCaloriesConsumed();
int ca=super.getCaloriesAccumulator();
for(int i=0;i<food.length;i++)
{
ca+=food[i].getCalories();
cc+=food[i].getCalories();
}
super.setCaloriesConsumed(cc);
super.setCaloriesAccumulator(cc);
}
public void eat(Food food)
{
int cc=super.getCaloriesConsumed();
int ca=super.getCaloriesAccumulator();
ca+=food.getCalories();
cc+=food.getCalories();
super.setCaloriesConsumed(cc);
super.setCaloriesAccumulator(cc);
}
public String move()
{
return "ouch my back wait for me";
}
public String move(int count)
{
String str="";
for(int i=0;i<count;i++) str+="ouch my back wait for me\n";
return str;
}
public static void main(String[] args) {
// TODO Auto-generated method stub
}}