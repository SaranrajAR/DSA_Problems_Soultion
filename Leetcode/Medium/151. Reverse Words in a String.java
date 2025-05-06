class Solution {
    public String reverseWords(String s) {
        String[] arr=s.split(" ");
        
        StringBuilder ans=new StringBuilder();
        int n=arr.length;
        for(int i=n-1;i>=0;i--){
            if(arr[i].length()==0) continue;
            else{
                ans.append(arr[i]);
                ans.append(" ");
            }
            
        }
        ans.deleteCharAt(ans.length()-1);
        System.out.print(ans);
        return ans.toString();
        
    }
}
