public class lianbiao_61 {

    public ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return head;
        }
        int len = 1;
        ListNode dummyNode = new ListNode(-1);

        ListNode fast = head;
        ListNode slow = head;

        while(fast.next !=null){
            len++;
            fast = fast.next;
        }
        fast.next = slow;
        int step = len-k%len;
        while(step-- >1){

            slow = slow.next;

        }
        dummyNode.next = slow.next;
        slow.next = null;
        return dummyNode.next;
    }
}
