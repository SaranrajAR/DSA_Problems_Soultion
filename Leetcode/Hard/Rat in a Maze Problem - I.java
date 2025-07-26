class Solution {
    // Function to find all possible paths
    public int m;
    public int n;
    public ArrayList<String> res;
    
    public void helper(int[][] arr,StringBuffer current,int i,int j,int[][] visited){
        if(i==m-1 && j==n-1){
            res.add(current.toString());
            return;
        }
        visited[i][j]=1;
        if(i+1<m && canPlace(arr,i+1,j,visited)){ //downward;
            current.append("D");
            
            helper(arr,current,i+1,j,visited);
            current.deleteCharAt(current.length()-1);
            
        } 
        if(i-1>=0 && canPlace(arr,i-1,j,visited)){
            current.append("U");
            
            helper(arr,current,i-1,j,visited);
            current.deleteCharAt(current.length()-1);
            
        }
        
        if(j-1>=0 && canPlace(arr,i,j-1,visited)){
            current.append("L");
            
            helper(arr,current,i,j-1,visited);
            current.deleteCharAt(current.length()-1);
           
        }
        if(j+1<n && canPlace(arr,i,j+1,visited)){
            current.append("R");
            
            helper(arr,current,i,j+1,visited);
            current.deleteCharAt(current.length()-1);
            
        }
        visited[i][j]=0;
    }
    public boolean canPlace(int[][] arr,int i, int j,int[][] visited){
        return arr[i][j]==1 && visited[i][j]!=1;
    }
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        res=new ArrayList<>();
        m=maze.length;
        n=maze[0].length;
        if (maze[0][0] == 0 || maze[m - 1][n - 1] == 0) return res;
        
        int[][] visited=new int[m][n];
        helper(maze,new StringBuffer(),0,0,visited);
        Collections.sort(res);
        return res;
    }
}
