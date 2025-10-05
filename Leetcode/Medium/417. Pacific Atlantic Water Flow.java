class Solution {
    int m;
    int n;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans=new ArrayList<>();
        if(heights==null || heights.length ==0 || heights[0].length==0) return ans;
        m=heights.length;
        n=heights[0].length;
        int row=m;
        int col=n;
        boolean[][] PVisited=new boolean[m][n];
        boolean[][] AVisited=new boolean[m][n];
        int[] dRow=new int[]{-1,0,+1,0};
        int[] dCol=new int[]{0,+1,0,-1};
        for(int i=0;i<row;i++){
            dfs(i,0,heights,PVisited,dRow,dCol,Integer.MIN_VALUE);
            dfs(i,col-1,heights,AVisited,dRow,dCol,Integer.MIN_VALUE);
        }

        for(int i=0;i<col;i++){
            dfs(0,i,heights,PVisited,dRow,dCol,Integer.MIN_VALUE);
            dfs(row-1,i,heights,AVisited,dRow,dCol,Integer.MIN_VALUE);
        }


        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(PVisited[i][j] && AVisited[i][j]) ans.add(Arrays.asList(i,j));
            }
        }
        return ans;
    }

    public void dfs(int i,int j,int[][] heights,boolean[][] Visited,int[] dRow,int[] dCol,int prev){
        if(i<0 || i>=m || j<0 || j>=n) return;
        if(Visited[i][j] || heights[i][j] <prev) return;
        Visited[i][j]=true;
        for(int k=0;k<4;k++){
            int row=i+dRow[k];
            int col=j+dCol[k];
            dfs(row,col,heights,Visited,dRow,dCol,heights[i][j]);
        }
    }


}
