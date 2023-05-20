//based on bubble sort 
//T.c. O(n2) ...
import java.util.*;
class Main{
	public static void main(String[] args){
		try (Scanner sc = new Scanner(System.in)) {
			int t=sc.nextInt();
			while(t>0){
				int n=sc.nextInt();
				int []A=new int[n];
				for(int i=0;i<n;i++){
					A[i]=sc.nextInt();
				}
				Solution ob =new Solution();
				int ans = ob.CountingInversions(A,0,n-1);
                System.out.print(ans);
                System.out.println();
				t--;
			}
		}
	}

}
class Solution {
    public int CountingInversions(int[] arr,int l,int r)
{
        //Write code here
	int count=0;
	for(int i=0;i<arr.length;i++)
	{
		boolean swap=false;
		for(int j=0;j<arr.length-1-i;j++)
		{
			//I'll compare the current element with next one..
			if(arr[j]>arr[j+1]){
				//swap..
				int temp=arr[j];
				arr[j]=arr[j+1];
				arr[j+1]=temp;
				//swappint done..
				count++;
				swap=true;
			}
		}
		if(swap==false)
		{
			System.out.print(Arrays.toString(arr));
			return count;
		}
	}
	return count;
	
}
}
