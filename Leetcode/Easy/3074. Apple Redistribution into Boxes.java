class Solution {
    public void reverse(int[] capacity){
        int l=0;
        int r=capacity.length-1;
        while(l<r){
            int temp=capacity[l];
            capacity[l]=capacity[r];
            capacity[r]=temp;
            l++;
            r--;
        }
        
    }
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        reverse(capacity);
        int total=0;
        for(int a:apple) total+=a;
        int count=0;
        for(int i=0;i<capacity.length;i++){
            total-=capacity[i];
            count++;
            if(total<=0) return count;
            
        }
        return -1;
    }
}
