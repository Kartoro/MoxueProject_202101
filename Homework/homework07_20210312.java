// 21
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                curr.next = l1;
                l1 = l1.next;
            }else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = l1==null?l2:l1;
        return head.next;

    }
}

// 203
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode newHead=new ListNode();
        ListNode q=head,p=newHead;
        while(q!=null){
            if(q.val!=val){
                ListNode tmp=new ListNode();
                tmp.val=q.val;
                p.next=tmp;
                p=p.next;
            }
            q=q.next;
        }
        return newHead.next;
    }
}

// 2


// 61
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {

    }
}

// 92
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //先找到left的位置以及前驱和后继
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode pre=dummy;
        for(int i=1;i<left;i++)
            pre=pre.next;
        ListNode cur=pre.next;//只需要pre向后遍历，然后用pre计算出cur
        //从left之后的节点逐个插入到pre的后面
        ListNode succ;
        for(int i=left;i<right;i++){
            succ=cur.next;
            cur.next=succ.next;
            succ.next=pre.next;
            pre.next=succ;
        }
        return dummy.next;//因为head可能被反转
    }
}




