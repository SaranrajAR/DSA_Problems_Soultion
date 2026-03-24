class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        long mod=12345;
        int m=grid.length;
        int n=grid[0].length;
        long[] prefix=new long[(m*n)+2];
        long[] suffix=new long[(m*n)+2];
        Arrays.fill(prefix,1);
        Arrays.fill(suffix,1);
        for(int i=0;i<m;i++){
            int idx=(i*n)+1;
            for(int j=0;j<n;j++){
                prefix[idx+j]=((long) prefix[idx+j-1]*(long) grid[i][j])%mod;
            }
        }
        for(int i=m-1;i>=0;i--){
            int idx=(i*n)+1;
            for(int j=n-1;j>=0;j--){
                suffix[idx+j]=((long) suffix[idx+j+1]*(long) grid[i][j])%mod;
            }
        }
        
        int[][] res=new int[m][n];
        for(int i=0;i<m;i++){
            int idx=(i*n)+1;
            for(int j=0;j<n;j++){

                res[i][j]=(int) ((prefix[(idx+j)-1]*suffix[(idx+j)+1])%mod);
            }
        }
        return res;
    }
}
