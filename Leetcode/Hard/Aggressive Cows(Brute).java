import java.util.*;
public class Solution {
    public static boolean canweplacecows(int []stalls,int cows,int distance){
        int cntcows=1;
        int lastpos=stalls[0];
        for(int i=1;i<stalls.length;i++){
            if((stalls[i]-lastpos)>=distance){
                lastpos=stalls[i];
                cntcows++;
            }
        }
        if(cntcows>=cows) return true;
        return false;
        
    }
    public static int aggressiveCows(int []stalls, int k) {
        //    Write your code here.
        Arrays.sort(stalls);
        int min=stalls[0];
        int max=stalls[stalls.length-1];
        for(int i=1;i<=max-min;i++){
            if(canweplacecows(stalls,k,i)){
                continue;

            }
            else{
                return i-1;
            }
        }
        return max-min;
    }
}
