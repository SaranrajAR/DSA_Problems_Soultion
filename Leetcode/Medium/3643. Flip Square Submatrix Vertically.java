class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        List<int[]> list=new ArrayList<>();
        int m=grid.length;
        int n=grid[0].length;
        for(int i=x;i<x+k;i++){
            int[] arr=new int[k];
            int idx=0;
            for(int j=y;j<y+k;j++){
                arr[idx++]=grid[i][j];
            }
            list.add(arr);
        }
        int ix=0;
        Collections.reverse(list);
        for(int i=x;i<x+k;i++){
            int[] arr=list.get(ix++);
            int idx=0;
            for(int j=y;j<y+k;j++){
                grid[i][j]=arr[idx++];
            }
        }
        return grid;
    }
}
