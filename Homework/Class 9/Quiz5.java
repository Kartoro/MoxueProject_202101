// Leetcode.92 反转链表 II

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (head.next == null || head.next.next == null && right == 1){
            return head;
        }

        int leftIndex = left - 1;
        int rightIndex = right - 1;

        ListNode dummy = new ListNode();
        dummy.next = head;

        for (int i = 0; i < leftIndex; i++){
            head = head.next;
        }

        // 对left与right区间内的链表进行反转
        ListNode pre = null;
        ListNode cur = head;

        
        for (int i = leftIndex; i <= rightIndex; i++){

            ListNode tmp = cur.next;
            cur.next = pre;

            pre = cur;
            cur = tmp;

        }

        // 将反转后的链表与区间后的链表相连
        ListNode dummyReverse = new ListNode();
        dummyReverse.next = pre;
        while (pre.next != null){
            pre = pre.next;
        }
        pre.next = cur;

        // 当反转从第1位开始, 无需考虑原先头结点
        if (left == 1){
            return dummyReverse.next;
        }

        // 与区间前的链表相连
        head = dummy.next;
        for (int j = 1; j < leftIndex; j++){
            head = head.next;
        }
        head.next = dummyReverse.next;

        return dummy.next;
    }
}