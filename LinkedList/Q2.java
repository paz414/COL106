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
    public boolean hasCycle(ListNode head) {
        ListNode current1=head;
        ListNode current2=head;
        while(current1!=null && current1.next!=null)
        {
            current2=current2.next;
            current1=(current1.next).next;
            if(current2==current1)
                return true;
        }
        return false;
    }
}
