import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    final static int mod=1000000007;
    public static int maximumSum(int[] A, int[][] ops)
	{
		
	    //Step:1 creatinon of contribution array
		int[] cont=new int[A.length];

		//step2: add in ranges.. of contribution...
		for(int[] o: ops)
		{
			int si=o[0];
			int ei=o[1];
			cont[si]++;
			if(ei+1<A.length)cont[ei+1]--;
		}

		//we have contribution let's do the prefix summ...
		for(int i=1;i<cont.length;i++)	cont[i]+=cont[i-1];
		Arrays.sort(A);
		Arrays.sort(cont);
		int sum=0;
		for(int i=0;i<A.length;i++)
		{
			sum=((sum%mod)+((A[i]%mod)*(cont[i]%mod))%mod)%mod;
		}
		return sum;
		
		
    }
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
        long n = Long.parseLong(br.readLine().trim());
        String inputLine[] = br.readLine().trim().split(" ");
        int[] arr = new int[(int)n];
        for(int i=0; i<n; i++)arr[i]=Integer.parseInt(inputLine[i]);
        long m = Long.parseLong(br.readLine().trim());
        int[][] ops = new int[(int)m][2];
        for(int i=0; i<m; i++){
          String inputLine1[] = br.readLine().trim().split(" ");
          ops[i][0]=Integer.parseInt(inputLine1[0]);
          ops[i][1]=Integer.parseInt(inputLine1[1]);
        }
        System.out.println(maximumSum(arr, ops));
	}
}



