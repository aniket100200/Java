class Person
{
    public void speak()
    {
        System.out.println("I'm a person");
    }    
}

class Student extends Person
{
    // ADD CODE HERE
	public void speak()
	{
		 System.out.println("I''m a student");
	}
}
public class Main{
    public static void main(String[] args)
        {
            Person p1 = new Student();
            p1.speak();
        }
}
