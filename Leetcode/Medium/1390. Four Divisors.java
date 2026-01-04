class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum=0;
        for(int num:nums){
            int currSum=0;
            Set<Integer> set=new HashSet<>();
            for(int i=1;i*i<=num;i++){
                if(num%i==0){
                    set.add(i);
                    set.add(num/i);
                }
            }
            if(set.size()==4) for(int curr:set) sum+=curr;
        }
        return sum;
    }
}
