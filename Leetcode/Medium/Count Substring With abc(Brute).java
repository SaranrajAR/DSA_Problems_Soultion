public class Solution {
    public static int countSubstring(String s){
        // Write your code here.
        int count=0;
        for(int i=0;i<s.length();i++){
            StringBuilder sb=new StringBuilder();
            for(int j=i;j<s.length();j++){
                sb.append(s.charAt(j));
                if(sb.indexOf("a")!=-1 && sb.indexOf("b")!=-1 && sb.indexOf("c")!=-1) count++;
            }
        }
        return count;
    }
}
