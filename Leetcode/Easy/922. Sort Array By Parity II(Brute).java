class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int n=nums.length;
        int[] arr=new int[n];
        int i=0;
        int j=1;
        for(int num:nums ){
            if(num%2==0){
                arr[i]=num;
                i+=2;
            }
            else{
                arr[j]=num;
                j+=2;
            }
        }
        return arr;

        
    }
}
