import java.util.*;

class Node {
    int val;
    Node next;

    Node(int d)
	{
        val = d;
        next = null;
    }
}

class LinkedList {
    Node head, tail;

    void push(Node new_node) 
	{
        if (head == null && tail == null)
		{
            head = tail = new_node;
            return;
        }
        tail.next = new_node; 
        tail = new_node;
    }

    void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

class Solution {
    public Node rearrangeList(Node head) 
	{
        //Write code here
		Node d1=new Node(-1);
		Node l1=d1;

		Node d2=new Node(-1);
		Node l2=d2;
		while(head!=null)
		{
			if((head.val)%2!=0)
			{
				l1.next=head;
				l1=l1.next;
			}
			else
			{
			
				l2.next=head;
				l2=l2.next;
			}
			head=head.next;
		}
		l1.next=null;
		l2.next=null;
		l2.next=d1.next;
		return d2.next;
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList llist = new LinkedList();
        int h1 = sc.nextInt();
        Node head = new Node(h1);
        llist.push(head);
        for (int i = 1; i < n; i++) {
            int data = sc.nextInt();
            llist.push(new Node(data));
        }
     
        Solution Obj = new Solution();
        head = Obj.rearrangeList(head);
        llist.printList(head);
        sc.close();
    }
}
