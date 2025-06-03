class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for(int i=0;i<image.length;i++){
            int[] arr=image[i];
            int l=0;
            int r=arr.length-1;
            while(l<=r){
                int left=arr[l] ^ 1;
                int right=arr[r] ^ 1;
                arr[l]=right;
                arr[r]=left;
                l++;
                r--;
            }
        }
        
        return image;
        
    }
}
