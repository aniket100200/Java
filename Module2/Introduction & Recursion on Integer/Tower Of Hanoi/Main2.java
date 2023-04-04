import java.io.*;
import java.util.*;
class Main {
	static void toh(int N, int from, int to, int aux)
	{
        //Write code here
		//first you'll have to move n-1 disks from ___aux..
		if(N==0)return;
		toh(N-1,from,aux,to);
		//you have to last ring to directyly to the ...to..
		System.out.println("move disk "+N+" from rod "+from+" to rod "+to);
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

