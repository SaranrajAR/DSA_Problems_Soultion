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
    public ListNode front;
    private boolean isStop;
    public void helper(ListNode current){
        if(current==null){
            return;
        }
        helper(current.next);
        if(isStop) return;
        if(front==current || front.next==current ){
            current.next=null;
            isStop=true;
            return;
        }
        ListNode temp=front.next;
        front.next=current;
        current.next=temp;
        front=temp;
    }
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        front=head;
        isStop=false;
        ListNode temp=head;
        helper(head);
        
    }
}
