class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        HashSet<String> set=new HashSet<>();
        for(int[] obs:obstacles){
            set.add(obs[0]+" "+obs[1]);
        }
        int[][] directions=new int[][]{
            {0,1},{1,0},{0,-1},{-1,0} // north,east,south,west
        };
        int i=0;
        int j=0;
        int dir=0; //initally facing North
        
        int maxAns=0;
        for(int cmd:commands){
            if(cmd==-1) dir=(dir+1)%4; //Eg north->east, east->south -->right
            else if(cmd==-2) dir=(dir+3)%4;
            else{
                for(int k=0;k<cmd;k++){
                    int currI=directions[dir][0]+i;
                    int currJ=directions[dir][1]+j;
                    if(set.contains(currI+" "+currJ) ) break;
                    i=currI;
                    j=currJ;
                    maxAns=Math.max(maxAns,(i*i)+(j*j));
                }
            }
        }
        return maxAns;
    }
}
