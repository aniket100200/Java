import java.util.*;

class Node
{
	int data;
	Node next;
	
	Node(int d)
	{
		data = d;
		next = null;
	}
}

class Main
{
	Node head;
	void printList(Node head)
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }

	public void addToTheLast(Node node) 
	{
		if (head == null) 
		{
			head = node;
		} else 
		{
		   Node temp = head;
		   while (temp.next != null)
		   temp = temp.next;

		   temp.next = node;
		}
    }

	public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Main llist = new Main();
		int a1 = sc.nextInt();
		Node head = new Node(a1);
        llist.addToTheLast(head);
        for (int i = 1; i < n; i++) 
		{
			int a = sc.nextInt(); 
			llist.addToTheLast(new Node(a));
		}
		int x = sc.nextInt();
        Node node = head;
        while(node!=null)
        {
            if(node.data == x)
            break;
            node=node.next;
        }
		Solution g = new Solution(); 
		g.deleteNode(node);
		llist.printList(llist.head);
	}
}

class Solution
{
    void deleteNode(Node node)
    {
	    // Your code here
		Node prev=null;
		while(node.next!=null)
		{
			prev=node;
			node.data=node.next.data;
			node=node.next;			
		}
		prev.next=null;
		return;
       
    }
}
