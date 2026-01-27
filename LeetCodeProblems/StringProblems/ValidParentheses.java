package StringProblems;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String args[]){
        String s = "()[]{"; //o/p -true
        boolean result = checkifValid(s);
        System.out.println(result);

    }

    private static boolean checkifValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c :s.toCharArray()){
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            else if(stack.isEmpty() || (c== ')' && stack.pop() != '(')
              ||  (c== '}' && stack.pop() != '{') ||  (c== ']' && stack.pop() != '[')){
                return false;
            }

        }
        return stack.isEmpty();
    }
}
