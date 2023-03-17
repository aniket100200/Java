import java.util.*;

class Solution {
	int[] arr;
	Solution()
	{
		arr=new int[1000001];
		Arrays.fill(arr,-1);
	}
    public void add(int key) 
	{
        //Complete the function
		arr[key]=key;
    }

    public void remove(int key)
	{
        //Complete the function
		arr[key]=-1;
    }

    public boolean contains(int key) {
        //Complete the function
		return arr[key]!=-1;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        Solution Obj = new Solution();
        for (int i = 0; i < q; i++) {
            int choice = sc.nextInt();
            int key = sc.nextInt();
            if (choice == 1) {
                // Add
                Obj.add(key);
            } else if (choice == 2) {
                // contains
                if (Obj.contains(key)) {
                    System.out.print("True ");
                } else {
                    System.out.print("False ");
                }
            } else if (choice == 3) {
                // remove
                Obj.remove(key);
            }
        }
        System.out.println();
        sc.close();
    }
}
