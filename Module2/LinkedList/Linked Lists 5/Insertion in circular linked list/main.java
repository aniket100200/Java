
import java.util.*;
import java.io.*;

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
class CircularLL
{
	Node tail;
	public void insertAtEnd(int val)
	{
		Node n=new Node(val);
		if(tail==null)
		{
			tail=n;
			tail.next=tail;
			return;
		}
		n.next=tail.next;
		tail.next=n;
		tail=n;
	}

	public void print(){
		Node temp=tail.next;
		while(temp!=tail)
		{
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.println(temp.data);
	}
}
public class Main {
    public static void main(String args[])
	{
        //your code here
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		CircularLL cl=new CircularLL();
		for(int i=1;i<=n;i++)
		{
			cl.insertAtEnd(sc.nextInt());
		}
		cl.insertAtEnd(sc.nextInt());
		cl.print();
	
    }
}
