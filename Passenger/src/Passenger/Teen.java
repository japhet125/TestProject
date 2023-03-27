package Passenger;

public abstract class Teen extends Person implements Mover {
public Teen(int caloriesConsumed, int caloriesAccumulated) {
super( caloriesConsumed, caloriesAccumulated);
}
@Override
public void eat(Food food) {
// TODO Auto-generated method stub
int cc=super.getCaloriesConsumed();
int ca= super.getCaloriesAccumulator();
ca+=food.getCalories();
cc+=food.getCalories();
super.setCaloriesAccumulator(ca);
super.setCaloriesConsumed(cc);
}
@Override
public void eat(Food[] foods) {
// TODO Auto-generated method stub
int cc=super.getCaloriesAccumulator();
int ca= super.getCaloriesConsumed();
for(int i=0;i<foods.length;i++) {
cc+=foods[i].getCalories();
ca+=foods[i].getCalories();
}
super.setCaloriesAccumulator(ca);
super.setCaloriesConsumed(cc);
}
public double metabolizeAccumulatedCalories() {
// TODO Auto-generated method stub
int ac= super.getCaloriesAccumulator();
super.setCaloriesAccumulator(0);
return ac/5000.0;
}
@Override
public String move() {
// TODO Auto-generated method stub
return "run fast and jump";
}
@Override
public String move(int count) {
// TODO Auto-generated method stub
String str="";
for(int i=0; i<count; i++)str+="run fast and jump\n";
return str;
}
@Override
public double metabolizedAccumulatedCalories() {
// TODO Auto-generated method stub
double WeightGained=0;
int calories= this.getCaloriesAccumulator();
while (calories - 5000>=0) {
WeightGained++;
calories= calories -5000;
}
if(calories <5000) {
double fraction= calories/5000;
this.gainWeight(fraction);
}
this.setCaloriesAccumulator(0);
return WeightGained;
}
public static void main(String[] args) {
}
}
