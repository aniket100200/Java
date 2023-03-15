class Test1
{
    public static void talk()
    {
          System.out.println("hello there!");
    }

    // ADD CODE HERE
	public static void talk(String str){
		System.out.println("Hello "+str);
	}

}
public class Main{
    public static void main(String[] args)
    {
        Test1 test=new Test1();
        test.talk("Matthew");
    }
}
