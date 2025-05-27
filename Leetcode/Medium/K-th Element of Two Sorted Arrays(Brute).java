import java.util.ArrayList;
public class Solution {
    public static int kthElement(ArrayList<Integer> arr1, ArrayList<Integer> arr2, int n, int m, int k) {
        // Write your coder here
        int count=0;
        int i=0,j=0;
        int temp=0;
        while(i<n && j<m){
            k--;
            if(arr1.get(i)<=arr2.get(j)){
                temp=arr1.get(i);
                i++;
            }
            else{
                temp=arr2.get(j);
                j++;
            }
            if(k==0) return temp;
            
        }
        while(i<n){
            k--;
            temp=arr1.get(i);
            i++;
            if(k==0) return temp;
        }
        while(j<n){
            k--;
            temp=arr2.get(j);
            j++;
            if(k==0) return temp;
        }
        return -1;
    }
}
