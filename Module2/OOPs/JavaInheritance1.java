import java.io.*;
import java.util.*;

class Animal {
    void walk() {
        System.out.println("I am walking");
    }
}

class Bird extends Animal 
{
    void fly() 
	{
        System.out.println("I am flying");
    }
	void sing(){
		 System.out.println("I am singing");
	}
  //Write your code here
}

class Solution {
    public void solve() {
        Bird bird = new Bird();
        bird.walk();
        bird.fly();
        bird.sing();
    }

}

class Main {

    public static void main(String[] args) {
        Solution ob = new Solution();
        ob.solve();
    }
}
