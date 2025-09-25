class Pair{
    int row;
    int col;
    int dist;
    Pair(int row,int col,int dist){
        this.row=row;
        this.col=col;
        this.dist=dist;

    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int[][] visited=new int[m][n];
        int[][] distance=new int[m][n];
        Queue<Pair> queue=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    queue.offer(new Pair(i,j,0));
                    visited[i][j]=1;
                    
                }
            }
        }
        int[] dRow=new int[]{-1,0,+1,0};
        int[] dCol=new int[]{0,+1,0,-1};
        while(!queue.isEmpty()){
            Pair temp=queue.poll();
            int r=temp.row;
            int c=temp.col;
            int d=temp.dist;
            distance[r][c]=d;
            for(int i=0;i<4;i++){
                int Row=r+dRow[i];
                int Col=c+dCol[i];
                if(Row>=0 && Row<m && Col>=0 && Col<n && visited[Row][Col]==0){
                    visited[Row][Col]=1;
                    queue.offer(new Pair(Row,Col,d+1));
                }
            }
        }
        return distance;
    }
}
