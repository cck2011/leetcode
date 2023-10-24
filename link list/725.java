public ListNode[] splitListToParts(ListNode root, int k) {
    int N = 0;
    ListNode cur = root;
    while (cur != null) {
        N++;
        cur = cur.next;
    }
    int mod = N % k;
    int size = N / k;
    ListNode[] ret = new ListNode[k];
    cur = root;
    for (int i = 0; cur != null && i < k; i++) {
        ret[i] = cur;
        int curSize = size + (mod-- > 0 ? 1 : 0);
        for (int j = 0; j < curSize - 1; j++) {
            cur = cur.next;
        }
        ListNode next = cur.next;
        cur.next = null;
        cur = next;
    }
    return ret;
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int length = length(head);
        ListNode[] nodes = new ListNode[k];
        nodes[0] = head;
        int q = length / k;
        int r = length % k;
        recursion(head,1,r,q,nodes,1);
        return   nodes;
    }
    private int length(ListNode head){
        if(head==null) return 0;
        else return 1 + length(head.next);
    }
    private void recursion(ListNode node ,int i, int r,int q, ListNode[] nodes,int index){
        if(index>=nodes.length || node==null) return;
        if(q==0 || i%q==0){
            if(q==0){
                ListNode temp = node.next;
                node.next = null;
                nodes[index] = temp;
                recursion(temp,1,r-1,q,nodes,index+1);   
            }
            else if(r==0){
                ListNode temp = node.next;
                node.next = null;
                nodes[index] = temp;
                recursion(temp,1,r,q,nodes,index+1);   
            }
            else if(r>0){
                ListNode temp = node.next.next;
                node.next.next = null;
                nodes[index] = temp;
                recursion(temp,1,r-1,q,nodes,index+1);     
            }
        }else{
             recursion(node.next,i+1,r,q,nodes,index);   
        }
    } 
}

class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode cur = root;
        int N = 0;
        while (cur != null) {
            cur = cur.next;
            N++;
        }

        int width = N / k, rem = N % k;

        ListNode[] ans = new ListNode[k];
        cur = root;
        for (int i = 0; i < k; ++i) {
            ListNode head = new ListNode(0), write = head;
            for (int j = 0; j < width + (i < rem ? 1 : 0); ++j) {
                write = write.next = new ListNode(cur.val);
                if (cur != null) cur = cur.next;
            }
            ans[i] = head.next;
        }
        return ans;
    }
}

class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode cur = root;
        int N = 0;
        while (cur != null) {
            cur = cur.next;
            N++;
        }

        int width = N / k, rem = N % k;

        ListNode[] ans = new ListNode[k];
        cur = root;
        for (int i = 0; i < k; ++i) {
            ListNode head = cur;
            for (int j = 0; j < width + (i < rem ? 1 : 0) - 1; ++j) {//need to -1 because the the starting node is counted inside 
                if (cur != null) cur = cur.next;
            }
            if (cur != null) {
                ListNode prev = cur;
                cur = cur.next;
                prev.next = null;
            }
            ans[i] = head;
        }
        return ans;
    }
}