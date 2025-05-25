class Solution {
    public int longestPalindrome(String[] words) {
        if (words == null || words.length == 0)
            return 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        int count = 0;
        boolean centerused = false;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (!map.containsKey(word)) continue;
            String reverse = "" + word.charAt(1) + word.charAt(0);

            if (word.equals(reverse)) {
                int freq = map.get(word);
                if (freq >= 2) {
                    count += 4;
                    freq -= 2;
                    if (freq <= 0)
                        map.remove(word);
                    else
                        map.put(word, freq);
                } 
                else {
                    if (!centerused) {
                        count += 2;
                        centerused = true;
                        freq--;
                        if(freq<=0) map.remove(word);
                        else map.put(word,freq);
                    }
                }
            }
            else if(map.containsKey(word) && map.containsKey(reverse)){
                count+=4;
                int freq=map.get(word);
                freq--;
                if(freq<=0) map.remove(word);
                else map.put(word,freq);
                int freq1=map.get(reverse);
                freq1--;
                if(freq1<=0) map.remove(reverse);
                else map.put(reverse,freq1);
            }

        }
        return count;

    }
}
