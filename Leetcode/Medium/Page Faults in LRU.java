// User function Template for Java

class Solution {
    static int pageFaults(int N, int C, int pages[]) {
        // code here
        int count=0;
        Set<Integer> set=new HashSet<>();
        LinkedList<Integer> list=new LinkedList<>();
        for(int page:pages){
            if(set.contains(page)){
                list.remove((Integer)page);
                list.addLast(page);
            }
            else{
                count++;
                if(set.size()==C){
                    set.remove(list.removeFirst());
                }
                set.add(page);
                list.addLast(page);
            }
        }
        return count;
    }
}
