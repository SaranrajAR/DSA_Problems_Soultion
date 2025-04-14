class Solution {
    public int findClosest(int x, int y, int z) {
        int diffX = Math.abs(x - z);
        int diffY = Math.abs(y - z);
        
        if (diffX < diffY) return 1;
        else if (diffY < diffX) return 2;
        else return 0;
    }
}
