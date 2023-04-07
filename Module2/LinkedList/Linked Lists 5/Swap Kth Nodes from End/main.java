import java.util.*;
import java.io.*;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        next = null;
    }
}
class LinkedList{
    Node head;
    void add(int data){
        Node new_node = new Node(data);
        if(head == null){
            head = new_node;
            return;
        }
        Node curr = head;
        while(curr.next != null)
            curr = curr.next;
        curr.next = new_node;
    }
}

class Solution{
	Node swapkthnode(Node head, int num, int K)
    {
        //Write your code here
		//node form begining...
		Node temp=head;
		for(int i=0;i<num-K;i++)
		{
			temp=temp.next;
		}
		Node temp2=head;
		for(int i=0;i<K-1;i++)
		{
			temp2=temp2.next;
		}

		int tempe=temp.data;
		temp.data=temp2.data;
		temp2.data=tempe;
		return head;
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        LinkedList list = new LinkedList();
        for(int i = 0; i < n; i++){
            int x = input.nextInt();
            list.add(x);
        }
        Solution obj = new Solution();
		list.head = obj.swapkthnode(list.head, n, k);
		Node curr = list.head;
		while(curr != null){
			System.out.print(curr.data + " ");
			curr = curr.next;
	    }
	}
}
