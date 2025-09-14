class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> set=new HashSet<>();
        HashMap<String,String> caseInsensitive=new HashMap<>();
        HashMap<String,String> vowelPattern=new HashMap<>();
        for(String word:wordlist){
            set.add(word);
            caseInsensitive.putIfAbsent(word.toLowerCase(),word);
            vowelPattern.putIfAbsent(devowel(word.toLowerCase()),word);
        }
        String[] res=new String[queries.length];
        int i=0;
        for(String query:queries){
            if(set.contains(query)) res[i++]=query;
            else if(caseInsensitive.containsKey(query.toLowerCase())){
                res[i++]=caseInsensitive.get(query.toLowerCase());
            }
            else if(vowelPattern.containsKey(devowel(query.toLowerCase()))){
                res[i++]=vowelPattern.get(devowel(query.toLowerCase()));
            }
            else res[i++]="";
        }
        return res;
    }

    public String devowel(String s){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(isVowel(s.charAt(i))) sb.append('*');
            else sb.append(s.charAt(i));
        }
        return sb.toString();
    }
    public boolean isVowel(char ch){
        return (ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u');
    }
}
