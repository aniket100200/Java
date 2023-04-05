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

class Main{
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    public static void main(String[] args)
{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int val = sc.nextInt();
        Node first = new Node(val);
        Node tail = first;
        for(int i=0; i<n-1; i++)
        {
            val = sc.nextInt();
            tail.next = new Node(val);
            tail = tail.next;
        }
        int m = sc.nextInt();
        val = sc.nextInt();
        Node second = new Node(val);
        tail = second;
        for(int i=0; i<m-1; i++)
        {
            val = sc.nextInt();
            tail.next = new Node(val);
            tail = tail.next;
        }
        
        Solution g = new Solution();
        Node res = g.subtract(first, second);
        printList(res);
    }
}

class Solution
{   
	public static Node reverse(Node curr)
	{
		Node prev=null;
		while(curr!=null)
		{
			Node temp=curr.next;
			curr.next=prev;
			prev=curr;
			curr=temp;
		}
		return prev;
		
	}
    static Node subtract(Node l1, Node l2)
    {
		// let's have dummy node to 
		while(l1.data==0)
		{
			Node curr=l1.next;
			l1.next=null;
			l1=curr;
		}
		while(l2.data==0)
		{
			Node curr=l2.next;
			l2.next=null;
			l2=curr;
		}
		Node d1=new Node(-1);
		Node t1=d1;
		l1=reverse(l1);
		Node L1=l1;
		l2=reverse(l2);
		Node L2=l2;
		//let's borrow
		int borrow=0;
		while(l1!=null || l2!=null)
		{
			int sum=borrow;
			
			if(l1!=null)
			{
				sum+=l1.data;
				l1=l1.next;
				borrow=0;
			}
			if(l2!=null)
			{
				if(l2.data>sum)
				{
					borrow=-1;
					sum+=10;
					sum-=l2.data;
					l2=l2.next;
				}
				else
				{
				borrow=0;
					sum-=l2.data;
					l2=l2.next;
				}
			}
			Node newNode=new Node(sum);
			t1.next=newNode;
			t1=newNode;				
		}
		if(borrow==-1)
		{
			return subtract(reverse(L2),reverse(L1));
		}	
		l1=reverse(d1.next);
			while(l1!=null &&l1.data==0)
		{
			Node curr=l1.next;
			l1.next=null;
			l1=curr;
		}
		
		return l1==null ? new Node(0): l1;
    }
}
