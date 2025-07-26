class Solution {
    // Function to find all possible paths
    public int m;
    public int n;
    public ArrayList<String> res;
    public void helper(int[][] arr,StringBuffer current,int i,int j){
        if(i==m-1 && j==n-1){
            res.add(current.toString());
            return;
        }
        arr[i][j]=-1;
        if(i+1<m && canPlace(arr,i+1,j)){ //downward;
            current.append("D");
            
            helper(arr,current,i+1,j);
            current.deleteCharAt(current.length()-1);
            
        } 
        if(i-1>=0 && canPlace(arr,i-1,j)){
            current.append("U");
            
            helper(arr,current,i-1,j);
            current.deleteCharAt(current.length()-1);
            
        }
        
        if(j-1>=0 && canPlace(arr,i,j-1)){
            current.append("L");
            
            helper(arr,current,i,j-1);
            current.deleteCharAt(current.length()-1);
           
        }
        if(j+1<n && canPlace(arr,i,j+1)){
            current.append("R");
            
            helper(arr,current,i,j+1);
            current.deleteCharAt(current.length()-1);
            
        }
        arr[i][j]=1;
    }
    public boolean canPlace(int[][] arr,int i, int j){
        if(arr[i][j]!=1) return false;
        return true;
    }
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        if(maze[0][0]!=1) return new ArrayList<String>();
        m=maze.length;
        n=maze[0].length;
        res=new ArrayList<>();
        helper(maze,new StringBuffer(),0,0);
        Collections.sort(res);
        return res;
    }
}
