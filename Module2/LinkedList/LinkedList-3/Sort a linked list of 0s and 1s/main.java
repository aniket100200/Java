import java.util.*;

class Solution {
    static LinkedListNode sort01(LinkedListNode head)
	{
        // Write your code here
		LinkedListNode d0=new LinkedListNode(-1);
		LinkedListNode l0=d0;

		LinkedListNode d1=new LinkedListNode(-1);
		LinkedListNode l1=d1;

		while(head!=null)
		{
			if(head.data==0)
			{
				l0.next=head;
				l0=l0.next;
			}
			else
			{
				l1.next=head;
				l1=l1.next;
			}
			head=head.next;
		}
		
		l0.next=null;
		l1.next=null;

		
		l0.next=d1.next;
		l0=d0.next;
		return l0;
    }
}

class LinkedListNode  {
    int data;
    LinkedListNode next;

    public LinkedListNode(int data)  {
        this.data = data;
    }
	
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedListNode head = new LinkedListNode(sc.nextInt());
        LinkedListNode a = head;
        for(int i=1;i<n;i++) {
            LinkedListNode temp = new LinkedListNode(sc.nextInt());
            a.next = temp;
            a = temp;
        }
        LinkedListNode ans = Solution.sort01(head);
        for(int i=0;i<n;i++) {
            if(i == n-1) {
                System.out.println(ans.data);
            }
            else {
                System.out.print(ans.data + " ");
            }
            ans = ans.next;
        }
    }
}
