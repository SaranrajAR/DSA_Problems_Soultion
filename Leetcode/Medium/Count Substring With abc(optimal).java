
public class Solution {
    private static int min(int a,int b,int c){
        int min=Math.min(a,b);
        return Math.min(min,c);

    }
    public static int countSubstring(String s){
        // Write your code here.
        int[] lastseen={-1,-1,-1};
        int count=0;
        for(int i=0;i<s.length();i++){
            lastseen[s.charAt(i)-'a']=i;
            if(lastseen[0]!=-1 && lastseen[1]!=-1 && lastseen[2]!=-1){
                count+=1+min(lastseen[0],lastseen[1],lastseen[2]);
            }
        }
        return count;
    }
}
