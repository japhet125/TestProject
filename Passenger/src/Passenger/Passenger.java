package Passenger;
import java.util.Objects;
public abstract class Passenger implements Eater
{
private String name;
private int birthYear;
private double weight;
private char gender;
private int numCarryOn;
private double height;
private int caloriesConsumed;
private int caloriesAccumulator;
public Passenger(String name, int birthYear, double weight, double height, char gender, int 
numCarryOn, int caloriesConsumed, int caloriesAccumulated) {
this.name="";
this.birthYear=1900;
this.weight=0.0;
this.gender='u';
this.numCarryOn=0;
this.height=0;
this.caloriesConsumed=0;
this.caloriesAccumulator=0;
}
public Passenger(String name, int birthYear, double weight, double height, char gender, int 
numCarryOn) {
this.name=name;
this.birthYear= birthYear;
this.weight= weight;
this.numCarryOn= numCarryOn;
this.gender= gender;
this.height= height;
this.caloriesConsumed= caloriesConsumed;
this.caloriesAccumulator= caloriesAccumulator;
}
public Passenger() {
}
public int calculateAge(int currentYear) {
int age= currentYear-birthYear;
if(currentYear<birthYear)
age=-1;
return age;
}
public void gainWeight() {
this.weight++;
}
public void gainWeight(double weight) {
this.weight +=weight;
}
public int getBirthYear() {
return this.birthYear;
}
public char getGender() {
return this.gender;
}
public String getName() {
return this.name;
}
public double getWeight() {
return this.weight;
}
public int getNumCarryOn() {
return this.numCarryOn;
}
public double getHeight() {
return this.height;
}
public void setHeight(double height) {
if(height<0)
height=-1;
}
public int getCaloriesConsumed() {
return this.caloriesConsumed;
}
public void setCaloriesConsumed(int
CaloriesConsumed) {
this.caloriesConsumed= caloriesConsumed;
this.caloriesConsumed= caloriesConsumed;
}
public int getCaloriesAccumulator() {
return this.caloriesAccumulator;
}
public void setCaloriesAccumulator(int
CaloriesAccumulator) {
this.caloriesAccumulator= CaloriesAccumulator;
}
//abstract class
public abstract double metabolizedAccumulatedCalories();
public double calcaulateBMI() {
return (weight*703)/(height*height);
}
public boolean isFemale() {
return this.getGender()=='f'||this.getGender()=='f';
}
public boolean isMale() {
return
this.getGender()=='m'||this.getGender()=='m';
}
public void loseWeight() {
this.weight--;
}
public void loseWeight(double weight) {
this.weight-=weight;
}
public void printDetails() {
System.out.printf("Name: %20s | Year of Birth:%4d |Weight:%10.2f | Height: %10.2f | Gender:%c| NumCarryOn:%2d\n",this.getName(),this.getBirthYear(), 
this.getWeight(),this.getHeight(),this.getGender(),this.getNumCarryOn());
}
public void setGender(char gender) {
if(gender!='f'&& gender!='m')gender='u';
this.gender=gender;
}
public void setName(String name) {
this.name= name;
}
public void setBirthYear(int birthYear) {
this.birthYear= birthYear;
}
public void setWeight(double weight) {
if (weight<0)weight=-1;
this.weight= weight;
}
public void setNumCarryOn(int numCarryOn) {
if (numCarryOn<0)numCarryOn=0;
if (numCarryOn>2)numCarryOn=2;
}
@Override
public String toString() {
return "Passenger [name= %20s" + name + ",birthYear=%4d" + birthYear + ", weight=%10.2f" +weight + ", gender=%c" + gender+ ", numCarryOn=%2d\n"+numCarryOn + ",height=%10.2f" + height + "]";
}
@Override
public int hashCode() {
return Objects.hash(birthYear, gender, height,
name, numCarryOn, weight);
}
@Override
public boolean equals(Object obj) {
if (this == obj) return true;
if (!(obj instanceof Passenger)) return false;
Passenger other = (Passenger) obj;
return birthYear == other.birthYear && gender== other.gender && 
Double.doubleToLongBits(height) ==Double.doubleToLongBits(other.height)&& 
Objects.equals(name,other.name) && numCarryOn == 
other.numCarryOn&&Double.doubleToLongBits(weight) 
==Double.doubleToLongBits(other.weight);
}}
