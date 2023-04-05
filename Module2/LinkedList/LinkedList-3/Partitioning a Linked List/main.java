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

class Solution 
{
    public void partition(Node head, int x)
	{
        Node d1=new Node(-1);
		Node l1=d1;
		Node d2=new Node(-1);
		Node l2=d2;
		while(head!=null)
		{
			if(head.data<x)
			{
				l1.next=head;
				head=head.next;
				l1=l1.next;
			}
			else{
				l2.next=head;
				l2=head;
				head=head.next;
			}
		}
		l1.next=null;
		l2.next=null;
		l1.next=d2.next;
		l1=d1.next;
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
        int x = sc.nextInt();
        Solution Ob = new Solution();
        Ob.partition(l1.head, x);
    }
}
