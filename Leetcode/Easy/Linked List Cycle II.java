/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast)// loop is detected
            {
                //here find the statring of the cycle
                slow=head;
                while(slow!=fast){
                    slow=slow.next;
                    fast=fast.next;
                }   
                return slow;
            }
        }
        return null;
        
    }
}
