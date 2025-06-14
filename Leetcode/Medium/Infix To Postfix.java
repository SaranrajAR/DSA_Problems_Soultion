import java.util.*;

public class Solution {
    private static int priority(char s){
        if(s=='^') return 3;
        else if(s =='*' || s=='/' ) return 2;
        else if(s=='+' || s=='-') return 1;
        else return -1;
    }

    private static boolean isRightAssociative(char ch){
        return ch == '^';
    }

    public static String infixToPostfix(String exp) {
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();
        int i = 0;
        
        while(i < exp.length()){
            char ch = exp.charAt(i);
            
            if(Character.isLetterOrDigit(ch)){
                ans.append(ch);
            }
            else if(ch == '('){
                st.push(ch);
            }
            else if(ch == ')'){
                while(!st.isEmpty() && st.peek() != '('){
                    ans.append(st.pop());
                }
                st.pop(); // pop '('
            }
            else { // operator
                while(!st.isEmpty() && (
                    priority(ch) < priority(st.peek()) ||
                    (priority(ch) == priority(st.peek()) && !isRightAssociative(ch))
                )){
                    ans.append(st.pop());
                }
                st.push(ch);
            }
            i++;
        }

        while(!st.isEmpty()){
            ans.append(st.pop());
        }

        return ans.toString();
    }
}
