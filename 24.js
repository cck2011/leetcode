function swapPairs( head) {
    node = new ListNode(-1);
   node.next = head;
    pre = node;
   while (pre.next != null && pre.next.next != null) {
        l1 = pre.next, l2 = pre.next.next;
        next = l2.next;
       l1.next = next;
       l2.next = l1;
       pre.next = l2;

       pre = l1;
   }
   return node.next;
}