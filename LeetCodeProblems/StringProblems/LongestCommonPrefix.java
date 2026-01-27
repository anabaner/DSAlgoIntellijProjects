package StringProblems;

import java.util.Arrays;

public class LongestCommonPrefix {


    public static void main(String args[]){

        String strs[] = {"flower","flow","flight"};
        String result = getLongestPrefix(strs);
        System.out.println(result);
    }

    private static String getLongestPrefix(String[] strs) {

        Arrays.sort(strs);
        String s1 = strs[0];
        String s2 = strs[strs.length-1];
        int idx =0;
        while (idx<s1.length() && idx <s2.length()) {
            if(s1.charAt(idx) == s2.charAt(idx))
                idx++;
            else
                break;
        }
        return s1.substring(0,idx);
    }
}


//Approach

/*
Sort the elements of an array of strings called "strs" in lexicographic (alphabetical)
order using the Arrays.sort(strs) method.
Assign the first element of the sorted array (the lexicographically smallest string) to a string variable s1.
Assign the last element of the sorted array (the lexicographically largest string) to a string variable s2.
Initialize an integer variable idx to 0.
Start a while loop that continues while idx is less than the length of s1 and s2.
Within the while loop, check if the character at the current index in s1 is equal to the character at the same index in s2. If the characters are equal, increment the value of idx by 1.
If the characters are not equal, exit the while loop.
Return the substring of s1 that starts from the first character and ends at the idxth character (exclusive).
 */