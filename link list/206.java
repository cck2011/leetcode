//iterative
public ListNode reverseList(ListNode head) {
    ListNode pre = null;
    ListNode cur = head;
    while (cur != null) {
        ListNode next = cur.next;//keep access to next node
        cur.next = pre;//node.next means that pointing the node to another node
        pre = cur;
        cur = next;
    }
    return pre;
    }
//time n
//space 1
public ListNode reverseList(ListNode head) {
    ListNode newHead = new ListNode(-1);
    while (head != null) {
        ListNode next = head.next;
        head.next = newHead.next;
        newHead.next = head;//only using newHead.next to save pre node(newHead.next is pre node)not good solution
        head = next;
    }
    return newHead.next;
}

//recursion
public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) {
        return head;
    }
    ListNode next = head.next;
    ListNode newHead = reverseList(next);//go forward in link list
    //go backward in linklist
    next.next = head;//head.next.next = head is ok too(if node.next have next that means next, if have no next that means pointing to another node)
    head.next = null;//prevent link list loop
    return newHead;//newHead was not changed
}
//https://leetcode.cn/problems/reverse-linked-list/solution/dong-hua-yan-shi-206-fan-zhuan-lian-biao-by-user74/
//time n
//space n

public static class Solution2 {
        public ListNode reverseList(ListNode head) {
            return reverse(head, null);
        }

        ListNode reverse(ListNode head, ListNode newHead) {
            if (head == null) {
                return newHead;//return the final node here
            }
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
            return reverse(head, newHead);
        }
    }
    //Time: O(n)

    //Space: O(n)