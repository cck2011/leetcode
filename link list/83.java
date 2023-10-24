//recursion


public ListNode deleteDuplicates(ListNode head) {
    if (head == null || head.next == null) return head;
    head.next = deleteDuplicates(head.next);//get the previous node to skip the previous loop head (the problem is the last loop if first and second is the same, then it will return second because there are no more previous node)
    return head.val == head.next.val ? head.next : head;
}

//1,1
//the same so return head.next

public ListNode deleteDuplicates(ListNode head) {
    ListNode newHead = head;
    while(head != null && head.next != null){
        if(head.val == head.next.val){
            head.next = head.next.next;
        }else{
            head = head.next;
        }
        
    }
    return newHead;

}