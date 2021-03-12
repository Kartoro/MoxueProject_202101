
public class Lianbiao_203 {
 
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        if(head == null) return head;
        ListNode pre = dummyNode;
        ListNode cur = head;
        while(cur !=null){
            if(cur.val == val){
                pre.next = cur.next;

            }else{
                pre = cur;
            }

            cur = cur.next;
        }
        return dummyNode.next;
    }
}
