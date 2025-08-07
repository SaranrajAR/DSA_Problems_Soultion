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
class Pair{
    int first;
    ListNode second;
    Pair(int first,ListNode second){
        this.first=first;
        this.second=second;
    }
} 
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        for(int i=0;i<lists.length;i++){
            ListNode head=lists[i];
            while(head!=null){
                ListNode temp=head;
                head=head.next;
                temp.next=null;
                pq.offer(new Pair(temp.val,temp));
            }
        }
        ListNode dummy=new ListNode(-1);
        ListNode temp=dummy;
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            temp.next=p.second;
            temp=temp.next;
        }
        return dummy.next;
    }
}
