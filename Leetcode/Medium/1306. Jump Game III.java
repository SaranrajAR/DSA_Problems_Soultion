class Solution {
    public boolean helper(int[] arr,int idx){
        if(arr[idx]==0) return true;
        if(arr[idx]==-1) return false;
       
        if(arr[idx]!=-1){
            int val=arr[idx];
            arr[idx]=-1;
            if((val+idx<arr.length) && helper(arr,val+idx)) return true;
            if(((idx-val>=0) && helper(arr,idx-val))) return true;  
        }
        
        return false;
    }
    public boolean canReach(int[] arr, int start) {
        return helper(arr,start);
    }
}
