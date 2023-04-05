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
    static void unfold(Node head)
    {
     // Your code here
		Node d0=new Node(-1);
		Node l0=d0;

		Node d1=new Node(-1);
		Node l1=d1;

		Node d2=new Node(-1);
		Node l2=d2;

		while(head!=null)
		{
			if(head.data==0)
			{
				Node temp=new Node(head.data);
				l0.next=temp;
				l0=l0.next;
			}
			else if(head.data==1)
			{
				Node temp=new Node(head.data);
				l1.next=temp;
				l1=l1.next;
			}
			else
			{
				Node temp=new Node(head.data);
				l2.next=temp;
				l2=l2.next;
			}
			head=head.next;
		}

		//I've coppied 0's in d0 and l0 
		// 1's in d1 and l1
		//2's in d2 and l2
		l0.next=d1.next;
		
		l1.next=d2.next;
		l1=d0.next;
		while(l1!=null){
			System.out.print(l1.data+" ");
			l1=l1.next;
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
