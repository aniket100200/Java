import java.util.*;

class Node
	{

    int data;
    Node link;
	public Node(int data)
	{
		this.data=data;
		this.link=null;
	}
}

class Main {
	public static void main(String[] args)
	{
		StackUsingLinkedlist obj = new StackUsingLinkedlist();
		Scanner sc = new Scanner(System.in);
        int q;
        q = sc.nextInt();
        while(q-->0){
            int x;
            x = sc.nextInt();
            if(x==1){
                int y;
                y = sc.nextInt();
                obj.push(y);
            }
            if(x==2){
                System.out.println(obj.peek());
            }
            if(x==3){
                obj.pop();
            }
            if(x==4){
                Node temp = obj.display();
                while (temp != null) {

                    System.out.print(temp.data+" ");

                    temp = temp.link;
			    }
				System.out.println();
            }
        }
	}
}

class StackUsingLinkedlist
{

	Node top;
	StackUsingLinkedlist() 
	{ 
		this.top = null; 
	}
//this is push operation which takes O(1) time & space complexity..
	public void push(int x)
	{
		//Complete the function
		Node newNode=new Node(x);
		if(top==null)
		{
			top=newNode;
			return;
		}
		newNode.link=top;
		top=newNode;
	}

//this is peek operation which takes O(1) time & space complexity..
	public int peek()
	{
		if(top==null)
		{
			return -1;
		}
		return top.data;
	}
//this is operation operation which takes O(1) time & space complexity..
	public void pop()
	{
		if(top==null)
		{
			return ;
		}
		Node temp=top.link;
		top.link=null;
		top=temp;
	}

	public Node display()
	{
		return top;
	}
}
