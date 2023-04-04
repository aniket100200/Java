import java.io.*;
import java.util.*;
 
class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        next = null;
    }
}
class LinkedList{
    Node head;
    void add(int data ){
        Node new_node = new Node(data);
        if(head == null){
            head = new_node;
            return;
        }
        Node current = head;
        while(current.next !=null){
            current = current.next;
        }
        current.next = new_node;
    }
}

class Solution {
 static Node merge(Node x, Node y)
	{
       // Write your code here
		/*
		Node l1=x;
		Node l2=y;
		Node dummy=new Node(-1);//dummy node which means a lot
		Node prev=dummy;//prev pointer

		while(l1!=null && l2!=null)
		{
			if(l1.data<l2.data)
			{
				prev.next=new Node(l1.data);
				l1=l1.next;
				prev=prev.next;				
			}
			else
			{
				prev.next=new Node(l2.data);
				l2=l2.next;
				prev=prev.next;
			}
		}
		while(l1!=null)
		{
			prev.next=new Node(l1.data);
			prev=prev.next;
			l1=l1.next;
		}
		while(l2!=null)
		{
				prev.next=new Node(l2.data);
				l2=l2.next;
				prev=prev.next;		
		}

	return dummy.next;
		*/

		//here I wanted to optimize mine code so here we go...

		Node l1=x;
		Node l2=y;

		//I'm not using diffrent linked list but I'll use concept of 
		//dummy node so here you go aniket...
	//lets' say I have a dummy node here

		Node dummy=new Node(-1);
		Node prev=dummy;
		while(l1!=null&& l2!=null)
		{
			if(l1.data<l2.data)
			{
				prev.next=l1;				
				l1=l1.next;
				prev=prev.next;
				
			}
			else
			{
				prev.next=l2;				
				l2=l2.next;
				prev=prev.next;

				
			}
		}

		//<--->---Here you go bahut kuch ...>--><---><---><---->

		if(l1!=null)
		{
			prev.next=l1;
		}
		else
		{
			prev.next=l2;
		}
		return dummy.next;
	}
}

public class Main {
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList l1= new LinkedList();
        for(int i=0;i<n;i++){
            l1.add(sc.nextInt());
        }
        int m = sc.nextInt();
        LinkedList l2 = new LinkedList();
        for(int i=0;i<m;i++){
            l2.add(sc.nextInt());
        }

        Solution Ob = new Solution();
        Node head = Ob.merge(l1.head, l2.head);
        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}
