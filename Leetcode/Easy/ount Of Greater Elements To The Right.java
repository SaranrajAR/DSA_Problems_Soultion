public class Solution {
    public static int[] countGreater(int []arr, int []query) {
        // Write your code here.
        int n=query.length;
        int[] ans=new int[n];
        int len=arr.length;
        for(int i=0;i<n;i++){
            int index=query[i];
            int total=0;
            for(int j=len-1;j>index;j--){
                if(arr[j]>arr[index]) total++;
            }
            ans[i]=total;
        }
        return ans;
    }
}
