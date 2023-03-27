package Passenger;
import java.util.Objects;
public class Food {
private String name;
private int calories;
//constructors
public Food (String name, int calories) {
this.name= name;
this.calories= calories;
}
// getter and setter
public void setName(String Name) {
this.name=name;
}
public String getName() {
return this.name;
}
public void setCalories(int calories) {
this.calories= calories;
}
public int getCalories() {
return this.calories;
}
@Override
public String toString() {
String s1= String.format("Food - Name:%10s" +this.name);
String s2= String.format(" |Calories: %4d" +this.calories);
return s1+s2;
}
@Override
public int hashCode() {
return Objects.hash(calories, name);
}
@Override
public boolean equals(Object obj) {
if (this == obj)
return true;
if (!(obj instanceof Food))
return false;
Food other = (Food) obj;
return calories == other.calories &&
Objects.equals(name, other.name);
}
public static void main(String[] args) {
// TODO Auto-generated method stub
}}
