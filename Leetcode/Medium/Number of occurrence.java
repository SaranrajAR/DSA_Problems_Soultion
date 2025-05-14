public class Solution {
    private static int lb(int[] arr,int x,int n){
        int low=0;
        int high=n-1;
        int ans=n;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]>=x){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    private static int ub(int[] arr,int x,int n){
        int low=0;
        int high=n-1;
        int ans=n;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]>x){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;

    }
    public static int count(int arr[], int n, int x) {
        //Your code goes here
        
        int count=0;
        int left=lb(arr,x,n);
        if(left==n || arr[left]!=x) return 0;
        int right=ub(arr,x,n);
        return right-left;
        

    }
}
