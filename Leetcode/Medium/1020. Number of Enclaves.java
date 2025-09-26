class Pair{
    int row;
    int col;
    Pair(int row,int col){
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public int numEnclaves(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] visited=new int[m][n];
        Queue<Pair> queue=new LinkedList<>();
        for(int i=0;i<m;i++){
            if(grid[i][0]==1){
                visited[i][0]=1;
                queue.offer(new Pair(i,0));
            }
            if(grid[i][n-1]==1){
                visited[i][n-1]=1;
                queue.offer(new Pair(i,n-1));
            }
        }
        for(int i=0;i<n;i++){
            if(grid[0][i]==1){
                visited[0][i]=1;
                queue.offer(new Pair(0,i));
            }
            if(grid[m-1][i]==1){
                visited[m-1][i]=1;
                queue.offer(new Pair(m-1,i));
            }
        }
        int[] dRow=new int[]{-1,0,+1,0};
        int[] dCol=new int[]{0,+1,0,-1};
        while(!queue.isEmpty()){
            Pair temp=queue.poll();
            int r=temp.row;
            int c=temp.col;
            for(int i=0;i<4;i++){
                int Row=r+dRow[i];
                int Col=c+dCol[i];
                if(Row>=0 && Row<m && Col>=0 && Col<n && grid[Row][Col]==1 && visited[Row][Col]==0){
                    queue.offer(new Pair(Row,Col));
                    visited[Row][Col]=1;
                }
            }
        }

        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && visited[i][j]==0) ans++;
            }
        }
        return ans;
    }
}
