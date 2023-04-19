
// A Java program to print all anagrams together
import java.util.*;

public class Main 
{
    // Given a list of words in wordArr[],
    static void printAnagramsTogether(String wordArr[],int size)
	{
		// Arrays.sort(wordArr);
       HashMap<HashMap<Character,Integer>,ArrayList<String>> map=new HashMap<>();
		for(String word: wordArr)
		{
			//let's create the HashMap each word...
			// System.out.println(word);
			HashMap<Character,Integer> tm=new HashMap<>();
			for(int i=0;i<word.length();i++)
			{
				char ch=word.charAt(i);
				tm.put(ch,tm.getOrDefault(ch,0)+1);
			}
			if(map.containsKey(tm))
			{
				map.get(tm).add(word);
			}
			else
			{
				ArrayList<String> al=new ArrayList<>();
				al.add(word);
				map.put(tm,al);
			}
		}
		// for(HashMap<Character,Integer> hm: map.keySet())
		// {		
		// 		Collections.sort(map.get(hm));
		// }
		for(HashMap<Character,Integer> hm: map.keySet())
		{		
				for(String so:map.get(hm))
				{
					System.out.print(so+" ");
				}
		}
		
    }

    // Driver program to test above functions
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] wordArr = new String[n];
        for (int i = 0; i < n; i++)
            wordArr[i] = sc.next();
        sc.close();
        printAnagramsTogether(wordArr, n);
    }
}
