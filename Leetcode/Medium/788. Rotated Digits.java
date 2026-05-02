class Solution {

    public int rotatedDigits(int n) {
        boolean[] valid=new boolean[n+1];
        int count=0;
        for(int i=0; i<=9 && i<=n ;i++){
            if(i==2 || i==5 || i==9 || i==6) {
                valid[i]=true;
                count++;
            }    
        }
        for(int i=10;i<=n;i++){
            String s=Integer.toString(i);
            if(s.indexOf("3")==-1 && s.indexOf("4")==-1 && s.indexOf("7")==-1){
                int num1=i/10;
                int num2=i%10;
                if(valid[num1] || valid[num2]){
                    valid[i]=true;
                    count++;
                }
            }
        }

        return count;

    }
}
