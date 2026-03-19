class Solution {
    
    public int countSubmatrices(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] prefix=new int[m][n];
        int count=0;
        prefix[0][0]=grid[0][0];
        if(prefix[0][0]<=k) count++;
        for(int i=1;i<n;i++){
            prefix[0][i]=prefix[0][i-1]+grid[0][i];
            if(prefix[0][i]<=k) count++;
            
        }
        for(int i=1;i<m;i++){
            prefix[i][0]=prefix[i-1][0]+grid[i][0];
            if(prefix[i][0]<=k) count++;
            
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                prefix[i][j]=(prefix[i-1][j]+prefix[i][j-1]+grid[i][j])-prefix[i-1][j-1];
                if(prefix[i][j]<=k) count++;
                
            }
        }
        return count;



    }
}
