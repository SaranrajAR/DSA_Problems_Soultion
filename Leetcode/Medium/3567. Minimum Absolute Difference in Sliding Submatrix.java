class Solution {
    public int computeDiff(int[][] grid,int row,int col,int k){
        TreeSet<Integer> set=new TreeSet<>();
        for(int i=row;i<row+k;i++){
            for(int j=col;j<col+k;j++){
                set.add(grid[i][j]);
            }
        }
        
        if(set.size()==1) return 0;
        long res=Integer.MAX_VALUE;
        long prev=Integer.MAX_VALUE;
        for(int curr:set){
            res=Math.min(Math.abs((curr-prev)),res);
            prev=curr;
        }
        return (int) res;
    }
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] res=new int[m-k+1][n-k+1];
        for(int i=0;i<=m-k;i++){
            for(int j=0;j<=n-k;j++){
                res[i][j]=computeDiff(grid,i,j,k);
            }
        }
        return res;
    }
}
