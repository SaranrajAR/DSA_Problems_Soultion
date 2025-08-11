// User function Template for Java

class Solution {
    static int binSearch(int N,int[] arr){
        int low=0;
        int high=9;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==N) return mid;
            else if(arr[mid]<N) low=mid+1;
            else high=mid-1;
        }
        return low-1;
    }
    static List<Integer> minPartition(int N) {
        // code here
        int[] arr=new int[]{1,2,5,10,20,50,100,200,500,2000};
        
        List<Integer> list=new ArrayList<>();
        
        while(N>0){
            int temp=0;
            int idx=binSearch(N,arr);
            
            temp=arr[idx];
            list.add(temp);
            N-=temp;
        }
        return list;
    }
}
