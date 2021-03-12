class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class lianbiao_21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(-1);
        ListNode head = prev;
        while(l1 != null && l2 !=null){
            if(l1.val <= l2.val){
                prev.next = l1;
                l1 = l1.next;
            }else if(l1.val > l2.val){
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        if(l1 != null){
            prev.next = l1;
        }
        if(l2 != null){
            prev.next = l2;
        }
        return head.next;
    }
}
