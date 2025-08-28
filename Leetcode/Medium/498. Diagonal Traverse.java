class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        HashMap<Integer,List<Integer>> map= new HashMap<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int key=i+j;
                if(map.containsKey(key)){
                    map.get(key).add(mat[i][j]);
                }
                else{
                    List<Integer> temp=new ArrayList<>();
                    temp.add(mat[i][j]);
                    map.put(key,temp);
                }
            }
        }
        int[] ans=new int[m*n];
        int j=0;
        for(int i=0;i<map.size();i++){
            if(i%2!=0){
                List<Integer> temp=map.get(i);
                for(int k=0;k<temp.size();k++){
                    ans[j++]=temp.get(k);
                }
            }
            else{
                List<Integer> temp=map.get(i);
                Collections.reverse(temp);
                for(int k=0;k<temp.size();k++){
                    ans[j++]=temp.get(k);
                }
            }
        }
       
        
        return ans;
    }
}
