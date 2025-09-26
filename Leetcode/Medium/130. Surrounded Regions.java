class Solution {
    int m;
    int n;
    public void dfs(int row,int col,int[][] visited,char[][] board){
        visited[row][col]=1;
        int[] dRow=new int[]{-1,0,+1,0};
        int[] dCol=new int[]{0,+1,0,-1};
        for(int i=0;i<4;i++){
            int Row=row+dRow[i];
            int Col=col+dCol[i];
            if(Row>=0 && Row<m && Col>=0 && Col<n && board[Row][Col]=='O' && visited[Row][Col]==0) 
            {
              dfs(Row,Col,visited,board);
            }
        }
    }
    public void solve(char[][] board) {
        m=board.length;
        n=board[0].length;
        int[][] visited=new int[m][n];
        for(int i=0;i<m;i++){
            if(board[i][0]=='O' && visited[i][0]==0) dfs(i,0,visited,board);
        }
        for(int i=0;i<n;i++){
            if(board[0][i]=='O' && visited[0][i]==0 ) dfs(0,i,visited,board);
        }

        for(int i=0;i<n;i++){
            if(board[m-1][i]=='O' && visited[m-1][i]==0) dfs(m-1,i,visited,board);
        }
        for(int i=0;i<m;i++){
            if(board[i][n-1]=='O' && visited[i][n-1]==0) dfs(i,n-1,visited,board);
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O' && visited[i][j]==0) board[i][j]='X';
            }
        }

    }
}
