//Tc: nLogn... here we go..
import java.util.*;
import java.lang.*;
import java.io.*;
class Main
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine().trim();
        int N = S.length();
        Solution ob = new Solution();
        String[] element = br.readLine().trim().split("\\s+");
        int[] f = new int[N];
        for(int i = 0; i < N; i++){
            f[i] = Integer.parseInt(element[i]);
        }
        ArrayList<String> res  = ob.huffmanCodes(S,f,N);
        for(int i = 0; i < res.size(); i++)
        {
            System.out.print(res.get(i)+" ");
        }
        System.out.println();
    
	}
}

class Solution 
{
	class Node
	{
		char data;
		int fre;
		Node left;
		Node right;
		public Node(char data,int fre)
		{
			this.data=data;
			this.fre=fre;
			this.left=null;
			this.right=null;
		}
		public String toString(){
			return data+"";
		}
	}
    public ArrayList<String> huffmanCodes(String S, int f[], int N)
    {
        // Code here
        PriorityQueue<Node> que=new PriorityQueue<>((a,b)->
		{
			return a.fre<b.fre ?-1 :1;
		});
		for(int i=0;i<N;i++)
		{
			que.add(new Node(S.charAt(i),f[i]));
		}

		//Now lets make the Hufmann's Tree...
		while(que.size()>1)
		{
			Node n1=que.remove();
			Node n2=que.remove();

			Node me=new Node('*',n1.fre+n2.fre);
			me.left=n1;
			me.right=n2;
			que.add(me);
		}
//System.out.println(que);
		//Huffmans's tree is created...
		Node root=que.peek();

		//just iterate and give the answer....
		//pre order.. all
		ArrayList<String> al=new ArrayList<>();
		dfs(root,al,"");
		return al;
    }
	static void dfs(Node root,ArrayList<String> al,String psf){
		if(root.left==null && root.right==null)
		{
			al.add(psf);
			return ;
		}
		dfs(root.left,al,psf+"0");
		dfs(root.right,al,psf+"1");
	}
    
}
