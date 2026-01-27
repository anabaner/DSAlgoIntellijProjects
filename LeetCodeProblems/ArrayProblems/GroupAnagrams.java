import java.util.*;

public class GroupAnagrams {

    /*
    Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]

Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Explanation:

There is no string in strs that can be rearranged to form "bat".
The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
     */

    public static void main(String args[]) {
        String strs[] = {"eat","tea","tan","ate","nat","bat"};
         List<List<String>> result = groupAnagrams(strs);
        System.out.print(result);

    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, Integer> mp = new HashMap<>();

        List<String> list = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            // Find the key by sorting the string
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            s = new String(chars);


            if (!mp.containsKey(s)) {
                mp.put(s, res.size());
                res.add(new ArrayList<>());
            }

            // Insert the string in its correct group
            res.get(mp.get(s)).add(strs[i]);
        }
        return res;
    }
}
