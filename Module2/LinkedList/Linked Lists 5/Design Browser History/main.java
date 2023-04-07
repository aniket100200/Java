import java.util.*;

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        String homepage = sc.nextLine();
        int n = sc.nextInt();
        sc.nextLine();
        BrowserHistory browserHistory = new BrowserHistory(homepage);
        for(int i = 0; i < n; i++) {
            String q = sc.nextLine();
            String[] query = q.split("\\s+");
            if(query[0].equals("visit")){
                browserHistory.visit(query[1]);
            } else if(query[0].equals("back")){
                browserHistory.back(Integer.parseInt(query[1]));
            } else if(query[0].equals("forward")){
                browserHistory.forward(Integer.parseInt(query[1]));
            }
        }
    }
}
class Node{
	String web;
	Node next;
	Node prev;
	public Node(String web)
	{
		this.web=web;
		next=null;
		prev=null;
	}
}
class BrowserHistory {
	Node head;
	Node tail;
	Node curr;
    public BrowserHistory(String homepage)
	{
        // your code here
		Node n=new Node (homepage);
		head=n;
		tail=n;
		curr=n;
    }
    public void visit(String url)
	{
        // your code here
		Node newNode=new Node(url);
		curr.next=newNode;
		newNode.prev=curr;
		curr=newNode;
		tail=newNode;
    }
    public void back(int steps) 
	{
        // your code here
		while(curr!=head && steps>0)
		{
			curr=curr.prev;
			steps--;
		}
		System.out.println(curr.web);
    }
    public void forward(int steps) {
        // your code here
			while(curr!=tail && steps>0)
		{
			curr=curr.next;
			steps--;
		}
		System.out.println(curr.web);
    }
}
