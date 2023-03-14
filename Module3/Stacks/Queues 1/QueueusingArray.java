import java.util.*;


class Queue 
{
    //Write your code here
	int[] arr;
	int start;
	int end;
	
    public Queue()
	{
		//Write your code here
		arr=new int[1000];	
		start=0;
		end=0;
		
    }

    public void push(int newElement)
	{
        //Write your code here
		if(arr[start]==0)
		{
			arr[end]=newElement;			
			return;
		}		
		if(end+1<arr.length)
		{
			arr[end+1]=newElement;
			end++;
		}	
		
    }
    public int pop()
	{
		if(arr[start]==0)
		{
			return -1;
		}
      int value=arr[start];
		arr[start]=0;
		start++;
		// if(start==end && arr[start]==0)
		// {
		// 	start=end=0;
		// }
		// else if(start>end)
		// {
		// 	start=end=0;
		// }
		return value;
    }
    public int front()
	{
        //Write your code here
		if(arr.length==0)
		{
			return -1;
		}
		return arr[start];
		
    }
    public int size() 
	{
        //Write your code here
		return end-start+1;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue q = new Queue();
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int op = sc.nextInt();
            if(op == 1) {
                int x = sc.nextInt();
                q.push(x);
            }
            else if(op == 2) {
                System.out.println(q.pop());
            }
            else if(op == 3)
                System.out.println(q.front());
            else if(op == 4)
                System.out.println(q.size());
        }
    }
}
