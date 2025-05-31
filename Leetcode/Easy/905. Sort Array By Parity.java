class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n=nums.length;
        int[] arr=new int[n];
        int i=0;
        int j=n-1;
        for(int num:nums){
            if(num%2==0){
                arr[i]=num;
                i++;
            }
            else{
                arr[j]=num;
                j--;
            }
        }
        return arr;
        
    }
}
