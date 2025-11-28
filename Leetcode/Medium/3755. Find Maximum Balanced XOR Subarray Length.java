class Solution {
    public int maxBalancedSubarray(int[] nums) {
        Map<List<Integer>, Integer> map = new HashMap<>();
        int n = nums.length;
        int prefixOr = 0;
        int prefixDiff = 0;
        int maxLength = 0;
        List<Integer> base=Arrays.asList(0,0);
        map.put(base,-1);
        for (int i = 0; i < n; i++) {
            
            prefixOr ^= nums[i];
            if (nums[i] % 2 == 0)
                prefixDiff--;
            else
                prefixDiff++;
            List<Integer> temp=Arrays.asList(prefixOr,prefixDiff);

            
            if (map.containsKey(temp)) {
                maxLength = Math.max(maxLength, i - map.get(temp));
            }

            if (!map.containsKey(temp))
                map.put(temp, i);

        }
        return maxLength;
    }
}
