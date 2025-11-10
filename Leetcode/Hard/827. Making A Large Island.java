class Dsu{
    List<Integer> size;
    List<Integer> parent;
    Dsu(int n){
        size=new ArrayList<>();
        parent=new ArrayList<>();
        for(int i=0;i<n;i++){
            size.add(1);
            parent.add(i);
        }
    }
    public int find(int node){
        if(parent.get(node)==node) return node;
        int ulp=find(parent.get(node));
        parent.set(node,ulp);
        return ulp;
    }
    public void union(int u,int v){
        int ulp_u=find(u);
        int ulp_v=find(v);
        if(ulp_u==ulp_v) return;
        if(size.get(ulp_u)<size.get(ulp_v)){
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v,size.get(ulp_v)+size.get(ulp_u));
        }
        else{
            parent.set(ulp_v,ulp_u);
            size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
        }
    }
}
class Solution {
    int m;
    int n;
    public boolean isValid(int row,int col){
        return row>=0 && row<m && col>=0 && col<n;
    }
    public int largestIsland(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        int N=m*n;
        Dsu ds=new Dsu(N);
        int[] dRow=new int[]{-1,0,+1,0};
        int[] dCol=new int[]{0,+1,0,-1};
        int ans=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    int row=i;
                    int col=j;
                    for(int idx=0;idx<4;idx++){
                        int adjRow=i+dRow[idx];
                        int adjCol=j+dCol[idx];
                        if(isValid(adjRow,adjCol) && grid[adjRow][adjCol]==1){
                            int u=(row*m)+col;
                            int v=(adjRow*m)+adjCol;
                            ds.union(u,v);
                            

                        }
                    }
                }
            }
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) continue;
                Set<Integer> components=new HashSet<>();
                for(int idx=0;idx<4;idx++){
                    int adjRow=i+dRow[idx];
                    int adjCol=j+dCol[idx];
                    if(isValid(adjRow,adjCol)){
                        if(grid[adjRow][adjCol]==1){
                            components.add(ds.find((adjRow*m)+adjCol));
                        } 
                    }
                }
                int sizeTotal=0;
                for(int node:components){
                    sizeTotal+=ds.size.get(node);
                }
                ans=Math.max(ans,sizeTotal+1);
            }
        }
        for(int i=0;i<n*n;i++){
            ans=Math.max(ans,ds.size.get(i));
        }
        return ans;

    }
}
