import java.util.*;

class Solution {
    static int countEqualSubarray012(int arr[], int n)
    {
        //Write your code here 
		int count=0;
		//we'll map their diffrece .. i.e. d1#d2,with starting index..
		HashMap<String,Integer> map=new HashMap<>();
		int c0=0;
		int c1=0;
		int c2=0;
		int d1=0;//c1-c0
		int d2=0;//c2-c1
		{
			String key=d1+"#"+d2;
			map.put(key,1);
		}
		for(int i=0;i<n;i++)
		{
			if(arr[i]==0)
			{
				c0++;
			}
			else if(arr[i]==1)
			{
				c1++;
				
			}
			else if(arr[i]==2)
			{
				c2++;
			}
		d1=c1-c0;
		d2=c2-c1;
			String key=d1+"#"+d2;
		if(map.containsKey(key))
		{
			
			count+=map.get(key);
			map.put(key,map.get(key)+1);
		}
			else
		{
				map.put(key,1);
			}
				}
		return count;
         
    }   

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
    

        int arr[] = new int[N];

        for(int i=0; i<N; i++){
            arr[i]= sc.nextInt();
        }
        
        Solution Obj = new Solution();
        System.out.println(Obj.countEqualSubarray012(arr,N));

    }
}
