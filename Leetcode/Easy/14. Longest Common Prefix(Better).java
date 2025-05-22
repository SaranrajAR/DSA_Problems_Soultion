class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        // Loop over each character of the first string
        for (int i = 0; i < strs[0].length(); i++) {
            char ch = strs[0].charAt(i); // Current character to compare
            for (int j = 1; j < strs.length; j++) {
                // If index exceeds the length of the current string
                // OR if the character doesn't match, stop and return prefix so far
                if (i >= strs[j].length() || strs[j].charAt(i) != ch) {
                    return strs[0].substring(0, i);
                }
            }
        }

        // If all characters matched, return the full first string
        return strs[0];
        
    }
}
