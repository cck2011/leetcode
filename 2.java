class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode p;
        ListNode dummy = new ListNode(0);
        p = dummy;
        while(l1 !=null || l2 != null || carry!=0) {
            if(l1!=null) {
                carry +=l1.val;
                l1 = l1.next;
            }
            if(l2!=null) {
                carry +=l2.val;
                l2 = l2.next;
            }
            if(carry>9) {
                p.next = new ListNode(carry-10);
                carry = 1;
            } else {
                p.next = new ListNode(carry);
                carry = 0;
            }
            p = p.next;
        }
        return dummy.next;
    }
}

//java will round down during divide operater

public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int carry = 0;
    ListNode p, dummy = new ListNode(0);
    p = dummy;
    while (l1 != null || l2 != null || carry != 0) {
        if (l1 != null) {
            carry += l1.val;
            l1 = l1.next;
        }
        if (l2 != null) {
            carry += l2.val;
            l2 = l2.next;
        }
        p.next = new ListNode(carry%10);
        carry /= 10;
        p = p.next;
    }
    return dummy.next;
}