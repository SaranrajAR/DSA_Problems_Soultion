class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum=0;
        List<Integer> list=new ArrayList<>();
        int min=Integer.MAX_VALUE;
        int n=matrix.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]<0) list.add(matrix[i][j]);
                else {
                    sum+=matrix[i][j];
                }
                min=Math.min(min,Math.abs(matrix[i][j]));    
                
            }
        }
        if(list.size()%2==0){
            for(int num:list) sum+=Math.abs(num);
        }
        else{
            for(int num:list) sum+=Math.abs(num);
            sum-=2*min;
        }
        
        
        
        return sum;
        
    }
}
