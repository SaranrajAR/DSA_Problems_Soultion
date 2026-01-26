class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minDiff=(int) 1e9;
        for(int i=0;i<arr.length-1;i++){
            minDiff=Math.min(minDiff,Math.abs(arr[i]-arr[i+1]));
        }
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<arr.length-1;i++){
            if(Math.abs(arr[i]-arr[i+1])==minDiff){
                List<Integer> curr=new ArrayList<>(Arrays.asList(arr[i],arr[i+1]));
                res.add(curr);
            }
        }
        return res;
    }
}
