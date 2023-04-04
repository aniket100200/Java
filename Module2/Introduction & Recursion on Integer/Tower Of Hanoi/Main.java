import java.util.Scanner;
/*** antoher problem related to TOH ****/
public class Main {

    static void towersOfHanoi(int n, char source, char dest)
	{
		if(n==1)
		{
			System.out.println("Moving ring " +n+ " from "+ source+ " to " +dest);
		return;
		}
		char ch;
		// let's create helper wich is ch
      if((source=='A' && dest=='B') || (source=='B' && dest=='A'))
	  {
		  ch='C';
	  }
	else if((source=='A' && dest=='C') || (source=='C' && dest=='A'))
	{
		ch='B';
	}
		else
	{
			ch='A';
		}
		towersOfHanoi(n-1,source,ch);
			System.out.println("Moving ring " +n+ " from "+ source+ " to " +dest);
		towersOfHanoi(n-1,ch,dest);
		
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        towersOfHanoi(n, 'A', 'B'); // move n disks from A to B
    }
}
