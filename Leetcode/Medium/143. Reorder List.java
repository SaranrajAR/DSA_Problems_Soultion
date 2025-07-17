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
    public ListNode findMid(ListNode head){
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    public ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode temp=head;
        if(head==null || head.next==null) return head;
        ListNode front=head.next;
        while(front!=null ){
            temp.next=prev;
            prev=temp;
            temp=front;
            front=front.next;
        }
        temp.next=prev;
        prev=temp;
        return prev;
    }
    public void reorderList(ListNode head) {
        ListNode temp=head;
        ListNode mid=findMid(temp);
        ListNode second=reverse(mid.next);
        mid.next=null;
        ListNode dummy=new ListNode(-1);
        ListNode t=dummy;
        while(second!=null){
            dummy.next=temp;
            dummy=dummy.next;
            temp=temp.next;
            dummy.next=second;
            dummy=dummy.next;
            second=second.next;
            
            
        }
        dummy.next=temp;
        head=t.next;
    }
}
