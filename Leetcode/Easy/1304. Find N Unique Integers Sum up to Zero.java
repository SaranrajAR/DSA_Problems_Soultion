class Solution {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        int x = n / 2;

        for (int i = 0; i < n / 2; i++) {
            ans[i] = -x;
            ans[n - i - 1] = x;
            x--;
        }

        return ans;
    }
}
