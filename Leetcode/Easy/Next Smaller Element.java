import java.util.*;
import java.io.*;

public class Solution{
    static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n){
        // Write your code here.
        Stack<Integer> stack=new Stack<>();
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek()>=arr.get(i)){
                stack.pop();
            }
            ans.add(!stack.isEmpty()?stack.peek():-1);
            stack.push(arr.get(i));
        }
        Collections.reverse(ans);
        return ans;
    }
}
