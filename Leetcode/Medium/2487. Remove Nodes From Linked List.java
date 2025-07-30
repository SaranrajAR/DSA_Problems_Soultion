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
    int max=0;
    public ListNode helper(ListNode head){
        if(head.next==null){
            max=head.val;
            return head;
        }
        ListNode newHead=helper(head.next);
        if(head.val<max){
            head.next=null;
            head=newHead;
        }
        else{
            head.next=newHead;
        }
        max=Math.max(max,head.val);
        return head;
    }
    public ListNode removeNodes(ListNode head) {
        ListNode newhead=helper(head);
        return newhead;
    }
}
