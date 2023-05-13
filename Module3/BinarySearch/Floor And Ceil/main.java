import java.util.*;

public class Main {
    public static int[] floorAndCeil(int key, int[] arr)
	{
        //Write code here
		int si=0;
		int ei=arr.length-1;
		int pceil=-1;
		int pfloor=-1;
		//we'll apply binary search... here we go..

		while(si<=ei)
		{
			int mid=(si+ei)>>1;
			if(arr[mid]==key)
			{
				//the value is present so florr and ciel it itsel.f
				return new int[]{key,key};
			}
			else if(arr[mid]>key)
			{
				//as we are moving towards the left... 
				pceil=arr[mid];
				ei=mid-1;
			}
			else {
				//it is smaller than the key.. 
				//means it may be the floor value..
				pfloor=arr[mid];
				si=mid+1;
			}
		}
		return new int[]{pfloor,pceil};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, key;
        n = sc.nextInt();
        key = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int[] result = floorAndCeil(key, arr);
        System.out.println(result[0] + " " + result[1]);
        sc.close();
    }
}
