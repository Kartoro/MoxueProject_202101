public class lianbiao_92 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(4);
        node1.next.next.next.next = new ListNode(5);


        System.out.println(reverseBetween(node1, 2, 4));

    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1);


        dummyNode.next = head;
        ListNode pre = dummyNode;

        for(int i =0; i < left-1; i ++){
            pre = pre.next;
        }
        ListNode sur = pre;
        for(int j =0; j < right-left+1;j++){
            sur = sur.next;
        }

        ListNode leftNode = pre.next;
        ListNode rightNode = sur.next;

        pre.next = null;
        sur.next = null;

        reverseListNode(leftNode);
        pre.next = sur;
        leftNode.next = rightNode;
        return dummyNode.next;

    }

    public static void reverseListNode(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while(cur!= null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }


    }
}
