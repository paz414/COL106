import java.util.*;
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
        ListNode current1=l1;
        ListNode current2=l2;
        String s1="",s2="";
        while(current1!=null)
        {
            s1=""+current1.val+s1;
            current1=current1.next;
        }
        while(current2!=null)
        {
            s2=""+current2.val+s2;
            current2=current2.next;
        }
        if(s2.length()>s1.length())
        {
            String t=s1;
            s1=s2;
            s2=t;
        }
        while(s2.length()<s1.length())
            s2="0"+s2;
        int carry=0;
        String res="";
        for(int i=s1.length()-1;i>=0;i--)
        {
            int test=((int)s2.charAt(i)+(int)s1.charAt(i)+carry-96);
            int add=test%10;
            carry=test/10;
            res=""+add+res;
        }
        if(carry!=0)
            res=carry+res;
        ListNode l3=null;
        ListNode tail=null;
        for(int i=res.length()-1;i>=0;i--)
        {
            ListNode newNode=new ListNode((int)res.charAt(i)-48,null);
            if(l3==null)
            {
                l3=newNode;
                tail=newNode;
            }
            else
            {
                tail.next=newNode;
                tail=newNode;
            }
            
        }
        return l3;
    }
}
