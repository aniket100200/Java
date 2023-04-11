import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        
        int position[]=new int[n];
        for(int i=0;i<n;i++)
        position[i]=sc.nextInt();

        Solution obj=new Solution();
        int ans=obj.magneticForce(position,n,m);
        System.out.println(ans);
    }
}


class Solution {
    int magneticForce(int position[],int n,int m) 
	{  
		Arrays.sort(position);
		//total no buckests...
		//n///... 
		int si=1;
		//
		int ei=position[n-1]-position[0];
int pans=-1;
		while(si<=ei)
		{
			int mid=(si+ei)>>1;
			if(isPossible(position,mid,m))
			{
				pans=mid;
				si=mid+1;
			}
			else
			{
				ei=mid-1;
				
			}
		}
		return pans;
    }
boolean isPossible(int[] pos,int mid,int mag)
{
	int noOfMag=1;
	
	int last=pos[0];
	for(int i=1;i<pos.length;i++)
	{
		if(pos[i]-last>=mid)
		{
			noOfMag++;
			last=pos[i];			
		}
	}
	return noOfMag>=mag;
	
}
	
} //;
