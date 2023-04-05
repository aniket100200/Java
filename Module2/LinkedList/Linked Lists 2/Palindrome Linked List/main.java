import java.util.*;


public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList llist= new LinkedList(); 
        int a1=sc.nextInt();
        Node head= new Node(a1);
        llist.addToTheLast(head);
        for (int i = 1; i < n; i++) 
        {
            int a = sc.nextInt(); 
            llist.addToTheLast(new Node(a));
        }
            
        Solution A = new Solution();
        A.checkLinkedListPalindrome(llist.head);
        
    }
}

class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
    
class LinkedList
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
{
	
    static void checkLinkedListPalindrome(Node head)
    {
        //Your code here
		Node temp=head;
		Node dummy=new Node(-1);
		Node t1=null;
		while(temp!=null)
		{
			Node newNode=new Node(temp.data);
			if(t1==null)
			{
				t1=newNode;
			}
			else
			{
				newNode.next=t1;
				t1=newNode;
			}
			temp=temp.next;
			
		}
	//#reversd successfully...
		while(t1!=null)
		{
			if(t1.data!=head.data)
			{
				System.out.println("NO");
				return;
			}
			t1=t1.next;
			head=head.next;
		}
		System.out.println("YES");
    }
    
}
