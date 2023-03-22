import java.util.*;

public class Main {
    public static int findIndex(int key, int[] arr) {
        int start=0;
        int end=nums.length-1;
        int pans=-1;
        while(start<=end)
        {
                //let's find mid first...
                int mid=(start+end)/2;
                if(nums[mid]==target)
                {
                    return mid;
                }
                else if(nums[mid]>target)
                {                  
                        //you'll have to eliminate .. right side... of the mid..
                        end=mid-1;
                }
                else
                {
                        start=mid+1;
                }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, key;
        n = sc.nextInt();
        key = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        System.out.println(findIndex(key, arr));
        sc.close();
    }
}
