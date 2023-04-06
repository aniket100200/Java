
import java.util.*;
class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

class Main {
    static Node head;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        int n = sc.nextInt();
        int a1 = sc.nextInt();
        Node head = new Node(a1);
        addToTheLast(head);

        for (int i = 1; i < n; i++) {
            int a = sc.nextInt();
            addToTheLast(new Node(a));
        }

        Solution abc=new Solution();
        Node node = abc.quickSort(head);

        printList(node);
        System.out.println();
    
        sc.close();
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void addToTheLast(Node node)
	{
        if (head == null) 
		{
            head = node;
        } 
		else 
		{
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = node;
        }
    }
}

class Solution 
{
	static class Trip
	{
		Node pi;
		Node left;
		Node right;
		Trip(Node pi, Node left, Node right)
		{
			this.pi=pi;
			this.left=left;
			this.right=right;
		}
	}
	static Trip partition(Node head)
	{
		Node pi=head;
		head=head.next;
		
		Node left=new Node(-1);
		Node l=left;
		Node right=new Node(-1);
		Node r=right;
		while(head!=null)
		{
			if(head.data<=pi.data)
			{
				l.next=head;
				l=head;
				head=head.next;
			}
			else
			{
				r.next=head;
				r=head;
				head=head.next;
			}	
		}
		l.next=null;
		r.next=null;
		return new Trip(pi,left.next,right.next);
	}
    
    public static Node quickSort(Node node)
    {
		if(node==null || node.next==null)return node;
        //Your code here
		Trip t=partition(node);
		//as you have partion index...
		Node left=t.left;
		Node pi=t.pi;
		Node right=t.right;

		left=quickSort(left);
		right=quickSort(right);
		pi.next=right;
		if(left==null)
		{		
			return pi;
		}
		Node l=left;
		while(l.next!=null)
		{
			l=l.next;
		}
		l.next=pi;		
		return left;       
    }

}
