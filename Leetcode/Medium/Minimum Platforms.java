// User function Template for Java

class Solution {
    // Function to find the minimum number of platforms required at the
    // railway station such that no train waits.
    static int findPlatform(int arr[], int dep[]) {
        // add your code here
        Arrays.sort(dep);
        Arrays.sort(arr);
        int i=0;
        int j=0;
        int maxCount=0;
        int count=0;
        while(i<arr.length){
            if(arr[i]<=dep[j]){
                count++;
                i++;
            }
            else {
                count--;
                j++;
            }
            maxCount=Math.max(count,maxCount);
        }
        return maxCount;
    }
}
