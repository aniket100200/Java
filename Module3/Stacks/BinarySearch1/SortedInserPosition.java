import java.io.*;
import java.util.*;

public class Main {

    public static int searchInsert(int[] a, int b)
	{
        // Write code here
		//let's first search the element..
		//what will be the search range...
		int si=0,ei=a.length-1;
		int pans=a.length;
		while(si<=ei)
		{
			//first find the min and starte the elemination half of the array..
			int mid=(si+ei)/2;
			if(a[mid]==b)
			{
				return mid;
			}
			else if(a[mid]>b)
			{
				//so you should have to find it in left  side...
				pans=mid; //as you are moving towards left... this middle index may be your answer..
				ei=mid-1;
				
			}
			else
			{
				si=mid+1;
			}
			
		}
		return pans;
    }
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for(int i=0;i<N;i++){
            A[i] = sc.nextInt();
        }
        int B = sc.nextInt();
        System.out.println(searchInsert(A,B));
    }
}
