class Solution {
    public String decodeCiphertext(String s, int rowLength) {
        int colLength=s.length()/rowLength;
        char[][] arr=new char[rowLength][colLength];
        int idx=0;
        for(int i=0;i<rowLength;i++){
            for(int j=0;j<colLength;j++){
                arr[i][j]=s.charAt(idx++);
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int j=0;j<colLength;j++){
            int col=j;
            for(int row=0;row<rowLength;row++){
                sb.append(arr[row][col++]);
                if(col==colLength) break;
            }
        }
        int trimIdx=sb.length()-1;
        while(trimIdx>=0 && sb.charAt(trimIdx)==' ') trimIdx--;
        String res=sb.toString().substring(0,trimIdx+1);
        return res;
    }
}
