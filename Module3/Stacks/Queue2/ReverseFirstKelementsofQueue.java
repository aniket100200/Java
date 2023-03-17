import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), k = input.nextInt();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++)
		{
            q.add(input.nextInt());
        }
        // write code here
		Stack<Integer> st=new Stack<>();
		int size=q.size();
		 Queue<Integer> que = new LinkedList<>();
		for(int i=1;i<=k;i++)
		{
			st.push(q.remove());
		}
		while(q.size()>0)
		{
			que.add(q.remove());
		}
			while(st.size()>0)
		{
			q.add(st.pop());
		}
		
		while(que.size()>0)
		{
			q.add(que.remove());
		}	
		
        while(q.size() > 0)
		{
            System.out.print(q.poll() + " ");
        }
    }
}
