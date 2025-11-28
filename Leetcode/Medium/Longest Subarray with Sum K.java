// User function Template for Java

class Solution {
    public int longestSubarray(int[] arr, int k) {
        // code here
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=arr.length;
        map.put(0,0);
        int prefix=0;
        int maxLength=0;
        for(int i=0;i<n;i++){
            prefix+=arr[i];
            if(prefix==k) maxLength=Math.max(maxLength,i+1);
            else{
                int rem=prefix-k;
                if(map.containsKey(rem)){
                  maxLength=Math.max(maxLength,i-map.get(rem));
                } 
            }
            
            if(!map.containsKey(prefix)) map.put(prefix,i);
        }
        return maxLength;
        
    }
}
