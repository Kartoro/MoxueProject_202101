import java.util.Stack;


public class lianbiao_2{
    public static  void main(String[] args){


    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummyNode = new ListNode(0);
        ListNode ans = dummyNode;
        int flag = 0;
        while(l1 != null || l2 != null){
            if(l1 != null && l2 != null){

                ans.val = (l1.val +l2.val+flag)%10;
                flag = (l1.val +l2.val +flag) >=10 ? 1 :0;

                l1 = l1.next;
                l2 = l2.next;
            } else  if(l1 ==null && l2 != null){

                ans.val = (l2.val + flag)%10;
                flag = (l2.val + flag) >= 10 ? 1:0;
                l2 = l2.next;

            } else  if(l2 ==null && l1 != null){

                ans.val = (l1.val + flag)%10;
                flag = (l1.val + flag) >= 10 ? 1:0;
                l1 = l1.next;

            }
            if(l1 == null && l2 == null){
                if(flag == 1){
                    ans.next = new ListNode(1);
                    ans = ans.next;
                }
                return dummyNode;
            }
            ans.next = new ListNode();
            ans = ans.next;
        }

        return dummyNode;
    }
}
