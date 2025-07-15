class Solution {
    public boolean isValid(String word) {
        int charcount=0;
        boolean isVowel=false;
        boolean isConsonant=false;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            int current=(int) ch;
            if(current >= 65 && current <= 90 || current >= 97 && current <= 122 || current >= 48 && current <= 57){
               charcount++;
            } 
            else return false;
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u' || ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U'){
                isVowel=true;
            }
            else if ( !(current >= 48 && current <= 57)  ) {
                isConsonant=true;
            }
        }
        if(charcount>=3 && isVowel && isConsonant) return true;
        return false;
        
    }
}
