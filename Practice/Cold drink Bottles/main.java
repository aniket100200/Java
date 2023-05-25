import java.io.*;
import java.util.*;

class Solution {

    public List<Integer> coldDrink(int arr[], int n, int k) 
	{
        // write code here
		List<Integer> ans=new ArrayList<>();
		Map<Integer,Integer> map=new HashMap<>();
		int min=n+5;
		int si=0;
		int ei=0;
		int sps=-1;
		int eps=-1;

		while(ei<n)
		{
			//Introduce a new person.
			int ele=arr[ei];
			map.put(ele,map.getOrDefault(ele,0)+1);

			//you have the elements.. 

			//let's contract the window... as it has more size..
			while(si<=ei && map.size()==k)
			{
				if(ei-si+1<min)
				{
					sps=si;
					eps=ei;
					min=ei-si+1;
				}
				//remove it..
				int rem=arr[si];
				map.put(rem,map.get(rem)-1);
				if(map.get(rem)==0)map.remove(rem);
				si++;
			}

			//let's expand your window..
			ei++;
		}
	if(sps==-1){
		ans.add(-1);
		return ans;
	}
		ans.add(sps);
		ans.add(eps);
		return ans;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Solution Obj = new Solution();
        List<Integer> ans = Obj.coldDrink(arr, n, k);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        sc.close();
    }
}
