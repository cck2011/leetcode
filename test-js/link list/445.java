
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);

        ListNode temp = new ListNode(0), head = temp;
        int carry = 0;
        
        while(l1 != null || l2 != null || carry != 0){
            int sum = 0;
            sum+= (l1 != null) ? l1.val : 0;
            sum+= (l2 != null) ? l2.val : 0;
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;

            sum+=carry;
            carry = sum/10;
            ListNode n = new ListNode(sum%10);
            temp.next = n;
            temp = temp.next;
        }

        ListNode ans = reverse(head.next);
        return ans;
    }
    
    public ListNode reverse(ListNode head){
        ListNode prev=null, curr=head;
        while(curr != null){
            ListNode n = curr.next;
            curr.next = prev;
            prev = curr;
            curr = n;
        }
        return prev;
    }
//125+125
//521+521
//052
//250



public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    Stack<Integer> l1Stack = buildStack(l1);
    Stack<Integer> l2Stack = buildStack(l2);
    ListNode head = new ListNode(-1);
    int carry = 0;
    while (!l1Stack.isEmpty() || !l2Stack.isEmpty() || carry != 0) {
        int x = l1Stack.isEmpty() ? 0 : l1Stack.pop();
        int y = l2Stack.isEmpty() ? 0 : l2Stack.pop();
        int sum = x + y + carry;
        ListNode node = new ListNode(sum % 10);
        node.next = head.next;
        head.next = node;//save node
        carry = sum / 10;
    }
    return head.next;
}

private Stack<Integer> buildStack(ListNode l) {
    Stack<Integer> stack = new Stack<>();
    while (l != null) {
        stack.push(l.val);
        l = l.next;
    }
    return stack;
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    Stack<Integer> l1Stack = buildStack(l1);
    Stack<Integer> l2Stack = buildStack(l2);
    ListNode pre = null;
    int carry = 0;
    
    
    while (!l1Stack.isEmpty() || !l2Stack.isEmpty() || carry != 0){
        int sum = 0;
       int x = l1Stack.isEmpty() ? 0 : l1Stack.pop();
       int y = l2Stack.isEmpty() ? 0 : l2Stack.pop();

       sum = x + y + carry;
       carry = 0;
       carry = sum/10;
       ListNode cur = new ListNode();
       cur.val = sum % 10;

       cur.next = pre;
       pre = cur;
        
        }
        return pre;
    }
    public Stack buildStack(ListNode l) {
        Stack<Integer> stack = new Stack<>();//last in first out
        while(l != null){
            stack.push(l.val);
            l = l.next;
        }
        return stack;
    }
}
//didnt recommend, too much code, easlier to have error in interview
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    // We will use sizes to understand which list's nodes should be frozen for a while.
    int s1 = size(l1);
    int s2 = size(l2);
    ListNode resHead = null;
    ListNode n = null;
    while (l1 != null || l2 != null) {
        int v1 = 0;
        int v2 = 0;
        if (s1 >= s2) {
            v1 = l1 != null ? l1.val : 0;
            l1 = l1.next;
            s1--;
        }
        // Comparing with s1 + 1 since s1 might be decremented previously
        if (s2 >= s1 + 1) {
            v2 = l2 != null ? l2.val : 0;
            l2 = l2.next;
            s2--;
        }
        // Creating the resulting list in the reversed order.
        n = new ListNode(v1 + v2);
        n.next = resHead;
        resHead = n;
    }
    int carry = 0;
    resHead = null;
    // Now, let's perform the normalization.
    while (n != null) {
        n.val += carry;
        if (n.val >= 10) {
            n.val = n.val % 10;
            carry = 1;
        } else {
            carry = 0;
        }
        ListNode buf = n.next;
        n.next = resHead;
        resHead = n;
        n = buf;
    }
    if (carry > 0) {
        n = new ListNode(1);
        n.next = resHead;
        resHead = n;
    }
    return resHead;
}

private int size(ListNode l) {
    int s = 0;
    while (l != null) {
        l = l.next;
        s++;
    }
    return s;
}