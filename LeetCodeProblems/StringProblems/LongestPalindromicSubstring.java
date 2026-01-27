package StringProblems;

public class LongestPalindromicSubstring {

    /*
    Input: s = "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
Example 2:

Input: s = "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

     */
    static int count = 0;
    public static void main(String args[]){
        String s = "aaa"; //o/p - [1,2,_]
        int result = getPalindromicSubstring(s);
        System.out.println(result);

    }

    private static int getPalindromicSubstring(String s) {
        if(s.isEmpty())
            return 0;

        for(int i=0;i<s.length();i++){
            help(s,i,i);
            help(s,i,i+1);
        }
        return count;

    }

    private static void help(String s, int left, int right) {

        while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){

            count++;
            left--;
            right++;


        }

    }

}

/*
Approach -

DP -Break into Even and Odd

Handling Empty String:

Checks if the string length is 0, returns 0 if true.
Loop through Characters:

For each character in the string, treat it as a potential center for palindromes.
Helper Function - "help":

Takes two parameters (i, i) for odd-length palindromes and (i, i+1) for even-length palindromes.
Uses two pointers (left and right) starting from the center and moving outwards.
Increments count for each valid palindrome found.
Odd-Length Palindromes:

Calls "help" with parameters (i, i) for odd-length palindromes.
Even-Length Palindromes:

Calls "help" with parameters (i, i+1) for even-length palindromes.
 */
