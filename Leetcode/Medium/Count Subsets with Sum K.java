import java.util.*;
import java.io.*;

public class Solution {
    public static int helper(int[] num,int i,int sum,int k){
        if(i==num.length){
            if(sum==k){
                return 1;
                
            }
            return 0;
        }

        int ans=helper(num,i+1,sum,k);

        sum+=num[i];
        ans+=helper(num,i+1,sum,k);
        

        return ans;

        

        
        
    }
    public static int findWays(int num[], int tar) {
        // Write your code here.
        return helper(num,0,0,tar);
    }
}
