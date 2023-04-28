import java.io.*;
import java.util.*;
class Main{
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
        int n,q;
        n=sc.nextInt();
        q=sc.nextInt();
        int[] a= new int[n];
        for(int i=0;i<n;i++){
          a[i] = sc.nextInt();
        }
        Solution obj=new Solution();
        System.out.println(obj.minSubarray(a,n,q));		    
    }
}

class Solution {
    public static int minSubarray(int[] nums,int n, int p)
    {
 //let's find the total sum...'
        long tSum=0;
        for(int i: nums){
			tSum=(tSum+i)%p;
		}
        int rem=(int)tSum%p;
        if(rem==0)return 0;
        //this is remainder you wanted to search in the array... 
        //If it is possible to get the return answer...
        HashMap<Long,Integer> map=new HashMap<>();
        map.put(1L*0,-1);
        long sum=0;
        int min=nums.length;
        for(int i=0;i<nums.length;i++)
        {
            sum=(sum+nums[i])%p;

            int currRem=(int)sum-rem;
          
            if(map.containsKey(sum-rem))
            {
                int len=i-map.get(sum-rem);
              if(min>len)
              {
                  min=len;
              }
            }
            else if(map.containsKey(sum-rem+p))
            {
            int len=i-map.get(sum-rem+p);
              if(min>len)
              {
                  min=len;
              }
            }
            map.put(sum,i);
        }
        return  min==nums.length ? -1: min;
    }
}
