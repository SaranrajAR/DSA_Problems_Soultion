class FindSumPairs {
    public int[] nums1;
    public int[] nums2;
    public HashMap<Integer,Integer> map;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1=nums1;
        this.nums2=nums2;
        map=new HashMap<>();
        for(int num:nums2){
            map.put(num,map.getOrDefault(num,0)+1);
        }
    }
    
    public void add(int index, int val) {
        int oldVal=nums2[index];
        int newVal=nums2[index]+val;
        nums2[index]=newVal;
        map.put(oldVal,map.get(oldVal)-1);
        map.put(newVal,map.getOrDefault(newVal,0)+1);
    }
    
    public int count(int tot) {
        int temp=0;
        int totalcount=0;
        for(int num:nums1){
            temp=tot-num;
            if(map.containsKey(temp)){
                int t=map.get(temp);
                totalcount+=t;
            }
        }
        return totalcount;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */
