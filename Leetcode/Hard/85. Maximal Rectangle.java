class Solution {
    public int helper(int[] arr,int n){
        int max=0;
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && arr[stack.peek()]>arr[i]){
                int element=stack.pop();
                int nse=i;
                int pse=stack.isEmpty()?-1:stack.peek();
                max=Math.max(max,arr[element]*(nse-pse-1));
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int element=stack.pop();
            int nse=n;
            int pse=stack.isEmpty()?-1:stack.peek();
            max=Math.max(max,arr[element]*(nse-pse-1));
        }
        return max;
    }
    public int maximalRectangle(char[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int[][] prefix=new int[n][m];
        for(int j=0;j<m;j++){
            int sum=0;
            for(int i=0;i<n;i++){
                if(matrix[i][j]=='0') sum=0;
                else sum+=1;
                prefix[i][j]=sum;
            }
        }
        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(max,helper(prefix[i],m));
        }
        return max;

        
    }
}
