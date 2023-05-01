import java.util.*;

class Solution {
    public List<Integer> findSubstring(String str, String[] words)
	{
        // write code here	
		List<Integer> ans=new ArrayList<>();
		if(str==null || str.length()==0 || words==null || words.length==0)return ans;

		HashMap<String,Integer> dic=new HashMap<>();
		//I'll store the frquecy of each word...
		for(String word: words)
		{
			dic.put(word,dic.getOrDefault(word,0)+1);
		}
		int len=words[0].length(); //we are assuming the length of each word is same...

		for(int i=0;i<=str.length()-len*words.length ;i++)
		{
			Map<String,Integer> seenWords=new HashMap<>();
			int j=0;
			while(j<words.length)
			{
				int wordStart=i+j*len;
				String word=str.substring(wordStart,wordStart+len);
				if(!dic.containsKey(word))
				{
					break;
				}

				seenWords.put(word,seenWords.getOrDefault(word,0)+1);

				if(seenWords.get(word)>dic.get(word))
				{
					break;
				}
				j++;
			}
			if(j==words.length)ans.add(i);
		}
		return ans;
		
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int n = scn.nextInt();
        String[] words = new String[n];
        for(int i=0;i<n;i++){
            words[i] = scn.next();
        }
        Solution Obj =  new Solution();
        List<Integer> indexes = Obj.findSubstring(str,words);
        Collections.sort(indexes);
        for(int i=0;i<indexes.size();i++){
            System.out.print(indexes.get(i) + " ");
        }
        System.out.println();
    }
}
// import java.util.*;

// public class ConcatenatedSubstring {
//     public List<Integer> findSubstring(String str, String[] words) {
//         List<Integer> result = new ArrayList<>();
//         if (str == null || str.length() == 0 || words == null || words.length == 0) {
//             return result;
//         }
//         int wordLen = words[0].length();
//         int totalLen = wordLen * words.length;
//         if (str.length() < totalLen) {
//             return result;
//         }
//         Map<String, Integer> map = new HashMap<>();
//         for (String word : words) {
//             map.put(word, map.getOrDefault(word, 0) + 1);
//         }
//         for (int i = 0; i <= str.length() - totalLen; i++) {
//             Map<String, Integer> copy = new HashMap<>(map);
//             for (int j = i; j < i + totalLen; j += wordLen) {
//                 String sub = str.substring(j, j + wordLen);
//                 if (copy.containsKey(sub)) {
//                     int count = copy.get(sub);
//                     if (count == 1) {
//                         copy.remove(sub);
//                     } else {
//                         copy.put(sub, count - 1);
//                     }
//                 } else {
//                     break;
//                 }
//             }
//             if (copy.isEmpty()) {
//                 result.add(i);
//             }
//         }
//         return result;
//     }
// }
