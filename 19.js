var removeNthFromEnd = function(head, n) {
    
    //why need to open a new node
   let slow = head;
   let fast = head;
   //why n+1
   for (let i=0; i<n;i++){
       fast = fast.next
   }
   if(!fast){
       return head.next;
   }
   //if loop more then node number, answer is remove the head
   //if use dummy, for loop +1, then no need to
   //if(!fast){
    //    return head.next;
    // }, 
   //if is 5 0,1,2,3,4
   //fast will be null after loop 5 time from head
   //so remove head
   
   while(fast.next){
       fast = fast.next;
       slow = slow.next;
   }
   slow.next = slow.next.next;
   return head;
};




// public ListNode removeNthFromEnd(ListNode head, int n) {
    
//     ListNode start = new ListNode(0);
//     ListNode slow = start, fast = start;
//     slow.next = head;
    
//     //Move fast in front so that the gap between slow and fast becomes n
//     for(int i=1; i<=n+1; i++)   {
//         fast = fast.next;
//     }
//     //Move fast to the end, maintaining the gap
//     while(fast != null) {
//         slow = slow.next;
//         fast = fast.next;
//     }
//     //Skip the desired node
//     slow.next = slow.next.next;
//     return start.next;
// }