import java.io.*;
import java.util.*; 

class Main{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M[][] = new int[N][N];
        for(int i=0; i<N; i++)
            for(int j=0; j<N; j++)
                M[i][j] = sc.nextInt();
        System.out.println(new Solution().findCelebrity(M,N));
    } 
} 
class Solution
{ 
    int findCelebrity(int M[][], int n)
    {
	       //I wnat to dfind the celbrity... 
		//first I'll push all element's..

		Stack<Integer> st=new Stack<>();
		for(int i=0;i<n;i++)
		{
			st.push(i);
		}

		//Eliminate the people..
		while(st.size()>1)
		{
			//I'll put out two elements' or persons...
			int p1=st.pop();
			int p2=st.pop();
			if(M[p1][p2]==1)
			{
				//this means... p1 knows p2.. so p1 is not celbrity..
				st.push(p2);
			}
			else
			{
				//as p1 don't know p2 measn p2 is not celebrity..
				st.push(p1);
			}
		}

	//elimination khatam... tata bye.. bye

		//I've single element in the stack...

		int pCel=st.pop();

		//I'll check I'll be celebrity... if and only i don't know anyone..
		for(int j=0;j<n;j++)
		{
			if(M[pCel][j]==1)
			{
				return -1;
			}
				
		}

		//I'll check for everyone should know me...
		//row me travel krna pdega...
		for(int i=0;i<n;i++)
		{
			if(i!=pCel){
				if(M[i][pCel]==0)
			{
				return -1;
			}
					}
		}
		return pCel;
    }

}
