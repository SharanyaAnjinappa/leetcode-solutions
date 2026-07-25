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
    public boolean isPalindrome(ListNode head) {
        ListNode l=head;
        ListNode r=head;
        while(r!=null && r.next!=null){
            l=l.next;
            r=r.next.next;
        }
        ListNode second=reverse(l);
        ListNode first=head;
        while(second!=null){
            if(first.val!=second.val){return false;}
            first=first.next;
            second=second.next;
        }return true;
    }
    public ListNode reverse(ListNode curr){
        ListNode ptr=null;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=ptr;
            ptr=curr;
            curr=next;
        }
        return ptr;
    }
}