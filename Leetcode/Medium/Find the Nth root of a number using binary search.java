public class Solution {
    public static int checkfunc(int n,int m,int x){
        long ans=1;
        for(int i=0;i<n;i++){
            ans*=x;
            if(ans>m) return 2;
        }
        if(ans==m) return 1;
        return 0;

    }
    public static int NthRoot(int n, int m) {
        // Write your code here.
        int low=1;
        int high=m;
        while(low<=high){
            int mid=(low+high)/2;
            int midN=checkfunc(n,m,mid);
            if(midN==1) return mid;
            else if(midN==2) high=mid-1;
            else low=mid+1;

        }
        return -1;
    }
}
