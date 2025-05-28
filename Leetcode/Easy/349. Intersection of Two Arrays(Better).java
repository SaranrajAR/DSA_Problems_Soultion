class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] hash=new int[1001];
        for(int n:nums1){
            hash[n]=1;
        }
        int index=0;
        for(int n:nums2){
            if(hash[n]==1){
                nums2[index]=n;
                hash[n]=0;
                index++;
            }
        }
        return Arrays.copyOfRange(nums2,0,index);
    }
}
