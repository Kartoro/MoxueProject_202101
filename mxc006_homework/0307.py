# LC 21
class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        left = l1
        right = l2
        cur = ListNode(0)
        res = cur

        while left and right:
            if left.val >= right.val:
                temp = right.next
                print('temp', temp)
                right.next = None
                cur.next = right
                cur = cur.next
                print('res', res)
                right = temp
            else:
                temp = left.next
                left.next = None
                cur.next = left
                cur = cur.next
                left = temp
        
        if not left:
            cur.next = right
        elif not right:
            cur.next = left
            
        return res.next