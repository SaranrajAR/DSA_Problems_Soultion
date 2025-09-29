// User function Template for Java
class Pair{
    int row;
    int col;
    Pair(int row,int col){
        this.row=row;
        this.col=col;
    }
}
class Solution {
    int m;
    int n;
    
    public void dfs(int row,int col,int[][] grid,int[][] visited, List<String> list,int row0,int col0){
        visited[row][col]=1;
        list.add(toString(row-row0,col-col0));
        int[] dRow=new int[]{-1,0,+1,0};
        int[] dCol=new int[]{0,+1,0,-1};
        for(int i=0;i<4;i++){
            int Row=dRow[i]+row;
            int Col=dCol[i]+col;
            if(Row>=0 && Row<m && Col>=0 && Col<n && grid[Row][Col]==1 && visited[Row][Col]==0){
                // list.add(new Pair(Row,Col));
                dfs(Row,Col,grid,visited,list,row0,col0);
            }
            
        }
        
    }
    public String toString(int row,int col){
        return Integer.toString(row)+" "+Integer.toString(col);
    }
    int countDistinctIslands(int[][] grid) {
        // Your Code here
        m=grid.length;
        n=grid[0].length;
        int[][] visited=new int[m][n];
        int cnt=0;
        Set<List<String>> set=new HashSet<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && visited[i][j]==0){
                    List<String> list=new ArrayList<>();
                    dfs(i,j,grid,visited,list,i,j);
                    set.add(list);
                }
            }
        }
        return set.size();
    }
   
}
