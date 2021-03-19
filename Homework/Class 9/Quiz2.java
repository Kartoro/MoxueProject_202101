// Leetcode.203 移除链表元素

class Solution {
    public ListNode removeElements(ListNode head, int val) {

        ListNode slow = new ListNode();
        slow.next = head;

        ListNode dummy = new ListNode(0, slow);

        while (head != null) {

            if (head.val == val){
                slow.next = head.next;
                head = head.next;
            } else {
                head = head.next;
                slow = slow.next;
            }

        }

        return dummy.next.next;

    }
}