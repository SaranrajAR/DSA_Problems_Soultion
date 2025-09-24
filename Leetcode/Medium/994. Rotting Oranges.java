class Pair{
    int row;
    int col;
    int time;
    Pair(int row,int col,int time){
        this.row=row;
        this.col=col;
        this.time=time;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] visited=new int[m][n];
        Queue<Pair> queue=new LinkedList<>();
        int cntFresh=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    visited[i][j]=1;
                    queue.offer(new Pair(i,j,0));
                }
                else{
                    visited[i][j]=0;
                }
                if(grid[i][j]==1) cntFresh++;
            }
        }

        int ans=0;
        int[] dRow=new int[]{-1,0,+1,0};
        int[] dCol=new int[]{0,+1,0,-1};

        while(!queue.isEmpty()){
            Pair temp=queue.poll();
            int r=temp.row;
            int c=temp.col;
            int t=temp.time;
            ans=Math.max(ans,t);
            for(int i=0;i<4;i++){
                int Row=r+dRow[i];
                int Col=c+dCol[i];

                if(Row>=0 && Row<m && Col>=0 && Col<n && visited[Row][Col]==0 && grid[Row][Col]==1){
                    visited[Row][Col]=1;
                    queue.offer(new Pair(Row,Col,t+1));
                }
            }

        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && visited[i][j]==0) return -1; 
            }
        }

        return ans;
    }
}
