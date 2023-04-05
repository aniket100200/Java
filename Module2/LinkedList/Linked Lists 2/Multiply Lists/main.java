import java.util.*;
class Node
{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        next=null;
    }
}

class Main{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
        Node head=null;
        Node phead=null;
        int n=sc.nextInt();
        while(n-->0){
            int n1=sc.nextInt();
            if(head==null)
                head=new Node(n1);
            else
                addHead(head,n1);
        }
        int m=sc.nextInt();
        while(m-->0){
            int n1=sc.nextInt();
            if(phead==null)
                phead=new Node(n1);
            else{
                addHead(phead,n1);
            }
        }
		Solution g=new Solution();
        System.out.println(g.multiplyLists(head,phead));
	}
   
    public static void addHead(Node node,int a) {
          if (node == null)
            return;
		if(node.next==null)
			node.next=new Node(a);
		else
			addHead(node.next,a);
	}
}

class Solution{
   public long multiplyLists(Node l1,Node l2)
	{
        //add code here.
		long ans1=0;
		while(l1!=null)
		{
			ans1=(((ans1*10)%1000000007)+l1.data%1000000007)%1000000007;
			l1=l1.next;
		}

		long ans2=0;
		while(l2!=null)
		{
			ans2=(((ans2*10)%1000000007)+l2.data%1000000007)%1000000007;
			l2=l2.next;
		}

		return ((ans1%1000000007)*(ans2%1000000007))%1000000007;
		
   }
}
