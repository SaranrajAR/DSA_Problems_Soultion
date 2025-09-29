class Pair{
    String word;
    int step;
    Pair(String word,int step){
        this.word=word;
        this.step=step;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set=new HashSet<>();
        for(String word:wordList){
            set.add(word);
        }
        Queue<Pair> queue=new LinkedList<>();
        queue.offer(new Pair(beginWord,1));
        set.remove(beginWord);
        while(!queue.isEmpty()){
            Pair temp=queue.poll();
            String word=temp.word;
            if(word.equals(endWord)==true) return temp.step;
            for(int i=0;i<word.length();i++){
                
                for(char ch='a';ch<='z';ch++){
                    char[] charArray=word.toCharArray();
                    charArray[i]=ch;
                    String currWord=new String(charArray);
                    if(set.contains(currWord)){
                        set.remove(currWord);
                        queue.offer(new Pair(currWord,temp.step+1));
                    }
                }
            }

        }
        return 0;
    }
}
