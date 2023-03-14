import java.io.*;
import java.util.*;

class StackQueue
{
    //Function to push an element in queue by using 2 stacks.
	Stack<Integer> main;
	Stack<Integer> temp;
	public StackQueue()
	{
		this.main=new Stack<Integer>();
		this.temp=new Stack<Integer>();
	}
    void Push(int x)
    {
	   //Write your code here
		//this takes //O(n) time complexity... okay...
		if(main.isEmpty())
		{
			main.push(x);
			return;
		}
		while(main.size()>0)
		{
			temp.push(main.pop());		
		}
		main.push(x);
		while(temp.size()>0)
		{
			main.push(temp.pop());
		}
	  
    }
    //Function to pop an element from queue by using 2 stacks.
    int Pop()
    {
		//pop in queues is known as dequeue... 
		//but deque is diffrent .. i.e. doubley ended linked list..
	   //this operation is O(1);..
	    if(main.isEmpty())
		{
			return -1;
		}
		return main.pop();
    }
}
public class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);  
        StackQueue s = new StackQueue();	
        int q = sc.nextInt();
        ArrayList<Integer> ans= new ArrayList<>();
        while(q>0)
        {
            int QueryType = sc.nextInt();
            if(QueryType == 1)
            {
                int a = sc.nextInt();
                s.Push(a);
            }
            else if(QueryType == 2)
            ans.add(s.Pop());
        q--;
        }	
        for(int x:ans)
        System.out.print(x+" ");       
     System.out.println();
    }
}
