import java.io.*;
import java.util.*;

//Write your code here
class Arithmetic
{
	
	public int add(int a,int b)
	{
		return a+b;
	}
}
class Adder extends Arithmetic
{
	public int add(int a,int b)
	{
		return super.add(a,b);
	}
}

class Solution {
    public static void solve() 
	{
        // Create a new Adder object
        Adder a = new Adder();

        // Print the name of the superclass on a new line
        System.out.println("My superclass is: " + a.getClass().getSuperclass().getName());

        // Print the result of 3 calls to Adder''''''''s `add(int,int)` method as 3
        // space-separated integers:
        System.out.print(a.add(10, 32) + " " + a.add(10, 3) + " " + a.add(10, 10) + "\n");
    }
}

class Main {

    public static void main(String[] args) {
        Solution ob = new Solution();
        ob.solve();
    }
}
