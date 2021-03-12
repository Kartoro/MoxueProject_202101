# LC 21
# 自己 迭代
class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        left = l1
        right = l2
        cur = ListNode(0)
        res = cur

        while left and right:
            if left.val >= right.val:
                temp = right.next
            
                right.next = None
                cur.next = right
                cur = cur.next

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

# 题解 迭代 优化
class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        left = l1
        right = l2

        res = ListNode(0)
        cur = res
        while left and right:
            if left.val >= right.val:
                cur.next = right
                right = right.next
            else:
                cur.next = left
                left = left.next
            cur = cur.next
        
        if not left:
            cur.next = right
        elif not right:
            cur.next = left
            
        return res.next
# 题解 递归
class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        if not l1:
            return l2
        if not l2:
            return l1

        if l1.val <= l2.val:
            l1.next = self.mergeTwoLists(l1.next, l2)
            return l1
        else:
            l2.next = self.mergeTwoLists(l1, l2.next)
            return l2
