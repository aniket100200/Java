
import java.util.*;
import java.lang.*;

class Node{
    int data;
    Node next;
    Node(int key){
        data = key;
        next = null;
    }
}

class Main{
    static Node head;
    static Node temp;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0){
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            head = null;
            temp = null;
            addToTheLast(a1);
            
            for(int i = 1; i < n; i++){
                int data = sc.nextInt();
                addToTheLast(data);
            }
            Solution ans = new Solution();
            Node node = ans.rearrange(head);
            printList(node);
            System.out.println();
        }
    }
    
    public static void addToTheLast(int data){
        if(head == null){
			head = new Node(data);
			temp =head;
			return ;
		}
		else{
			Node new_node = new Node(data);
			temp.next = new_node;
			temp=temp.next;
			return;		
		}
    }
    
    public static void printList(Node node){
        while(node != null){
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}

class Solution
{
	static Node reverse(Node head)
	{
		Node curr=head;
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
    public static Node rearrange(Node node)
	{
       //Write code here
		Node fast=node;
		Node slow=node;

		while(fast!=null && fast.next!=null)
		{
			fast=fast.next.next;
			slow=slow.next;			
		}
		Node l1=slow.next;
		slow.next=null;
		
      //now I've split the LinkedList

			//now reverse the l1 node or linkedlist
		l1=reverse(l1);
		//NOw take the Dummy node here you go
		Node dummy=new Node(-1);
		dummy.next=node;
	Node curr=dummy;

		while(node!=null || l1!=null)
		{
			if(node!=null)
			{
				Node temp=new Node(node.data);
				curr.next=temp;
				curr=temp;
				node=node.next;
			}
			if(l1!=null)
			{
				Node temp=new Node(l1.data);
				curr.next=temp;
				curr=temp;
				l1=l1.next;
				
			}
		}
		return dummy.next;
    }
}

