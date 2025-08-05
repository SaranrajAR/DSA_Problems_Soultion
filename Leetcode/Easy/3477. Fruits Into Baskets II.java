class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int count=baskets.length;
        for(int fruit:fruits){
            for(int i=0;i<baskets.length;i++){
                if(baskets[i]>=fruit && baskets[i]!=-1){
                    count--;
                    baskets[i]=-1;
                    break;
                }
            }
        }
        return count;
    }
}
