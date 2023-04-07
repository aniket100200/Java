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

class Solution
	{
    public static Node flatten(Node head, Node rest) 
	{
	   //know part and unknow part..
		if(head==null)return head;
		Node temp=head;
		while(temp.next!=null&& temp.child==null)
		{
			temp=temp.next;
		}
		//here means may be temp is pointing to nulll 
		//or child may be there...
		if(temp!=null)
		{
		
			Node f1=flatten(temp.child,temp.next);
			if(f1==null){
				temp.next=rest;
				return head;
			}
			temp.next=null;
			temp.next=f1;
			f1.prev=temp;
			while(f1.next!=null)
			{
				f1=f1.next;
			}
			f1.next=rest;
			return head;
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
