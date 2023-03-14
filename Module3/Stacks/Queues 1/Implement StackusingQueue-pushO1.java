import java.io.*;
import java.util.*;
class Node
{
	int data;
	Node next;
	public Node(int data)
	{
		this.data=data;
		this.next=null;
	}
}

class Queue
{
	Node head;
	Node tail;
	int size;
	public Queue()
	{
		this.size=0;
		this.head=null;
		this.tail=null;
	}
	public void enqueue(int x)
	{
		size++;
		Node newNode=new Node(x);
		if(head==null)
		{
			head=tail=newNode;
			return;
		}
		else
		{
			tail.next=newNode;
			tail=newNode;
			return;
		}
	}
	public int dequeue()
	{
		if(head==null)
		{
			return -1;
		}
		else
		{
			size--;
			int value=head.data;
			Node temp=head.next;
			head.next=null;
			head=temp;
			return value;
		}
	}
}
class Stack
{
	Queue main;
	Queue temp;

	public Stack()
	{
		main=new Queue();
		temp=new Queue();
	}
    void push(int a)
    {
        main.enqueue(a);
		//this will push the element's in the que with o 1;
    }
    
    int pop()
    {
       while(main.size>1)
	   {
		   temp.enqueue(main.dequeue());
	   }
		int popped=main.dequeue();
		while(temp.size>0)
		{
			main.enqueue(temp.dequeue());
		}
		System.out.print(popped+" ");
		return popped;
    }	
}
public class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);    
        Stack g = new Stack();			
        int q = sc.nextInt();
		Stack s1=new Stack();
        while(q>0)
        {
            int QueryType = sc.nextInt();
            if(QueryType == 1)
			{
                int a = sc.nextInt();
                    // call push function here
				s1.push(a);
				
            }
            else if(QueryType == 2)
			{
                    // call pop function here
				s1.pop();
            }
            q--;
        }	
    }
}
