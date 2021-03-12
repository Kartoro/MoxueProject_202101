import java.util.ArrayList;
import java.util.Stack;

public class Replace {


    /**请实现一个函数，将一个字符串中的每个空格替换成“%20”。
     * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     */

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param s string字符串
     * @return string字符串
     */
    public String replaceSpace(String s) {
        // write code here
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
     */


    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> tmpStack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        while (listNode != null) {
            tmpStack.push(listNode.val);
            listNode = listNode.next;
        }

        while (!tmpStack.isEmpty()) {
            result.add(tmpStack.pop());
        }


        return result;

    }
}
