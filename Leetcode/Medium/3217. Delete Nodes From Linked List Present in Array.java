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
    public ListNode modifiedList(int[] nums, ListNode head) {
        ListNode prev=new ListNode(-1);
        Set<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        ListNode dummy=prev;
        ListNode temp=head;
        prev.next=head;
        
        while(temp!=null){
            if(set.contains(temp.val)){
                ListNode t=temp;
                temp=temp.next;
                t.next=null;
                prev.next=temp;
            }
            else{
                prev=temp;
                temp=temp.next;
            }

        }
        return dummy.next;
    }
}
