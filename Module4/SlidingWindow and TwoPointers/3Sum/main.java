import java.io.*;
import java.util.*;



class Main {
    
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }
        Solution solution = new Solution();
        List<List<Integer>> result = solution.threeSum(nums);
        //Sort all lists inside the list first
        for (int i = 0; i < result.size(); i++) {
            Collections.sort(result.get(i));
        }
        //Sort the list
        Collections.sort(result, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> l1, List<Integer> l2) {
                for (int i = 0; i < l1.size(); i++) {
                    if (l1.get(i) < l2.get(i)) return -1;
                    else if (l1.get(i) > l2.get(i)) return 1;
                }
                return 0;
            }
        });
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}

class Solution {
    public List<List<Integer>> threeSum(int[] arr)
	{
		/*** Tc:- O(n2);... for 3Sum
		/*I'll fixed one point then I'll apply two sum on it...***/
		Arrays.sort(arr);
		int n=arr.length;
	List<List<Integer>>list=new ArrayList<>();
		// let's we have target===0;
		int tar=0;		
		int i=0;
		while(i<n)
		{
			//fixed a single point and we have take care of this... 
			//we'll use two sum on it...>>>><<<<
			int newTar=tar-arr[i];
			int l=i+1;
			int r=n-1;
			while(l<r)
			{
				if(arr[l]+arr[r]==newTar)
				{
					List<Integer> ls=new ArrayList<>();
					ls.add(arr[i]);
					ls.add(arr[l]);
					ls.add(arr[r]);
					list.add(ls);

					//left duplicates...
					int prevL=arr[l];
					while(l<r && prevL==arr[l])l++;

					//right duplicates...
					int prevR=arr[r];
					while(r>l&& arr[r]==prevR)r--;
				}
				else if(arr[l]+arr[r]<newTar)
				{
					int prevL=arr[l];
					while(l<r && prevL==arr[l])l++;
				}
				else
				{
					int prevR=arr[r];
					while(r>l&& arr[r]==prevR)r--;
				}
			}

			//let's handle thisduplicates which may or may not good.. 
			int prevI=arr[i];
			while(i<n && prevI==arr[i])i++;
		}
		return list;
    }
}
