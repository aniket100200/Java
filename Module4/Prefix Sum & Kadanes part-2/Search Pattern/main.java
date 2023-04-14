import java.util.*;

class Solution {
    public ArrayList<Integer> FindIndices(String a, String b) {
       ArrayList<Integer> ls=new ArrayList<>();
        //Write your code here
	int i=0;
		while(a.indexOf(b,i)!=-1)
		{
			int j=a.indexOf(b,i);
			ls.add(j+1);
			i=j+1;
		}
		if(ls.size()>0){
			return ls;
		}
		ls.add(-1);
		return ls;
	}
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
	    Solution Obj = new Solution();
        ArrayList<Integer> ans = Obj.FindIndices(a, b);
        for(int x : ans)
            System.out.print(x + " ");
    }
}
