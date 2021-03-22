// Leetcode.92 反转链表II

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        int leftIndex = left - 1;
        int rightIndex = right - 1;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;

        for (int i = 0; i < leftIndex; i++){
            pre = pre.next;
        }

        ListNode cur = pre.next;

        for (int i = leftIndex; i < rightIndex; i++) {
            ListNode tmp = cur.next;
            cur.next = tmp.next;
            
            tmp.next = pre.next;
            pre.next = tmp;
        }

        return dummy.next;

    }
}