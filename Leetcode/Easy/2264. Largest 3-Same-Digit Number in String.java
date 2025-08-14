class Solution {
    public String largestGoodInteger(String num) {
        int max=-1;
        boolean isZero=false;
        for(int i=0;i<num.length()-2;i++){
            String s=num.substring(i,i+3);
            switch(s){
                case "999":
                    max=999;
                    break;
                case "888":
                    max=Math.max(max,888);
                    break;
                case "777":
                    max=Math.max(max,777);        
                    break;
                case "666":
                    max=Math.max(max,666);
                    break;
                case "555":
                    max=Math.max(max,555);
                    break;
                case "444":
                    max=Math.max(max,444);
                    break;
                case "333":
                    max=Math.max(max,333);
                    break;
                case "222":
                    max=Math.max(max,222);
                    break;
                case "111":
                    max=Math.max(max,111);
                    break;
                case "000":
                    max=Math.max(max,000);
                    isZero=true;
                    break;       

            }

        }
        if(max==-1) return "";
        if(max==0 && isZero) return "000";
        return Integer.toString(max);
    }
}
