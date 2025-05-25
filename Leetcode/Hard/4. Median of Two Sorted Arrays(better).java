class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int index1 = (n1 + n2) / 2;
        int index2 = index1 - 1;
        int element1 = 0;
        int element2 = 0;
        int count = 0;
        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            if (nums1[i] <= nums2[j]) {
                if (count == index2)
                    element2 = nums1[i];
                if (count == index1)
                    element1 = nums1[i];
                i++;
            } else if (nums2[j] < nums1[i]) {
                if (count == index2)
                    element2 = nums2[j];
                if (count == index1)
                    element1 = nums2[j];
                j++;
            }
            count++;
        }
        while (i < n1) {
            if (count == index2)
                element2 = nums1[i];
            if (count == index1)
                element1 = nums1[i];
            i++;
            count++;
        }
        while (j < n2) {
            if (count == index2)
                element2 = nums2[j];
            if (count == index1)
                element1 = nums2[j];
            j++;
            count++;
        }
        if((n1+n2)%2!=0) return (double) element1;
        double ans=element1+element2;
        return ans/2;

    }
}
