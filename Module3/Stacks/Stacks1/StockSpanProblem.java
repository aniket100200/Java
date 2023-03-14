import java.io.*;
import java.util.*;

class Pair
{
    int val;
    int idx;
    Pair(int val, int idx)
	{
        this.val = val;
        this.idx = idx;
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = input.nextInt();
        }
        Solution s  = new Solution();
        int ans[] = s.stockSpan(a);
        for(int i = 0; i < n; i++){
            System.out.print(ans[i] + " ");
        }
    }
}

class Solution {
	static int[] NextGretestElem(int[] a)
	{
		//as i have to find next gretest element... or previous greatese elem
		//I'll need stack...
		Stack<Integer> st=new Stack<>();
		int[] ngre=new int[a.length];
		for(int i=a.length-1;i>=0;i--)
		{
			//lets take element.. 
			int ele=a[i];
			//this present element can be nextGretest element in left.
			while(st.size()>0 && ele>a[st.peek()])
			{
				int idx=st.peek();
				st.pop();
				ngre[idx]=i;
			}
			st.push(i);
		}
		//still I've some elements in stack... 
		while(st.size()>0)
		{
			ngre[st.pop()]=-1;
		}
		return ngre;
	}
    static int[] stockSpan(int[] a)
	{
        // Span means...
		//index of present element - index of Greatest element to the left that element..
		int[] span=new int[a.length];
		int[] ngre=NextGretestElem(a);
		for(int i=0;i<a.length;i++)
		{
			span[i]=i-ngre[i];
		}
		return span;
    }
}
