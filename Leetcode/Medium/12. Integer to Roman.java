class Solution {
    public String intToRoman(int num) {
        StringBuilder roman=new StringBuilder();
        String[] symbol={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] value={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        for(int index=0;num>0;index++){
            while(num>=value[index]){
                roman.append(symbol[index]);
                num-=value[index];
            }
        }
        return roman.toString();
        
    }
}
