import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cap = sc.nextInt(), q = sc.nextInt();
        String[] queries = new String[q];
        for (int i = 0; i < q; i++) {
            String s = sc.next();
            if (s.equals("GET"))
                s += " " + sc.nextInt();
            else
                s += " " + sc.nextInt() + " " + sc.nextInt();
            queries[i] = s;
        }
        sc.close();
        LRUCache lruCache = new LRUCache(cap);
        for (String s : queries) {
            String[] arr = s.split(" ");
            if (arr.length == 3)
                lruCache.set(Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
            else
                System.out.println(lruCache.get(Integer.parseInt(arr[1])));
        }
    }
}
class Node
{
	int key;
	int value;
	Node prev;
	Node next;
	public Node(){}
	public Node(int key,int value)
	{
		this.key=key;
		this.value=value;
		this.prev=null;
		this.next=null;
	}
}

class LRUCache {
    // your code here
	Node head;
	Node tail;
	int maxCapacity;
	Map<Integer,Node> chache;
    public LRUCache(int capacity) 
	{
        // your code here
		head=new Node();
		tail=new Node();
		head.next=tail;
		tail.prev=head;
		maxCapacity=capacity;
		chache=new HashMap<>();
    }
	private void addFirst(Node node)
	{
		Node A=head.next;
		head.next=node;
		node.next=A;
		node.prev=head;
		A.prev=node;
	}
	private void removeNode(Node node)
	{
		Node A=node.prev;
		Node B=node.next;
		A.next=B;
		B.prev=A;
		node.next=null;
		node.prev=null;
	}

	private void moveToFront(Node node)
	{
		removeNode(node);
		addFirst(node);
	}

    public int get(int key)
	{
        // your code here
		if(chache.containsKey(key)==false)return -1;
		Node application=chache.get(key);
		moveToFront(application);
		return application.value;
    }

    public void set(int key, int value)
	{
        // your code here

		//1) it may new application or trying to updatae...	
		if(chache.containsKey(key))
		{
			//trying to updata...
			Node application=chache.get(key);
			application.value=value;
			moveToFront(application);
		}
		else
		{
			//new application....

			//check cache space..
			if(chache.size()==maxCapacity)
			{
				// you'll have to remove LRU
				//firs get..
				Node LRU=tail.prev;
				removeNode(LRU);
				chache.remove(LRU.key);
			}
			Node application=new Node(key,value);
			addFirst(application);
			chache.put(key,application);
		}
    }

}
