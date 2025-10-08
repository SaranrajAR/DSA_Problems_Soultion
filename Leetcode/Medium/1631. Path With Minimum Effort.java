class Pair{
    int diff;
    int row;
    int col;
    Pair(int diff,int row,int col){
        this.diff=diff;
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->{
            return a.diff-b.diff;
        });
        int[][] dist=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        dist[0][0]=0;
        pq.offer(new Pair(0,0,0));
        int[] dRow=new int[]{-1,0,+1,0};
        int[] dCol=new int[]{0,+1,0,-1};
        int ans=Integer.MAX_VALUE;
        while(!pq.isEmpty()){
            Pair temp=pq.poll();
            int row=temp.row;
            int col=temp.col;
            int diff=temp.diff;
            if(row==m-1 && col==n-1) return diff;
            for(int i=0;i<4;i++){
                int Row=row+dRow[i];
                int Col=col+dCol[i];
                if(Row>=0 && Row<m && Col>=0 && Col<n){
                    int newDiff=heights[row][col]-heights[Row][Col];
                    newDiff=Math.abs(newDiff);
                    newDiff=Math.max(diff,newDiff);
                    if(newDiff < dist[Row][Col]){
                        pq.offer(new Pair(newDiff,Row,Col));
                        dist[Row][Col]=newDiff;
                    }
                    
                    
                }
            }
        }
        return 0;


    }
}
