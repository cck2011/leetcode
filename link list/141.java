public boolean hasCycle(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {//need fast.next != null for defining fast = fast.next.next, prevent error:java.lang.NullPointerException: Cannot read field "next" because "<local2>.next" is null
                fast = fast.next.next;//need to step forward then compare as the first one is always the same.
                slow = slow.next;
                if (fast == slow) {
                    return true;
                }
            }
            return false;
        }
    //if the link list have a cycle then fast will go back to previous node and compare fast and slow one by one. If fast and slow is the same then there must have cycle.


    public static class Solution1 {
        public boolean hasCycle(ListNode head) {
            Set<ListNode> set = new HashSet();
            while (head != null) {
                if (!set.add(head)) {//hashset.add return false when there are a same value in it.
                    return true;
                }
                head = head.next;
            }
            return false;
        }
    }