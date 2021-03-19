// Leetcode.21 合并两个有序链表

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode pre = null;

        // 通过反转链表的方式组成新链表
        while (cur1 != null && cur2 != null) {

            if (cur1.val > cur2.val) {

                ListNode tmp = cur2.next;
                cur2.next = pre;

                pre = cur2;
                cur2 = tmp;


            } else if (cur1.val <= cur2.val) {

                ListNode tmp = cur1.next;
                cur1.next = pre;

                pre = cur1;
                cur1 = tmp;

            }
        }
        
        // 当l1, l2其中之一走到底后，只遍历另外一个链表
        if (cur1 == null) {
            while (cur2 != null){
                ListNode tmp = cur2.next;
                cur2.next = pre;

                pre = cur2;
                cur2 = tmp;
            }

        } else if (cur2 == null){
            while (cur1 != null){
                ListNode tmp = cur1.next;
                cur1.next = pre;

                pre = cur1;
                cur1 = tmp;
            }
        }


        // 二次反转链表
        ListNode previous = null;
        ListNode current = pre;
    
        while (current != null){

            ListNode tmp = current.next;
            current.next = previous;

            previous = current;
            current = tmp;

        }

        return previous;
    }
}