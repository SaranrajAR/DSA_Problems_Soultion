class Solution {
    public int possibleStringCount(String word) {
        int count=1;
        int n=word.length();
        int i=0;
        while(i<n){
            int j=i+1;
            while(j< n && word.charAt(j)==word.charAt(i)){
                count++;
                j++;
            }
            i=j;
            
        }
        return count;
        
    }
}
