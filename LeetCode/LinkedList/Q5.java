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
    public ListNode reverseList(ListNode head) {
        ArrayList<Integer> a=new ArrayList<Integer>();
        ListNode curr=head;
        while(curr!=null){
            a.add(curr.val);
            curr=curr.next;
        }
        curr=head; int i=a.size()-1;
        while(i>=0){
            int temp=curr.val;
            curr.val=a.get(i--);
            curr=curr.next;
        }
        return head;
        
    }
}
