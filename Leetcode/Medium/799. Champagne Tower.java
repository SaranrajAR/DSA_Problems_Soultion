class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        List<Double> prev=new ArrayList<>();
        prev.add((double) poured);
        if(query_row==0) return Math.min(poured,1);
        for(int i=1;i<=query_row;i++){
            List<Double> curr=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0) curr.add(Math.max(0,(prev.get(0)-1)/2));
                else if(j==i) curr.add(Math.max(0,((prev.get(j-1)-1)/2)));
                else{
                    double leftOverFlow=Math.max(0,(prev.get(j-1)-1)/2);
                    double rightOverFlow=Math.max(0,(prev.get(j)-1)/2);
                    // curr.add(Math.max(0,(((prev.get(j-1)-1)/2)+(prev.get(j)-1)/2)))
                    curr.add(leftOverFlow+rightOverFlow);
                }
                
            }
            prev=curr;
        } 
        return Math.min(prev.get(query_glass),1);
    }
}
