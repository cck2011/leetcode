var deleteDuplicates = function(head) {
    let cur = head
    while(cur !== null && cur.next !== null){
           if(cur.val === cur.next.val){
          cur.next = cur.next.next
        }else{
            cur= cur.next
        }
           
}
   return head
};

//recurive
var deleteDuplicates = function(head) {
    
    function recurse(node) {
        if(!node || !node.next) return;
        while(node.next && node.next.val === node.val) {
            node.next = node.next.next;
        }
        recurse(node.next);
        //next node
    }
    recurse(head);
    return head;
};

function deleteDuplicates(head) {
    if (head == null || head.next == null) return head;
    head.next = deleteDuplicates(head.next);
    return head.val == head.next.val ? head.next : head;
}