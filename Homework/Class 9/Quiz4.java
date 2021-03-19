// Leetcode.61 旋转链表

class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0){
            return head;
        }

        ListNode dummy = new ListNode();
        dummy.next = head;

        // count ListNode length
        int count = 0;
        while (head != null){
            count++;
            head = head.next;
            if (head.next == null){
                count++;
                head.next = dummy.next;
                break;
            }
        }

        head = dummy.next;

        // move ListNode k times
        for (int i = 0; i < count - k % count; i++){
            head = head.next;
        }

        // create the new ListNode
        ListNode newListNode = new ListNode();
        dummy.next = newListNode;
        for (int i = 0; i < count; i++){
            newListNode.next = new ListNode(head.val);
            head = head.next;
            newListNode = newListNode.next;
        }

        return dummy.next.next;
    }
}