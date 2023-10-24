public ListNode reverseList (head){
    ListNode cur = head;
    ListNode pre = null;
    ListNode next = null;

    while(head != null|| head.next != null){
        next = cur.next;
        cur.next = pre;
        pre = cur;
        cur = next;
    }

    return pre;
}