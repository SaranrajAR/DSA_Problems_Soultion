class Pair{
    int dis;
    int row;
    int col;
    Pair(int dis,int row,int col){
        this.dis=dis;
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m=grid.length;
        int n=m;
        int[][] dist=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
   
        Queue<Pair> pq=new LinkedList<>();
        if(grid[0][0]==0){
            pq.offer(new Pair(1,0,0));
            dist[0][0]=1;
        }
        
        int[] dRow=new int[]{-1,-1,0,+1,+1,+1,0,-1};
        int[] dCol=new int[]{0,+1,+1,+1,0,-1,-1,-1};
        while(!pq.isEmpty()){
            Pair temp=pq.poll();
            int dis=temp.dis;
            int row=temp.row;
            int col=temp.col;
            for(int i=0;i<8;i++){
                int Row=row+dRow[i];
                int Col=col+dCol[i];
                
                if(Row>=0 && Row<m && Col>=0 && Col<n && grid[Row][Col]==0 && dist[Row][Col]>dis+1){
                    pq.offer(new Pair(dis+1,Row,Col));
                    dist[Row][Col]=dis+1;
                }
            }
        }
        
        return dist[m-1][n-1]!=Integer.MAX_VALUE?dist[m-1][n-1]:-1;
    }
}
