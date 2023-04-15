import java.util.*;
import java.io.*;
class Solution {
   public List<List<Integer>> fourSum(int[] arr, int target) 
	{
       // Write your code here
		Arrays.sort(arr);
		int n=arr.length;
		List<List<Integer>> list=new ArrayList<>();

		int i=0;
		while(i<n)
		{
			int j=i+1;
			while(j<n)
			{
				int newTarget=target-arr[i]-arr[j];
				int l=j+1;
				int r=n-1;
				while(l<r)
				{
					if(arr[l]+arr[r]==newTarget)
					{
						List<Integer> ls=new ArrayList<>();
						ls.add(arr[i]);
						ls.add(arr[j]);
						ls.add(arr[l]);
						ls.add(arr[r]);
						list.add(ls);
						int prevL=arr[l];
						while(l<r && arr[l]==prevL)l++;

						//
						int prevR=arr[r];
						while(r>l && arr[r]==prevR)r--;
					}
					else if(arr[l]+arr[r]<newTarget)
					{
							int prevL=arr[l];
						while(l<r && arr[l]==prevL)l++;
					}
					else
					{
							int prevR=arr[r];
						while(r>l && arr[r]==prevR)r--;
					}			
					
				}

				int prevJ=arr[j];
				while(j<n && prevJ==arr[j])j++;
				
			}
			int prevI=arr[i];
			while(i<n && prevI==arr[i])i++;
		}
		return list;
   }
}

public class Main
{
	    
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();
        int k = sc.nextInt();
        Solution Obj = new Solution();
        List<List<Integer>> res = Obj.fourSum(nums, k);

      
        for(int i= 0; i<res.size(); i++){
           Collections.sort(res.get(i));
        }

     
        Collections.sort(res, new Comparator<List<Integer>>() {
               public int compare(List<Integer> frst, List<Integer> scnd) {
                    int i=0;
                    while(frst.get(i)==scnd.get(i)) i++;
                    return frst.get(i)-scnd.get(i);
                    }
                });

        for(int i=0; i<res.size(); i++){   
            for(int j=0; j<4; j++){
                System.out.print(res.get(i).get(j) + " ");
            } 
            System.out.println("");
        }
        sc.close();
	}
}
