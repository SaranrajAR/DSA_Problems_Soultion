class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        List<List<String>> ans = new ArrayList<>();
        if (!set.contains(endWord)) return ans;

        Queue<List<String>> queue = new LinkedList<>();
        List<String> startPath = new ArrayList<>();
        startPath.add(beginWord);
        queue.offer(startPath);

        List<String> usedOnLevel = new ArrayList<>();
        int level = 1;
        int shortest = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            List<String> path = queue.poll();

            if (path.size() > level) {
                for (String word : usedOnLevel) {
                    set.remove(word);
                }
                usedOnLevel.clear();
                level = path.size();
                if (level > shortest) break; // no need to continue
            }

            String word = path.get(path.size() - 1);
            if (word.equals(endWord)) {
                if (path.size() <= shortest) {
                    shortest = path.size();
                    ans.add(new ArrayList<>(path));
                }
            }

            for (int i = 0; i < word.length(); i++) {
                char[] arr = word.toCharArray();
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    arr[i] = ch;
                    String next = new String(arr);
                    if (set.contains(next)) {
                        List<String> newPath = new ArrayList<>(path);
                        newPath.add(next);
                        queue.offer(newPath);
                        usedOnLevel.add(next);
                    }
                }
            }
        }
        return ans;
    }
}
