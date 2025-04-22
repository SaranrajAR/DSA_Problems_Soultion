class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int curr=0,min=0,max=0;

        for(int i=0;i<differences.length;i++){
            curr+=differences[i];
            min=Math.min(curr,min);
            max=Math.max(curr,max);
            if((max-min)>(upper-lower)) return 0;
        }



        return (upper-lower)-(max-min)+1;
    }
}
