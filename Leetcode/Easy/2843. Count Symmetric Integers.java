class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            String str = Integer.toString(i);
            if (str.length() % 2 == 0) {
                int l = 0, h = str.length() - 1;
                int sum1 = 0, sum2 = 0;
                while (l < h) {
                    sum1 += str.charAt(l) - '0';
                    sum2 += str.charAt(h) - '0';
                    l++;
                    h--;
                }
                if (sum1 == sum2) count++;
            }
        }
        return count;
    }
}