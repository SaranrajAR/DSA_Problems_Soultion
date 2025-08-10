class Solution {
    public void reverse(int[] arr){
        int l=0;
        int r=arr.length-1;
        while(l<r){
            int temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;
            l++;
            r--;
        }
    }
    public ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {
        // code here
        PriorityQueue<int[]> maxHeap=new PriorityQueue<>((A,B)->B[0]-A[0]);
        Set<String> visited=new HashSet<>();
        Arrays.sort(a);
        Arrays.sort(b);
        reverse(a);
        reverse(b);
        int n=a.length;
        
        ArrayList<Integer> res=new ArrayList<>();
        
        maxHeap.offer(new int[]{(a[0]+b[0]),0,0});
        visited.add("0_0");
        while(k-->0){
            int[] top=maxHeap.poll();
            res.add(top[0]); //addin the sum value into res;
            int i=top[1];
            int j=top[2];
            
            if(i+1<n && !visited.contains((i+1)+"_"+j)){
                maxHeap.offer(new int[]{(a[i+1]+b[j]),i+1,j});
                visited.add((i+1) + "_"+j);
            }
            if(j+1<n && !visited.contains(i+"_"+(j+1))){
                maxHeap.offer(new int[]{(a[i]+b[j+1]),i,j+1});
                visited.add(i+"_"+(j+1));
            }
        }
        return res;
        
    }
}
