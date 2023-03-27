package Passenger;
import java.util.Arrays;
public abstract class Infant extends Person implements Mover{
private class InfantToy {
private String infantToyName;
private int infantToyRating;
public InfantToy(String infantToyName, int
infantToyRating) {
this.infantToyName= infantToyName;
this.infantToyRating= infantToyRating;
}
public String toString() {
return (String.format("Infant: Number of Toys: %4d| Infant Toys:\n","InfantToy:Toy Name:%20s|Rating %4d\n"));
}
}
 private InfantToy[] toys;
 private int numInfantToys;
public Infant() {
numInfantToys=0;
toys= new InfantToy[10];
}
public Infant(String Name, int birthYear, double weight,double height, char gender, int 
numCarryOn, int caloriesConsumed, int caloriesAccumulator) {
numInfantToys=0;
toys= new InfantToy[10];
}
public double metabolizeAccumulatedCalories() {
int ac=super.getCaloriesAccumulator();
super.setCaloriesAccumulator(0);
return ac/1200.0;
}
public void eat(Food[] food) {
int cc=super.getCaloriesConsumed();
int ca=super.getCaloriesAccumulator();
for (int i=0;i<food.length;i++) {
ca+=food[i].getCalories();
cc+=food[i].getCalories();
}
super.setCaloriesConsumed(cc);
super.setCaloriesAccumulator(ca);
}
public void eat(Food food) {
int cc= super.getCaloriesConsumed();
int ca=super.getCaloriesAccumulator();
ca+=food.getCalories();
cc+= food.getCalories();
super.setCaloriesConsumed(cc);
super.setCaloriesAccumulator(ca);
}
public String move() {
return "fail arms and legs";
}
public String move(int count) {
String str="";
for(int i=0; i<count;i++)str+="fail arms and legs\n";
return str;
}
public void addInfantToy(String Name, int Rating) {
InfantToy missing = new InfantToy(Name,
Rating);
if (numInfantToys<10) {
toys[numInfantToys]= missing;
numInfantToys++;
}
}
public String getInfantToyAsString(int index) {
if (index<=numInfantToys && index>=0) {
return super.toString()+
String.format(getName(), toys[index]);
}else {
return "Invalid index"+ index;
}
}
public int getNumInfantToys() {
return numInfantToys;
}
public String getInfantToyName(int index) {
if (index<=numInfantToys && index>=0) {
return toys[index].infantToyName;
}
else {
return "invalid index"+index;
}
}
public int getInfantToyRating(int index) {
if (index<numInfantToys && index>0 ) {
return toys [index].infantToyRating;
}
else {
return -1;
}
}
public int getHighestInfantToyRating() {
int good=0;
if (toys.length<=0) {
return 0;
}
for(int i=0; i<numInfantToys; i++) {
if(toys[i].infantToyRating>good) {
good=toys[i].infantToyRating;
}
}
return good;
}
@Override
public void printDetails() {
System.out.printf("Infant: Number of Toys: %4d | Infant Toys:\n | InfantToy: Toy Name: %20s | Rating %4d\n");
 
super.printDetails();
}
@Override
public String toString() {
return "Infant [toys=" + Arrays.toString(toys) +
", numInfantToys=" + numInfantToys + "]";
}}