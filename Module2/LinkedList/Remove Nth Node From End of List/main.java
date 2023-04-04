import java.io.*;
import java.util.*;
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
class insertion
{
    Node head;  
    Node tail;
	public void addToTheLast(Node node) 
	{
	  if (head == null) 
	  {
	   head = node;
	   tail = node;
	  } 
	  else 
	  {
	   tail.next = node;
	   tail = node;
	  }
	}
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
	/* Drier program to test above functions */
	
}
class Main
{
    public static void main(String args[])throws IOException
    {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
            String S[] = br.readLine().split(" ");
			int N = Integer.parseInt(S[0]);
            int n = Integer.parseInt(S[1]);
    
		
		    String S1[] = br.readLine().split(" ");
			insertion llist = new insertion(); 
			int a1=Integer.parseInt(S1[0]);
			Node head= new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < N; i++) 
			{
				int a = Integer.parseInt(S1[i]);
				llist.addToTheLast(new Node(a));
			}
			
        Solution ob = new Solution();
		Node newhead=ob.removeNthFromEnd(llist.head, n);
		llist.printList(newhead);
    }
}

class Solution
{
	public static int  getSize(Node head)
	{
		Node temp=head;
		int count=0;
		while(temp!=null)
		{
			count++;
			temp=temp.next;
		}
		return count;
	}
    public static Node removeNthFromEnd(Node head, int n) 
{
    //Write your code here 
	/*int size=getSize(head);
	 n=size-n;
	/*
	if(n==0)
	{
		head=head.next;
		return head;
	}
	*/
	/*	Node dummy=new Node(-1);
	dummy.next=head;
	Node temp=head;
	Node prev=dummy;
	for(int i=0;i<n;i++)
	{
		prev=temp;
		temp=temp.next;
	}
	//here temp points the node whome do you wnat to remove

	prev.next=temp.next;
	temp=null;
	return dummy.next;
	*/

	/*One pass solution*/

	Node dummy=new Node(-1);
	dummy.next=head;

	Node front=dummy;
	Node back =dummy;

	//now create the gap of n between front and back

	for(int i=0;i<n;i++)
	{
		front=front.next;
	}

	//now dist betn back and front is n...

	//now move front and back simultaneously.. here we go...

	while(front.next!=null)
	{
		front=front.next;
		back=back.next;
	}

	back.next=back.next.next;
	return dummy.next;
}
}

