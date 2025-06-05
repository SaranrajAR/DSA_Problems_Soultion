class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map=new HashMap<>();
        int i=0;
        int j=1;
        while(i<nums2.length){
            j=i;
            while(j<nums2.length && nums2[j]<=nums2[i]){
                j++;
            }
            if(j<nums2.length && nums2[j]>nums2[i]) map.put(nums2[i],nums2[j]);
            else map.put(nums2[i],-1);
            i++;
        }
        for(i=0;i<nums1.length;i++){
            nums1[i]=map.get(nums1[i]);
        }
        return nums1;

        
    }
}
