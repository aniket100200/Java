
import java.util.*;
import java.io.*;
public class Main {
    
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        LinkedList a = new LinkedList();
        LinkedList b = new LinkedList();
        for(int i = 0; i < n; i++){
            a.add(input.nextInt());
        }
        for(int i = 0; i < m; i++){
            b.add(input.nextInt());
        }
        LinkedList ans = new LinkedList();
        Solution A = new Solution();
        ans.head = A.addTwoLinkedLists(a.head, b.head);
        ans.printList();

    }
}


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


class Solution
{public static Node reverse(Node head)
	{
		Node prev=null;
		Node curr=head;
		while(curr!=null)
		{
			Node temp=curr.next;
			curr.next=prev;
			prev=curr;
			curr=temp;
			
		}
		return prev;
		
	}

    public static Node addTwoLinkedLists(Node head1, Node head2)
    {
        //Write your code here
		Node l1=reverse(head1);
		Node l2=reverse(head2);


		//bothe the list are reverse... 
		
        Node dummy=new Node(-1);
		Node t=dummy;
		int sum=0;
		int carry=0;

		while(l1!=null || l2!=null)
		{
			sum=carry;
			if(l1!=null){
				sum+=l1.data;
				l1=l1.next;
			}
			if(l2!=null)
			{
				sum+=l2.data;
				l2=l2.next;
			}
			t.next=new Node(sum%10);
			t=t.next;
			carry=sum/10;
		}
		if(carry!=0)
		{
			t.next=new Node(carry);
			
		}
		return reverse(dummy.next);
    }
    
    
}
