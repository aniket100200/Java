import java.util.*; 

abstract class Animal{
 
    public String name;
    public int numLegs;
    public abstract void speak();
    public abstract void eat();
}

class Dog extends Animal
{
   
     // write your code here.
	public void speak()
	{
		System.out.println("woof");
	}
	public void eat(){
		System.out.println("nom nom");
	}
}


public class Main {
     
      public static void main(String[] args){
            Dog myDog = new Dog();
            myDog.speak();
            myDog.eat();
      }
}
