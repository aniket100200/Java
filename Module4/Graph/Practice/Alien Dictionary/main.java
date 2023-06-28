import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = sc.next();
        }
        Solution s = new Solution();
        String order = s.findOrder(words);
        if(order.equals("-1")){
            System.out.println(-1);
        }
        else if(order.length() == 0){
            System.out.print(0);
        }else{
        String[] temp = new String[n];
         for(int i = 0 ; i < n ; ++i){
             temp[i] = words[i];
         }
         Arrays.sort(temp, new Comparator<String>(){
             @Override
             public int compare(String a , String b){
                 int index1 = 0 ; 
                 int index2 = 0 ; 
                 for(int i = 0 ; i < Math.min(a.length(),b.length()) && index1==index2;i++){
                     index1 = order.indexOf(a.charAt(i));
                     index2 = order.indexOf(b.charAt(i));

                 }
                 if(index2 == index1 && a.length()!=b.length()){
                     if(a.length() < b.length()){
                         return -1 ; 
                     }else{
                         return 1 ; 
                     }

                 }
                 if(index1 < index2){
                     return -1 ; 
                 }else{
                     return 1 ; 
                 }
             }
         });
         int flag = 1 ; 
         for(int i = 0 ; i < n ; ++i){
             if(!words[i].equals(temp[i])){
                 flag = 0 ; 
                 break  ;
             }
         }
         System.out.print(flag);

        }

    }
}
class Pair
{
	char a,b;
	Pair(char a,char b)
	{
		this.a=a;
		this.b=b;
	}
	Pair()
	{
		
	}
}
class Solution
{
	public static Pair find(String s1,String s2)
	{
		int n=Math.min(s1.length(),s2.length());
		for(int i=0;i<n;i++)
		{
			char a=s1.charAt(i);
			char b=s2.charAt(i);
			if(a!=b)return new Pair(a,b);
		}
		return new Pair();
	}
    public static String findOrder(String [] words)
	{
        //Write your code here 
		int n=words.length;
		if(n>26)n=26;
		ArrayList<Integer>[]adj=new ArrayList[n];
		for(int i=0;i<n;i++)adj[i]=new ArrayList<>();

		//To solve this perticular problem we need to implments the graph..
		int[]indegree=new int[n];
		for(int i=0;i<n-1;i++)
		{
			//find function will return pair 
			//it means you'll have to do a work before b..
			//a will come first a-->b
			Pair p=find(words[i],words[i+1]);
			int a=p.a-'a';
			int b=p.b-'a';
			if(a==b)return "0";
			adj[a].add(b);
		indegree[b]++;
		}

		//just apply the Topological sort on 
		String ans=topo(adj,n,indegree);
		return ans.length()==n?ans:"0";
		
    }
	public static String topo(ArrayList<Integer>[]adj,int n,int in[])
	{
		StringBuilder sb=new StringBuilder();
		Queue<Integer> que=new ArrayDeque<>();
		for(int i=0;i<n;i++)if(in[i]==0)que.add(i);
		while(que.size()>0)
		{
			int curr=que.remove();
			sb.append((char)(curr+'a'));
			for(int nbr:adj[curr])
			{
				in[nbr]--;
				if(in[nbr]==0)que.add(nbr);
			}
			
		}
		
		return sb.toString();
		
	}
}
