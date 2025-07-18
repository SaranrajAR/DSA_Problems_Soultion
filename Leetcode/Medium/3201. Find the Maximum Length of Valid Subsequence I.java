class Solution {
    public int maximumLength(int[] nums) {
        int max=0;
        int evenMax=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]%2==0) evenMax++;
        }
        int oddMax=0;
        max=Math.max(evenMax,max);
        for(int i=0;i<n;i++){
            if(nums[i]%2==1) oddMax++;
        }
        max=Math.max(max,oddMax);
        int evenOddMax=0;
        boolean forEven=true;
        boolean forOdd=false;
        for(int num:nums){
            if(forEven){
                if(num%2==0){
                    forEven=false;
                    forOdd=true;
                    evenOddMax++;
                }
            }
            else{
                if(num%2==1){
                    forEven=true;
                    forOdd=false;
                    evenOddMax++;
                }
            }
        }
        max=Math.max(max,evenOddMax);

        int oddEvenMax=0;
        forEven=false;
        forOdd=true;

        for(int num:nums){
            if(forOdd){
                if(num%2==1){
                    forEven=true;
                    forOdd=false;
                    oddEvenMax++;
                }
            }
            else{
                if(num%2==0){
                    forEven=false;
                    forOdd=true;
                    oddEvenMax++;
                }
            }
        }
        max=Math.max(max,oddEvenMax);
        return max;

    }
}
