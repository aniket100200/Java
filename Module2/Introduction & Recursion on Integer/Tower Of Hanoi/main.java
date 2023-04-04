import java.io.*;
import java.util.*;
class Main {
	static void toh(int N, int from, int to, int aux)
	{
        //Write code here
		//base case is that if you have single ring then put it directly to destination 

if(N==1)		
{
	System.out.println("move disk "+N+" from rod "+from+" to rod "+to);
	return;
}
		//first you'll have to mount all the n-1 disk on the aux
		toh(N-1,from,aux,to);

		// then move nth one directly to destination or to
		 System.out.println("move disk "+N+" from rod "+from+" to rod "+to);

		// then move the all the N-1 disks form then auxillay to the destination and henced solced

		toh(N-1,aux,to,from);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N;
        
        N = sc.nextInt();

        toh(N, 1, 3, 2);

        sc.close();
    }
}

