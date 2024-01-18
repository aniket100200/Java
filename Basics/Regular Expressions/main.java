import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        while(true)
        {
            String input = sc.nextLine();
            String[] arr = input.split(",");

            String pans = "";
            int total = 0;
            int i = 0;
            for (String s : arr)
            {
                String[] ans = s.split("\\s|\\;|\\-|\\:",0);
                if (ans.length == 3) {
                    //then you have the correct output..
                    try {
                        int price = Integer.parseInt(ans[1]);
                        int quantity = Integer.parseInt(ans[2]);
                        total += price * quantity;
                        if (i == arr.length - 1) {
                            pans += price * quantity + "=" + total;
                        } else pans += price * quantity + "+";
                    }
                    catch (NumberFormatException e)
                    {
                        //some code..
                    }

                }
                i++;
            }

            System.out.println(pans);
        }
    }
}


/*
* Input: [apples 5 1,oranges 6 1]

Output: 5+6=11

Input: [bread-1;1, milk - 2:1]

Output: 1+2=3

put: [butter M N,milk 1 1]
*
*
* */
