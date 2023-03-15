import java.util.*; 

class Pet{

    public void brag(){
        System.out.println("I have the best pet!");
    }
}

class Dog extends Pet
{
    public void brag()
	{
       super.brag();
        // write your code here
        System.out.println("I have the best dog!");
    }
}
 
public class Main{
     public static void main(String[] args){
        Dog d1 = new Dog();
        d1.brag();
    }
}
