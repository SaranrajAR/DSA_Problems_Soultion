class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map=new HashMap<>();
        Set<Integer> set=new HashSet<>();
        for(int num:nums1){
            map.put(num,1);
        }
        for(int num:nums2){
            if(map.containsKey(num)) set.add(num);
        }
        int n=set.size();
        int[] arr=new int[n];
        int i=0;
        for(int num:set){
            arr[i]=num;
            i++;
        }
        return arr;

        
    }
}
