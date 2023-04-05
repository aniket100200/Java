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
    static void printList(Node n)
	{
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
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

class Solution{ 
	static int size(Node head)
	{
		int count=0;
		
		while(head!=null)
		{
			count++;
			head=head.next;
			
		}
		return count;
	}
	static int compare(Node l1,Node l2)
	{
		//I'll return 1 if l1 is greater 
		//I'll return -1 if l2 is greater 
		//I'll return 0 if bothe are same;
		while(l1!=null)
		{
			if(l1.data>l2.data)
			{
				return 1;
			}
			if(l2.data>l1.data)
			{
				return -1;
			}
			l1=l1.next;
			l2=l2.next;	
		}
		return 0;
	}
    static Node subtract(Node l1, Node l2)
    {
		while(l1.data==0 && l1.next!=null)
		{
			l1=l1.next;
		}
		while(l2.data==0 && l2.next!=null)
		{
			l2=l2.next;
		}
		
       int n=size(l1);
		int m=size(l2);
		if(n<m)
		{
			Node temp=l1;
			l1=l2;
			l2=temp;
		}
		else if(m==n)
		{
			int x=compare(l1,l2);
			if(x==-1)
			{
				Node temp=l1;
				l1=l2;
				l2=temp;
			}
			else if(x==0)
			{
				return new Node(0);
			}
		}

		//I'm here means l1 is greater than l2...
		//here we go ....
		l1=reverse(l1);
		l2=reverse(l2);

		//sucessfully reverse the nodes.... or ll

		Node d1=new Node(-1);
		Node ans=d1;
		int sum=0;
		int borrow=0;
		while(l1!=null || l2!=null)
		{
			sum=borrow;
			if(l1!=null)
			{
				sum+=l1.data;
				l1=l1.next;
				borrow=0;
			
			}
			if(l2!=null)
			{
				if(sum<l2.data)
				{
					borrow=-1;
					sum+=10;
					sum-=l2.data;
				}
				else
				{
					borrow=0;
					sum-=l2.data;
				}
				l2=l2.next;
			}

			//here I've sum...
			ans.next=new Node(sum);
			ans=ans.next;			
		}
		ans=reverse(d1.next);
		while(ans.data==0 && ans!=null)
		{
			ans=ans.next;
		}
		return ans;
		
    }

	static Node reverse(Node head)
	{
		Node prev=null;
		while(head!=null)
		{
			Node curr=head.next;
			head.next=prev;
			prev=head;
			head=curr;
			
			
		}
		return prev;
	}
}
