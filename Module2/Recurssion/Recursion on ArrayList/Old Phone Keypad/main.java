import java.util.*;

class Main {
    static ArrayList <String> OldPhone(int n, int[] keys)
	{
		//Write your code here
		ArrayList<String> ans=new ArrayList<>();
		if(n==0)
			{ans.add("");			
			return ans;
		}
		String[] arr={"","ABC","DEF","GHI","JKL","MNO","PQRS","TU","VWX","YZ"};

		//else I have charachters to prcedd
		//first I'll try to get the index using keys;
		//here we go
		int index=keys[n-1];
		String inter_pr=arr[index];

		//now I have string interpritation here we go after that

		for(int i=0;i<inter_pr.length();i++)
		{
			ArrayList<String> spider=OldPhone(n-1,keys);//this is sowing that you have to take char from ansother website
			for(String s: spider)
			{
				ans.add(s+inter_pr.charAt(i));
			}
			
		}
		Collections.sort(ans);
			return ans;
    }
	
	public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] keys = new int[n];
        for(int i=0;i<n;++i){
            keys[i] = sc.nextInt();
        }
        ArrayList <String> ans=OldPhone(n,keys);
        for(String i:ans) System.out.print(i+" ");
    }
}
