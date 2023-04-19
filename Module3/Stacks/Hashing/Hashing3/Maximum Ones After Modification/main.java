import java.util.*;

class Accio {
    public int longestOnes(int[] A, int B) 
	{
          //Your code goes here
		//this is the problem of Sliding window..
		int i=0;
		int j=0;
		int max=0;
		int countOfZ=0;
		while(j<A.length)
		{
			if(A[j]==0)countOfZ++;
			//let's contract the window
			while(i<j &&countOfZ>B)
			{
				if(A[i]==0)countOfZ--;
				i++;
			}
			//let's calculate the answer..
			max=Math.max(max,j-i+1);
			//let's introduce the new elment...
			j++;
		}
		return max;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
    	for(int i=0;i<N;i++)
	    A[i] = sc.nextInt();
        int B = sc.nextInt();
        Accio Obj = new Accio();
        System.out.println(Obj.longestOnes(A, B));
    }
}
