import java.util.*;

public class Main {

    public static int ValidTriangles(int n,int[] arr)
	{
        //write code here
		/* Time complexity for this is O(N2) */
		Arrays.sort(arr);
		//You should have to know the basics of Triangle...
		int ans=0;
		//i.e sum Of two smaller sider > larger side.. then it is called triangle..
		for(int i=n-1;i>=0;i--)
		{
		//this will take O(n)..
			//one point is fixed and  you have to compare those smaller people who are 
			//smaller than it.. can sum greater than it. .
			//use Two sum with two Pointer.. 
			int l=0;
			int r=i-1;
			while(l<r)
			{
				// O(n-1).. 
				if(arr[l]+arr[r]>arr[i])
				{
					ans+=r-l;
					r--;
				}
				else l++;
			}
		}
		//so overall time complexity is O(n*(n-1))~ O(n2)//
		return ans;
    }

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        for(int i=0;i<n;++i){
            arr[i]=sc.nextInt();
        }
        int ans = ValidTriangles(n,arr);
        System.out.println(ans);
    }
}
