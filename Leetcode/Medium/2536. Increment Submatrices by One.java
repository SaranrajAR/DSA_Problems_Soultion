class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] arr=new int[n][n];
        for(int[] query:queries){
            
            int startRow=query[0];
            int startCol=query[1];
            int endRow=query[2];
            int endCol=query[3];
            for(int i=startRow;i<=endRow;i++){
                for(int j=startCol;j<=endCol;j++){
                    arr[i][j]+=1;
                }
            }
            

        }
        return arr;
    }
}
