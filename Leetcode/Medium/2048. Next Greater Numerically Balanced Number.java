class Solution {
    public int nextBeautifulNumber(int n) {
        n++;
        int[] freq=new int[10];
        while(n<Integer.MAX_VALUE){
            String s=Integer.toString(n);
            freq=new int[10];
            for(char ch:s.toCharArray()){
                freq[ch-'0']++;
            }
            boolean isTrue=true;
            for(int i=0;i<10;i++){
                if(freq[i]>0 && freq[i]!=i){
                    isTrue=false;
                    break;
                }
            }
            if(isTrue) return n;
            n++;
        }
        return -1;
    }
    
}
