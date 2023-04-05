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

	static Node reverse(Node head)
	{
		Node prev=null;
		while(head!=null)
		{
			Node temp=head.next;
			head.next=prev;
			prev=head;
			head=temp;
		}
		return prev;
	}
    static void unfold(Node head)
    {
     // Your code here
		Node d1=new Node(-1);
		Node l1=d1;
		Node d2=new Node(-1);
		Node l2=d2;

		while(head!=null)
		{
			Node newNode1=new Node(head.data);
			l1.next=newNode1;
			l1=l1.next;
			head=head.next;


			//here I'll do for the even node;
			if(head!=null)
			{
					Node newNode2=new Node(head.data);
			l2.next=newNode2;
			l2=l2.next;
			head=head.next;
			}
		}

		Node ans=new Node(-1);
		
		ans=d1.next;
		l2=reverse(d2.next);
		l1.next=l2;		
		while(ans!=null)
		{
			System.out.print(ans.data+" ");
			ans=ans.next;
		}
		
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
        Solution Ob = new Solution();
        Ob.unfold(l1.head);
    }
}
