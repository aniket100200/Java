import java.util.*;

class Solution{
public static void solve(int n, int[] arr) 
	{
        // Your code here
		Map<Integer,Integer>map=new HashMap<>();
		for(int i: arr)
		{
			map.put(i,map.getOrDefault(i,0)+1);
		}
		int ans=0;
		
		for(int i=1;i<=n;i++)
		{
			int x=i;
			int first=map.getOrDefault(x,0)*map.getOrDefault(x+1,0)*map.getOrDefault(x+2,0);
			int second=map.getOrDefault(x,0)*map.getOrDefault(x+1,0)*(map.getOrDefault(x+1,0)-1)/2;
			int third=map.getOrDefault(x,0)*map.getOrDefault(x+2,0)*(map.getOrDefault(x+2,0)-1)/2;
			int fourth=map.getOrDefault(x,0)*(map.getOrDefault(x,0)-1)*map.getOrDefault(x+1,0)/2;
			int fifth=map.getOrDefault(x,0)*(map.getOrDefault(x,0)-1)*map.getOrDefault(x+2,0)/2;
			int sixth=map.getOrDefault(x,0)*(map.getOrDefault(x,0)-1)*(map.getOrDefault(x,0)-2)/6;
			ans+=(first+second+third+fourth+fifth+sixth);
			//map.remove(x);
		}
		System.out.println(ans);
		
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Solution.solve(n, arr);
    }
}

//there will be 6 cases..
/*
[x,x+1,x+2]
=> cnt(x)*cnt(x+1)*cnt(x+2);

[x,x+1,x+1]
=>cnt(x)*cnt(x+1)C2

[x,x+2,x+2]
=>cnt(x)*cnt(x+2)C2

[x,x,x+1]
=>cnt(x+1)*cnt(x)C2

[x,x,x+2]
=>cnt(x+2)*cnt(x)C2

[x,x,x]
=> cnt(x)C3
*/
