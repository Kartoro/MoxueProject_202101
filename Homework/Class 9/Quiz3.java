// Leetcode.2 两数相加

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode l1Pointer = l1;
        ListNode l2Pointer = l2;

        int ones = 0;
        int tens = 0;

        ListNode dummy = new ListNode();
        ListNode newListNode = new ListNode();
        dummy.next = newListNode;


        while (l1Pointer != null && l2Pointer != null) {

            ListNode currentNode = new ListNode();

            ones = (l1Pointer.val + l2Pointer.val) % 10;

            int finalOnes = 0;
            int finalTens = 0;
            if (ones + tens >= 10) {
                finalOnes = (ones + tens) % 10;
                finalTens = (ones + tens) / 10;
                currentNode = new ListNode(finalOnes);
            } else {
                currentNode = new ListNode(ones + tens);
            }
            
            newListNode.next = currentNode;
            newListNode = newListNode.next;

            tens = (l1Pointer.val + l2Pointer.val) / 10 + finalTens;

            l1Pointer = l1Pointer.next;
            l2Pointer = l2Pointer.next;
        }

        if (l1Pointer != null && l2Pointer == null){
            while (l1Pointer != null) {
                ones = (l1Pointer.val + tens) % 10;

                ListNode currentNode = new ListNode(ones);

                newListNode.next = currentNode;
                newListNode = newListNode.next;

                tens = (l1Pointer.val + tens) / 10;

                l1Pointer = l1Pointer.next;
            }
        }

        if (l1Pointer == null && l2Pointer != null){
            while (l2Pointer != null) {
                ones = (l2Pointer.val + tens) % 10;

                ListNode currentNode = new ListNode(ones);

                newListNode.next = currentNode;
                newListNode = newListNode.next;

                tens = (l2Pointer.val + tens) / 10;

                l2Pointer = l2Pointer.next;
            }
        }

        if (tens > 0){
            ListNode currentNode = new ListNode(tens);
            newListNode.next = currentNode;
        }
        

        return dummy.next.next;

    }
}