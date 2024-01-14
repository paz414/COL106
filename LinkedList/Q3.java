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
        String s="";
        ListNode current=head;
        while(current!=null){
            s=s+""+current.val;
            current=current.next;
        }
        StringBuilder rev=new StringBuilder(s);
        rev.reverse();
        return (rev.toString()).equals(s);
    }
}
