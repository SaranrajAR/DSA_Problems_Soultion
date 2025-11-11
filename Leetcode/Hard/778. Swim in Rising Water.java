class Pair{
    int val;
    int row;
    int col;
    Pair(int val,int row,int col){
        this.val=val;
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public int swimInWater(int[][] grid) {
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.val-b.val);
        int n=grid.length;
        int[][] visited=new int[n][n];
        pq.offer(new Pair(grid[0][0],0,0));
        int ans=Integer.MIN_VALUE;
        int[] dRow=new int[]{-1,0,+1,0};
        int[] dCol=new int[]{0,+1,0,-1};
        while(!pq.isEmpty()){
            Pair temp=pq.poll();
            int row=temp.row;
            int col=temp.col;
            if(visited[row][col]==1) continue;
            visited[row][col]=1;
            ans=Math.max(ans,temp.val);
            if(row==n-1 && col==n-1) return ans;
            for(int i=0;i<4;i++){
                int nRow=row+dRow[i];
                int nCol=col+dCol[i];
                if(nRow>=0 && nRow<n && nCol>=0 && nCol<n) pq.offer(new Pair(grid[nRow][nCol],nRow,nCol));
            }

        }
        return ans;
    }
}
