/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int getDecimalValue(ListNode head) {
        List<Integer> list=new ArrayList<>();
        ListNode temp=head;
        while(temp!=null){
            list.add(temp.val);
            temp=temp.next;
            
        }
        int n=0;
        int res=0;
        Collections.reverse(list);
        for(int i=0;i<list.size();i++){
            res+=list.get(i)*Math.pow(2,n);
            n++;
        }
        return res;
        
    }
}
