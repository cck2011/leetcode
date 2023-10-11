public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode l1 = headA, l2 = headB;
    while (l1 != l2) {
        l1 = (l1 == null) ? headB : l1.next;
        l2 = (l2 == null) ? headA : l2.next;
    }
    return l1;
}
//time complexity: m+n (two linklist length)
// space complexity: 1

 public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode l1 = headA;
    ListNode l2 = headB;

    while(l1 != l2){
        if(l1 != null){
            l1 = l1.next;
            }else{
                l1 = headB;
                };
        if(l2 != null){
            l2 = l2.next;
            }else{
                l2 = headA;
                };

    }
    return l1;
    }

//hash map

public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    Set<ListNode> visited = new HashSet<ListNode>();
    ListNode temp = headA;
    while (temp != null) {
        visited.add(temp);
        temp = temp.next;
    }
    temp = headB;
    while (temp != null) {
        if (visited.contains(temp)) {
            return temp;
        }
        temp = temp.next;
    }
    return null;
}
//time m+n
//space m