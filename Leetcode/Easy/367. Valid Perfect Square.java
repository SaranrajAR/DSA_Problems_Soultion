class Solution {
    public boolean isPerfectSquare(int num) {
        if(num==1) return true;
        long low=1;
        long high=num/2;
        while(low<=high){
            long mid=(low+high)/2;
            long curr=mid*mid;
            if(curr==num) return true;
            else if(curr<num) low=mid+1;
            else high=mid-1;
        }
        return false;
    }
}
