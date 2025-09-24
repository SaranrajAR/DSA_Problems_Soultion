class Pair{
    int row;
    int col;
    Pair(int row,int col){
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m=image.length;
        int n=image[0].length;
        int[][] ans=new int[m][n];
        int[][] visited=new int[m][n];
        Queue<Pair> queue=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                visited[i][j]=0;
                ans[i][j]=image[i][j];
            }
            
        }
        visited[sr][sc]=1;
        queue.offer(new Pair(sr,sc));
        int original=image[sr][sc];
        ans[sr][sc]=color;
        int[] dRow=new int[]{-1,0,+1,0};
        int[] dCol=new int[]{0,+1,0,-1};
        while(!queue.isEmpty()){
            Pair temp=queue.poll();
            int r=temp.row;
            int c=temp.col;
            for(int i=0;i<4;i++){
                int Row=r+dRow[i];
                int Col=c+dCol[i];
                if(Row>=0 && Row<m && Col>=0 && Col<n && visited[Row][Col]==0 && image[Row][Col]==original){
                    queue.offer(new Pair(Row,Col));
                    visited[Row][Col]=1;
                    ans[Row][Col]=color;
                }
            }
        }
        return ans;
    }
}
