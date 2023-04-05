import java.util.*;
import java.io.*;
import java.lang.*;

class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }

class LinkedList
{
    Node head;  
    Node tail;
    public void addToTheLast(Node node) 
    {
      if (head == null) 
      {
       head = node;
       tail = node;
      } 
      else 
      {
       tail.next = node;
       tail = node;
      }
    }
    
    public static void makeLoop(Node head, int x){
        if (x == 0)
            return;
        Node curr = head;
        Node last = head;

        int currentPosition = 1;
        while (currentPosition < x)
        {
            curr = curr.next;
            currentPosition++;
        }
        
        while (last.next != null)
            last = last.next;
        last.next = curr;
    }
      void printList()
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
    
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList llist= new LinkedList(); 
        int a1=sc.nextInt();
        Node head= new Node(a1);
        llist.addToTheLast(head);
        for (int i = 1; i < n; i++) 
        {
            int a = sc.nextInt(); 
            llist.addToTheLast(new Node(a));
        }
            
            
        int pos = sc.nextInt();
        llist.makeLoop(head, pos);
            
        Solution x = new Solution();
        boolean a=x.detectLoop(head);
        
        if(a==true)
            System.out.println(1);
        else
            System.out.println(0);
        
    }
}

class Solution
{
    //Function to remove a loop in the linked list.
    public static boolean detectLoop(Node head)
	{
    //your code here
		Node fast=head;
		Node slow=head;
		while(fast!=null && fast.next!=null)
		{
			fast=fast.next.next;
			slow=slow.next;
			if(fast==slow)
			{
				return true;
			}
		}
		return false;
	
    }
}
