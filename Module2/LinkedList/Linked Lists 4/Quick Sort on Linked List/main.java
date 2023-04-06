
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

    public static void addToTheLast(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = node;
        }
    }
}

class Solution 
{
    
    public static Node quickSort(Node node)   
	{
		if(node==null || node.next==null)
		{
			return node;
		}
        //Your code here
		Node[] arr=partition(node);
		//this will return...
		//arr[0]... left side...
		//arr[1]...  pivot...
		//arr[2]... right...
		Node pivot=arr[1];
		
		Node t1=quickSort(arr[0]);
		
		Node t2=quickSort(arr[2]);

		pivot.next=t2;
		
		if(t1==null)
		{
			return pivot;
		}
		Node temp=t1;
		while(temp.next!=null)
		{
			temp=temp.next;
		}
		temp.next=pivot;
		return t1;       
    }

	public static Node[] partition(Node head)
	{		
		Node pivot=head;
		
		Node temp=head.next;

		Node left=new Node(-1);
		
		Node l1=left;   
		
		Node right=new Node(-1); 		
		Node l2=right;

		while(temp!=null)
		{
			if(temp.data<=pivot.data)
			{
				l1.next=temp;
				l1=temp;
				temp=temp.next;
			}
			else
			{
				l2.next=temp;
				l2=temp;
				temp=temp.next;
			}
		}
		l1.next=null;
		l2.next=null;
	Node []arr={left.next,  pivot,  right.next};
		return arr;
		
	}

}
