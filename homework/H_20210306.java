public class H_20210306 {


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    //lc 21
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null){
            if (l1 == null){
                return l2;
            }else{
                return l1;
            }
        }
        if (l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }


    }

    //lc 203
    public ListNode removeElements(ListNode head, int val) {

        ListNode aListNode = new ListNode();
        aListNode.next = head;

        ListNode preListNode = aListNode;

        while (preListNode.next != null){
            if (preListNode.next.val == val){
                preListNode.next = preListNode.next.next;
            }else {
                preListNode = preListNode.next;
            }
        }

        return aListNode.next;


    }

    //lc 2
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }else if (l2 == null){
            return l1;
        }

        ListNode pre = new ListNode(0);
        ListNode cur = pre;

        int carry = 0;
        int sum = 0;

        while (l1 != null && l2 != null){
            int a = 0;
            int b = 0;

            if (l1 != null){
                a = l1.val;
                l1 = l1.next;
            }

            if (l2 != null){
                b = l2.val;
                l2 = l2.next;
            }

            sum = a + b + carry;

            carry = sum / 10;
            sum = sum %10;


            cur.next = new ListNode(sum);
            cur = cur.next;
        }

        if (carry > 0){
            cur.next = new ListNode(carry);
        }

        return cur.next;
    }

    //lc 61
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0){
            return head;
        }

        ListNode tmp = head;

        int length = 1;

        while (tmp.next != null){
            tmp = tmp.next;
            length++;
        }

        tmp.next = head;
        ListNode tail = head;

        for (int i = 1; i < length-k%length; i++){
            tail = tail.next;
        }

        head = tail.next;
        tail.next = null;

        return head;
    }

    //lc 92
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode virtualNode = new ListNode(-1);
        virtualNode.next = head;

        ListNode pre = virtualNode;
        for (int i = 0; i < left -1; i++){
            pre = pre.next;
        }

        ListNode rightNode = pre;
        for (int j = 0; j < right - left + 1; j++){
            rightNode = rightNode.next;
        }

        ListNode leftNode = pre.next;
        ListNode current = rightNode.next;

        pre.next = null;
        rightNode.next = null;

        reverseNode(leftNode);

        pre.next = rightNode;
        leftNode.next = current;
        return virtualNode;


    }

    public void reverseNode(ListNode head){
        ListNode pre = null;
        ListNode current = head;

        while (current != null){
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
    }


    //剑指offer 52
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
    }

    

    



}
