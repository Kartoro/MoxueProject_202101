// Leetcode.2 两数相加

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        int carry = 0;

        while (l1 != null || l2 != null) {

            // 若两个链表不等长, 则短的链表用0补位
            int l1Val = l1 == null ? 0 : l1.val;
            int l2Val = l2 == null ? 0 : l2.val;

            int sum = l1Val + l2Val + carry;

            carry = sum / 10;
            int ones = sum % 10;

            curr.next = new ListNode(ones);
            curr = curr.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        //如果最后仍需进位,需在最后再进一位
        if (carry == 1){
            curr.next = new ListNode (carry);
        }

        return dummy.next;

    }
}