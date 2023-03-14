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
		
		//It will O(N) tiem complexity... here we go...
		if(main.size==0)
		{
			main.enqueue(a);
			return;
		}
		else
		{
			//firstly I'll remove all elemets 
			//main---> Temp...

		while(main.size>0)
		{
			temp.enqueue(main.dequeue());
		}
			main.enqueue(a);

			//temp--> main..
			while(temp.size>0)
			{
				main.enqueue(temp.dequeue());
			}
			//operation is done...
		}
		
		
    }
    
    int pop()
    {
		//I have to design pop using Queue int O(1);... 
		if(main.size==0)
		{
			System.out.print(-1+" ");
			return -1;
		}
		int value=main.dequeue();
		System.out.print(value+" ");
		return value;
     
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
