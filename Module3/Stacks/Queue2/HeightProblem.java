class Accio
{
    static int[] HeightProblem(int n,int[] arr)
	{
        //write code here
		//Use of Monontonic stack... let's find then next smallerset element to the left of the 
		//prsesent one..
		Stack<Integer> st=new Stack<>();
		int[] ans=new int[n];
		for(int i=n-1;i>=0;i--)
		{
			int ele=arr[i];
			while(st.size()>0 && ele<arr[st.peek()])
			{
				int index=st.pop();
				ans[index]=arr[i];
			}
			st.push(i);
		}
		

		//still in the stack.. i"ve the elements present measn they don't have left smallest..

		//left limit will be -1;
		while(st.size()>0)
		{
			int index=st.pop();
				ans[index]=-1;
		}
		return ans;
    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;++i){
            arr[i] = sc.nextInt();
        }
        Accio obj = new Accio();
        int[] ans=obj.HeightProblem(n,arr);
        for(int i=0;i<n;++i){
            System.out.print(ans[i] + " ");
        }
    }
}
