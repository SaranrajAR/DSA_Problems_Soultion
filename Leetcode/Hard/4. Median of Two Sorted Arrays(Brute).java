class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] arr = new int[n1 + n2];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < n1 && j < n2) {
            if (nums1[i] <= nums2[j]) {
                arr[k] = nums1[i];
                i++;
                k++;
            }
            else if(nums2[j]<nums1[i]){
                arr[k]=nums2[j];
                j++;
                k++;
            }

        }
        while(i<n1){
            arr[k]=nums1[i];
            i++;
            k++;
        }
        while(j<n2){
            arr[k]=nums2[j];
            j++;
            k++;
        }
        double ans=0;
        if((n1+n2)%2!=0) return arr[(n1+n2)/2];
        int index=(n1+n2)/2;
        ans+=arr[index];
        ans+=arr[index-1];
        ans/=2;
        return ans;

    }
}
