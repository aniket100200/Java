import java.util.*;

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = Solution.isCubeFree(n);
        System.out.println(ans);
    }
}

class Solution {

    static int isCubeFree(int n) 
	{
		// Write your code here
		//le't find  all the cubes from 
		Set<Integer> set=new HashSet<>();
		for(int i=2;i<=50;i++)
		{
			set.add(i*i*i);
			if(n%(i*i*i)==0)return -1;
		}
		
		int count=0;		
	for(int i=1;i<=n;i++)
	{
		boolean flag=false;
		for(int j: set)
		{
			if(i%j==0)
			{
				flag=true;
				break;
			}
		}
		if(flag)continue;
		count++;
	}
		return count;
		
		
    }
	static void find(int n,Set<Integer> set)
	{
		
	}
}
