import java.util.ArrayList;
public class Solution {
    public static int bookalloc(ArrayList<Integer> arr,int n,int persize){
        int cntstudent=1;
        int lastpages=0;
        for(int i=0;i<n;i++){
            if(lastpages+arr.get(i)<=persize){
                lastpages+=arr.get(i);
            }
            else{
                cntstudent++;
                lastpages=arr.get(i);
            }
        }
        return cntstudent;

    }
    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        // Write your code here.
        if(n<m) return -1;
        int low=0;
        int max=0;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=arr.get(i);
            max=Math.max(max,arr.get(i));
        }
        low=max;
        for(int i=low;i<=sum;i++){
            int cnt=bookalloc(arr,n,i);
            if(cnt==m) return i;
        }
        return max;
    }
}
