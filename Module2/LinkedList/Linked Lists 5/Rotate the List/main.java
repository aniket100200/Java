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
    static int size(Node head)
	{
		int count=0;
		while(head!=null){
			head=head.next;
			count++;
		}
		return count;
	}
    static void rotateRight(Node head, int n)
	{
    // Your code here
		int size=size(head);
		n=n%size;

		Node temp=head;
		Node prev=null;
		for(int i=1;i<=size-n;i++)
		{
			prev=temp;
			temp=temp.next;
		}
		prev.next=null;

		Node t=temp;
		while(t.next!=null)
		{
			t=t.next;
		}
		t.next=head;
		while(temp!=null)
		{
			System.out.print(temp.data+" ");
			temp=temp.next;
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
        int k = sc.nextInt();
        Ob.rotateRight(l1.head, k);
    }
}
