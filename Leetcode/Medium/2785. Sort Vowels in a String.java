class Solution {
    public String sortVowels(String s) {
        List<Character> list=new ArrayList<>();
        Set<Character> set=new HashSet<>();
        char[] arr=s.toCharArray();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');

        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(set.contains(c)){
                list.add(c);
            }
        }
        Collections.sort(list);
        int j=0;
        for(int i=0;i<s.length();i++){
            if(set.contains(arr[i])){
                arr[i]=list.get(j++);
            }
        }
        return new String(arr);
    }
}
