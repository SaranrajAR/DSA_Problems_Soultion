class Solution {
    public List<List<String>> res;
    public void helper(char[][] board,int row,int n){
        if(row==n){
            List<String> temp=new ArrayList<>();
            for(char[] r:board){
                temp.add(new String(r));
            }
            res.add(temp);
            return;
        }
        for(int col=0;col<n;col++){
            if(isPlaceQueen(board,row,col,n)){
                board[row][col]='Q';
                helper(board,row+1,n);
                board[row][col]='.';
            }
        }
    }
    public boolean isPlaceQueen(char[][] board,int row,int col,int n){
        for(int i=0;i<row;i++){
            if(board[i][col]=='Q') return false;
        }
        for(int i=row-1,j=col-1; i>=0 && j>=0 ;i--,j--){
            if(board[i][j]=='Q') return false;
        }
        for(int i=row-1,j=col+1; i>=0 && j<n;j++,i--){
            if(board[i][j]=='Q') return false;
        }
        return true;
    }
    public List<List<String>> solveNQueens(int n) {
        res=new ArrayList<>();
        char[][] board=new char[n][n];
        for(char[] row:board){
            Arrays.fill(row,'.');
        }
        helper(board,0,n);

        return res;
    }
}
