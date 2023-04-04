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
	static int count(Node head){
		int count=0;
		while(head!=null)
		{
			count++;
			head=head.next;
		}
		return count;
	}
	
    public static Node removeNthFromEnd(Node head, int n)
{
    //Write your code here 
	Node d1=new Node(-1);
	d1.next=head;
	head=d1;
	//let's count no. of node in the linked list..
	int cnt=count(head);
	int size=cnt-n;
	while(size-->1)
	{
		head=head.next;
	}
 Node rnode=head.next;
	head.next=head.next.next;
	rnode=null;
	return d1.next;
	
}
}

