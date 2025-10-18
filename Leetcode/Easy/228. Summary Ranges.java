class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int n = nums.length;
        if (n == 0)
            return ans;
        int i = 1;
        int start = nums[0];
        int end = nums[0];
        while (i < n) {
            if (nums[i] == end + 1) {
                end++;
            } else {
                if (start == end)
                    ans.add(Integer.toString(start));
                else {
                    StringBuilder sb=new StringBuilder();
                    sb.append(Integer.toString(start));
                    sb.append("->");
                    sb.append(Integer.toString(end));
                    ans.add(sb.toString());
                }
                start = nums[i];
                end = nums[i];
            }
            i++;


        }
        if (start == end)
            ans.add(Integer.toString(start));
        else {
            String s = Integer.toString(start) + "->" + Integer.toString(end);
            ans.add(s);
        }
        return ans;
    }
}
