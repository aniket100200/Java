import java.util.Scanner;

class Node {
    int val;
    Node prev;
    Node next;
    Node child;

    public Node(int value, Node prev, Node next, Node children) {
        this.val = value;
        this.prev = prev;
        this.next = next;
        this.child = children;
    }
}

class Solution {
    public static Node flatten(Node head, Node rest)
	{
        //Write your code here
		Node temp=flat(head);
		return temp;
    }
	public static Node flat(Node head)
	{
		Node temp=head;
		while(temp!=null)
		{
			if(temp.child!=null)
			{
				Node p=flat(temp.child);
				Node Next=temp.next;//this is refrence to the next node of present node who 
				// has child pointer.. not null;
				temp.next=p;
				p.prev=temp;
				temp.child=null;

				Node tt=temp;
				while(tt.next!=null)
				{
					tt=tt.next;
				}
				tt.next=Next;
				if(Next!=null)
				{
					Next.prev=tt;
				}
				temp=temp.next;
			}
			else
			{
				temp=temp.next;
			}
		}
		return head;
	}

   

}

public class Main {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        Node head = new Node(0, null, null, null); // extra node
        Node curr = head;
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            Node temp = new Node(a, curr, null, null);
            curr.next = temp;
            curr = temp;
        }
        head = head.next;
        curr = head;

        int level = scanner.nextInt();
        while (level-- > 0) {
            int ind = scanner.nextInt();

            int numNodes = scanner.nextInt();

            while (ind-- > 0) {
                curr = curr.next;
            }

            int a = scanner.nextInt();
            curr.child = new Node(a, null, null, null);
            curr = curr.child;
            Node newHead = curr;
            numNodes--;

            while (numNodes-- > 0) {
                a = scanner.nextInt();
                Node temp = new Node(a, curr, null, null);
                curr.next = temp;
                curr = temp;
            }

            curr = newHead;
        }
        Solution Obj = new Solution();
        Node ans= Obj.flatten(head,null);

        while(ans!=null){
            System.out.print(ans.val + " ");
            ans=ans.next;
        }

    }
}
