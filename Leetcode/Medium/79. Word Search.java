class Solution {
    int m;
    int n;
    public boolean dfs(char[][] board,String word,int row,int col,int index){
        if(index==word.length()) return true;
        if(!isSafe(board,word,row,col,index)) return false;

        char temp=board[row][col];
        board[row][col]='#';
        boolean found=dfs(board,word,row,col+1,index+1) || dfs(board,word,row,col-1,index+1) || dfs(board,word,row+1,col,index+1) || dfs(board,word,row-1,col,index+1);

        board[row][col]=temp;
        return found;
    }
    public boolean isSafe(char[][] board,String word,int row,int col, int index){
        if(row>=0 && row < m && col>=0 && col<n && board[row][col]==word.charAt(index)){
            return true;
        }
        return false;
    }
    public boolean exist(char[][] board, String word) {
        m=board.length;
        n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(dfs(board,word,i,j,0)) return true;
            }
        }
        return false;
    }
}
