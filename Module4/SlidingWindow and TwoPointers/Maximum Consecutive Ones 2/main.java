import java.util.*;

class Solution {
    static int maxOne(int arr[], int n,int k)
    {
        //Write your code here
		int cntz=0;
		int i=0,j=0;
		int ans=0;
		while(j<n)
		{
			//s1: introduce a new person... 
			if(arr[j]==0)
			{
				cntz++;
			}

			//s2: shring till invalid...

			while(cntz>k)
			{
				if(arr[i]==0)
				{
					cntz--;
				}
				i++;
			}

			//s3: let's calculate the answer...

			ans=Math.max(ans,j-i+1);

			//let's expand the window
			j++;
		}
		return ans;
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int k= sc.nextInt();
        int array[] = new int[n];

        for(int i=0; i<n; i++){
            array[i]= sc.nextInt();
        }
        Solution Obj = new Solution();
        System.out.println(Obj.maxOne(array,n,k));
    }
}
