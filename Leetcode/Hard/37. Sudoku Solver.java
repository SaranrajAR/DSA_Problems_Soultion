class Solution {
    public boolean isSafe(char[][] board,char ch,int row,int col){
        for(int i=0;i<9;i++){
            if(board[row][i]==ch) return false;
            if(board[i][col]==ch) return false;
            int R=(row/3 * 3) +(i/3);
            int C=(col/3 * 3) +(i%3);
            if(board[R][C]==ch) return false;
            
        }
        return true;
    }
    public boolean helper(char[][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    for(char ch='1';ch<='9';ch++){
                        if(isSafe(board,ch,i,j)){
                            board[i][j]=ch;
                            if(helper(board)) return true;
                            else board[i][j]='.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public void solveSudoku(char[][] board) {
        helper(board);
    }
}
