class Solution {
    public long calculateScore(String[] instructions, int[] values) {
        long score=0;
        Set<Integer> visited=new HashSet<>();
        int i=0;
        while(i>=0 && i<values.length && !visited.contains(i)){
            visited.add(i);
            if(instructions[i].equals("jump")){
                i+=values[i];
            }
            else{
                score+=values[i];
                i++;
            }
        }
        return score;
        
    }
}
