import java.util.*;
import java.io.*;


public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        LinkedList ll = new LinkedList();
        int n = input.nextInt();
        for(int i = 0; i < n; i++){
            int x = input.nextInt();
            ll.add(x);
        }
        int toRemove = input.nextInt();
        Solution s = new Solution();
        s.remove(ll, toRemove);
        Node curr = ll.head;
        while(curr != null){
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}

 
class Node{
    int data;
    Node next = null;
    Node(int data){
        this.data = data;
        next = null;
    }
}
class LinkedList{
    Node head;
    void add(int data){
        Node new_node = new Node(data);
        if(head == null){
            head = new_node;
            return;
        }
        Node curr = head;
        while(curr.next != null)
            curr = curr.next;
        curr.next = new_node;
    }
}
 
class Solution {
    public static void remove(LinkedList ll, int toRemove)
	{
	    //if you wanted to remove    first element 
		//you have take care of head node ... which is important in 
		//Linked list....> if you don't have head you don't have 
		// access to LinkedList... here we go...
		if(toRemove==0)
		{
			ll.head=ll.head.next;
		
			return;
		}
		
		Node curr=ll.head;//
		Node prev=null;

			
		for(int i=0;i<toRemove;i++)
		{
			prev=curr;
			curr=curr.next;
		}
		prev.next=curr.next;
		curr=null;
    }
}
