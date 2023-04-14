import java.util.*;
import java.lang.*;
import java.io.*;
	/***** O(N2) Solution**************/
class Main {
    
    public static int[] twoSum(int[] A, int target) {
       // Your code here
		int[] a=new int[2];
		for(int i=0;i<A.length-1;i++){
			int count=0;
			for(int j=i+1;j<A.length;j++){
				if(A[i]+A[j]==target){
					a[0]=i+1;
					a[1]=j+1;
					count++;
					break;
				}
				
			}
			if(count>0){
				break;
			}
		}
		return(a);
    }
	
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
        long n = Long.parseLong(br.readLine().trim());
        String inputLine[] = br.readLine().trim().split(" ");
        int[] arr = new int[(int)n];
        for(int i=0; i<n; i++)arr[i]=Integer.parseInt(inputLine[i]);
        int m = Integer.parseInt(br.readLine().trim());
        int[] ans = (twoSum(arr, m));
        System.out.println(ans[0] + " " + ans[1]);
	}
}



