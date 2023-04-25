import java.io.*;
import java.util.*;

class Solution{
    static String complement(String bi)
	{
        //Write your code here
		//let' do 1's compliment

		//first reverse all the bits then 
		int[] arr=new int[bi.length()];
		for(int i=0;i<bi.length();i++)
		{
			char ch=bi.charAt(i);
			if(ch=='1')arr[i]=0;
			else arr[i]=1;
		}
		for(int i=arr.length-1;i>=0;i--)
		{
			if(arr[i]==1){arr[i]=0; continue;}
			arr[i]=1;
			break;
		}
		StringBuilder sb=new StringBuilder();
		for(int i: arr){
			sb.append(i);
		}
		return sb.toString();
    }
}
public class Main{
    public static void main(String args[])throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String bi = in.readLine();
        Solution ob = new Solution();
        System.out.println(ob.complement(bi));
    }
}
