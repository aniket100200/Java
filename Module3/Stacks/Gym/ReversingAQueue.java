import java.util.*;
import java.util.LinkedList;

class Solution {
    public Queue<Integer> reverseQueue(Queue<Integer> q)
	{
        // write code here
		Stack<Integer> st=new Stack<>();
		//Queue<Integer> ans =new ArrayDeque<>();
		while(q.size()>0)
		{
			st.push(q.remove());
		}
		while(st.size()>0)
		{
			q.add(st.pop());
		}
		return q;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            q.add(scn.nextInt());
        }
        scn.close();
        Solution Obj = new Solution();
        Queue<Integer> ans = Obj.reverseQueue(q);
        while (!ans.isEmpty()) {
            System.out.print(ans.peek() + " ");
            ans.remove();
        }
    }
}
