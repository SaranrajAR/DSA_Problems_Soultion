class Solution {
    public String convertToTitle(int columnNumber) {
        String str="";
        while(columnNumber>0){
            columnNumber--; // why this is becuase if n=1 -> 0+A =A
            // Also when n=26 25+A==Z  ? 26%26==0

            str=(char) (columnNumber%26 + 'A') + str;
            columnNumber/=26;

        }
        return str;
    }
}
