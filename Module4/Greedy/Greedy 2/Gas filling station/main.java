import java.util.*;

class Solution {
    
    public int filling(int gas[],int cost[],int n)
	{
        //Write your code here
		int gasa=0;
		int costa=0;
		for(int i=0;i<n;i++)
		{
			gasa+=gas[i];
			costa+=cost[i];
		}
		if(gasa<costa)return -1;
		//here means ans does exists..

		int sp=-1;
		int tank=0;
		for(int i=0;i<n;i++)
		{
			int diff=gas[i]-cost[i];
			tank+=diff;
			if(tank<0){
				//reset the point..
				sp=-1;
				tank=0;
			}
			else {
				if(sp==-1)sp=i;
			}
			
		}
		return sp;
	
    }
}


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        sc.close();
        Solution Obj = new Solution();
        System.out.print(Obj.filling(a,b,n));
    }
}
