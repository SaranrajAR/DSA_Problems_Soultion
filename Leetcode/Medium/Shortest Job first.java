// User function Template for Java

class Solution {
    static int solve(int bt[]) {
        // code here
        Arrays.sort(bt);
        int n=bt.length;
        int wt=0;
        int timer=0;
        
        for(int i=0;i<n-1;i++){
            timer+=bt[i];
            wt+=timer;
            
        }
        return wt/n;
    }
}
