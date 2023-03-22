import java.util.*;

class Solution
{	
    static int count1(int size, int arr[])
	{
        //Write your code here
		//let's find first and last occurence of the 1...
		
		//first occurece means floor value...
		int fi=0;

		//last occurence or ceil value...
		int li=findLast(arr,0,size-1);
		
		return li-fi+1;
    }

			static int findLast(int[] arr,int si,int ei)
		{
			//let's we'll say last occurence is.. 
			int plo=-1;
			while(si<=ei)
			{
				int mid=(si+ei)/2;
				//this is mid......----<>-----<<<<<<<

				if(arr[mid]==1)
				{
					//let's try to move towards.. right..
					plo=mid;
					si=mid+1;
				}
				else
				{
					//let's move towards left..
					ei=mid-1;
				}
			}
			return plo;
		}

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int array[] = new int[n];

        for(int i=0; i<n; i++){
            array[i]= sc.nextInt();
        }
        Solution Obj = new Solution();
        System.out.println(Obj.count1(n,array));
    }
}
