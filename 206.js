let reverseList = function(head) {
    let prev = null, next = null;
    while (head) {
        next = head.next
        //need next varblies cuz after node pointer break connection, need a varblie to gain access to "next" node
        head.next = prev;
        //point to previous node
        prev = head;
        head = next;
    }
    return prev;
};