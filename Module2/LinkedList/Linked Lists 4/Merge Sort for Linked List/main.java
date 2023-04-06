import java.util.*;

class Solution {
	  public static Node fMid(Node head)
	{
		  Node slow=head;
		Node fast=head;
		while(fast.next!=null && fast.next.next!=null){
			fast=fast.next.next;
			slow=slow.next;
		}
		return slow;
	  }
    public static Node mergesort(Node head)
	{
        //Write your code here
		if(head==null || head.next==null)
		{
			return head;
		}
		//first find the mid;
		Node mid=fMid(head);
		Node head2=mid.next;
		mid.next=null;
		
		Node temp1=mergesort(head);
		Node temp2=mergesort(head2);
		
		return merge(temp1,temp2);

    }
	public static Node merge(Node head1,Node head2)
	{
		Node dummy=new Node(-1);
		Node t=dummy;
		while(head1!=null && head2!=null)
		{
			if(head1.data<=head2.data)
			{
				t.next=head1;
				t=head1;
				head1=head1.next;
			}
			else{
				t.next=head2;
				t=head2;
				head2=head2.next;
			}
		}
		if(head1!=null)
		{
			t.next=head1;
		}
		else{
			t.next=head2;
		}
		return dummy.next;
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
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        LinkedList a = new LinkedList();
        for(int i = 0; i < n; i++){
            a.add(input.nextInt());
        }
        Solution Obj = new Solution();
        a.head = Obj.mergesort(a.head);
        Node h = a.head;
        while(h != null){
            System.out.print(h.data + " ");
            h = h.next;
        }
    }
}
