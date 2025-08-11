class Solution {
    double fractionalKnapsack(int[] values, int[] weights, int W) {
        // code here
        List<int[]> list=new ArrayList<>();
        
        int n=values.length;
        for(int i=0;i<n;i++){
            
            int val=values[i];
            int weight=weights[i];
            list.add(new int[]{val,weight});
            
        }
        double ans=0;
        int currCapacity=0;
        list.sort((a,b)-> Double.compare((double)b[0]/b[1], (double)a[0]/a[1]));
        for(int i=0;i<n;i++){
            int val=list.get(i)[0];
            int weight=list.get(i)[1];
            if(currCapacity+weight > W){
                int remaining=W-currCapacity;
                ans+=((double) val/weight)*remaining;
                break;
            }
            else{
                ans+=val;
                currCapacity+=weight;
            }
        }
        return ans;
    }
}
