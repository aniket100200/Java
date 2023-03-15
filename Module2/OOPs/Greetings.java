import java.util.*; 

class Student{

    // write your code here.
	public static void greet(){
		   System.out.println("Hello" );
	}

    public static void greet(String name){
        System.out.println("Hello" + " " + name);
    }

}

public class Main{ 

     public static void main(String[] args){
      
        Student.greet();
        Student.greet("Sansa");
    }
}
