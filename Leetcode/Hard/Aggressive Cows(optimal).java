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
        int low=1;
        int high=max-min;
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(canweplacecows(stalls,k,mid)){
                ans=mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return ans;
    }
}
