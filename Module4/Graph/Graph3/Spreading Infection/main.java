import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }

      int src = Integer.parseInt(br.readLine());
      int t = Integer.parseInt(br.readLine());
      
      // write your code here
		Queue<Integer> que=new LinkedList<>();
	   Set<Integer> infected=new HashSet<>();
	   int count=1;
	   que.add(src);
	   infected.add(src);
	   while(t-->1)
	   {
		   int size=que.size();
		   if(size==0)break;
		   while(size-->0)
		   {
			   int nsrc=que.remove();
			   for(Edge e: graph[nsrc])
			   {
				   if(!infected.contains(e.nbr))
				   {
					   //mark...
					   infected.add(e.nbr);
					   count++;
					   que.add(e.nbr);
				   }
			   }
		   }
	   }
	   System.out.print(count);
   }

}
