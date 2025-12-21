class Solution {
    public int minDeletionSize(String[] strs) {
        int count=0;
        int n=strs.length;
        int n1=strs[0].length();
        String[] arr=new String[n];
        for(int col=0;col<n1;col++){
            String[] temp=Arrays.copyOf(arr,n);
            for(int i=0;i<n;i++){
                temp[i]=temp[i]+strs[i].charAt(col);
            }
            String[] copy=Arrays.copyOf(temp,n);
            Arrays.sort(temp);
            if(!Arrays.toString(copy).equals(Arrays.toString(temp))){
                count++;
                continue;
            }
            else{
                arr=temp;
            }
            
        }
        return count;
    }
}
