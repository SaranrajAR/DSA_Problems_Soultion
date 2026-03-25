class Solution {
    public int minCost(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map1=new HashMap<>();
        HashMap<Integer,Integer> map2=new HashMap<>();
        HashMap<Integer,Integer> map3=new HashMap<>();
        int n=nums1.length;
        for(int i=0;i<n;i++){
            map1.put(nums1[i],map1.getOrDefault(nums1[i],0)+1);
            map2.put(nums2[i],map2.getOrDefault(nums2[i],0)+1);
            map3.put(nums1[i],map3.getOrDefault(nums1[i],0)+1);
            map3.put(nums2[i],map3.getOrDefault(nums2[i],0)+1);
        }
        int res=0;
        for(int key:map3.keySet()){
            int freq=map3.get(key);
            if(freq%2!=0) return -1;
            if(map1.get(key)==map2.get(key)) continue;
            else{
                int val=Math.abs((freq/2)-map1.getOrDefault(key,0));
                res+=val;
            }
        }
        return res/2;
        

    }
}
