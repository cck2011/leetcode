var getIntersectionNode = function(headA, headB) {
    if (!headA || !headB) return null;
    var curA = headA;
    var curB = headB;
    while (curA != curB) {
        curA = curA == null ? headB : curA.next;
        curB = curB == null ? headA : curB.next;
        //l1 end then go l2, l2 end go l1
        //Although have different len(l1,l2), 
        //the short one will compensate it after going to the other list 
        //and two list will start in the same node of length of node 
    }
    return curA;
};