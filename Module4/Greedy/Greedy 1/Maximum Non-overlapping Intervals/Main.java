import java.util.*;

class Solution {
    public static int solve(List<List<Integer>> A)
	{
    // Write your code here
		//sort on the basis of Starting point...
		Collections.sort(A,(a,b)->{return a.get(0)-b.get(0);});
		//sorting done successfully...
		
		int prsp=-1;
		int prep=-1;
		int count=0;
		for(List<Integer> interval: A)
		{
			int csp=interval.get(0);
			int cep=interval.get(1);

			if(csp<=prep)
			{
				// condition of overlapping
				//so we have to consider which one is best...
				if(cep<prep)
				{
					prsp=csp;
					prep=cep;
				}
				
			}
			else
			{
				count++;
				prsp=csp;
				prep=cep;
			}
		}
		return count;
	}
}
public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<List<Integer>> A = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            List<Integer> interval = Arrays.asList(a, b);
            A.add(interval);
        }
        int ans = Solution.solve(A);
        System.out.println(ans);
    }
}
