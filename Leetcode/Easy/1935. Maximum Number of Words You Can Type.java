class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> set=new HashSet<>();
        for(char c:brokenLetters.toCharArray()){
            set.add(c);
        }
        int count=0;
        String[] words=text.split(" ");
        for(String word:words){
            boolean isTrue=true;
            for(char ch:word.toCharArray()){
                if(set.contains(ch)){
                    isTrue=false;
                    break;
                }
            }
            if(isTrue) count++;
        }
        return count;
    }
}
