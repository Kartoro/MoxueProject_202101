# LC 567
# 自己 以为要深度优先 抓到全部组合 然后对比
# 解题 滑动（双指针
class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        if len(s1) > len(s2):
            return False
        s1count = [0] * 26
        s2count = [0] * 26
        window = len(s1)
        left = 0
        right = 0
        for i in s1:
            s1count[ord(i)-ord('a')] += 1
        for i in range(len(s2)):
            right = i
            s2count[ord(s2[right])-ord('a')] += 1
            if right - left + 1 > window:
                s2count[ord(s2[left])-ord('a')] -= 1
                left += 1
            if s1count == s2count:
                return True
        return False
        

# LC 832
# 自己
class Solution:
    def flipAndInvertImage(self, image: List[List[int]]) -> List[List[int]]:
        
        res = []
        for i in image:
            stack = []
            for j in range(len(i)):
                temp = i[0-j-1]
                if temp == 1:
                    temp = 0
                else:
                    temp = 1
                stack.append(temp)
            res.append(stack)
        return res
# LC766
# 自己解遍历
class Solution:
    def isToeplitzMatrix(self, matrix: List[List[int]]) -> bool:
        hang = len(matrix)
        lie = len(matrix[0])
        for i in range(lie):
            h = 0
            l = i
            cur = matrix[0][l]
            while h+1 <hang and l+1 < lie:
                if matrix[h+1][l+1] != cur:
                    print(h,l)
                    return False
                else:
                    h+=1
                    l+=1
        for i in range(1,hang):
            l = 0
            h = i
            cur = matrix[h][l]
            while h+1 <hang and l+1 < lie:
                if matrix[h+1][l+1] != cur:
                    print(h,l)
                    return False
                else:
                    h+=1
                    l+=1
        return True


# LC 1052
# 自己 滑动窗口 
class Solution:
    def maxSatisfied(self, customers: List[int], grumpy: List[int], X: int) -> int:
        def countAll(c, g):
            res = 0
            for i in range(len(c)):
                if g[i] == 1:
                    res += c[i]
            return res
        lists = grumpy.copy()
        left, right = 0,0
        n =len(grumpy)
        res = 0
        for i in range(n):
            right = i
            lists[right] = 1
            if right - left + 1 > X:
                lists[left] = grumpy[left]
                left +=1
            res = max(res, countAll(customers,lists))
        return res

# LC 6
class Solution:
    def convert(self, s: str, numRows: int) -> str:
        if numRows == 1:
            return s
        resStr = ''
        resList = []
        for i in range(numRows):
            resList.append([]) 
        z = numRows * 2 - 2
        for i in range(len(s)):
            if (i) % z < numRows:
                resList[(i)%z].append(s[i])
            else:
                loc = i%z % numRows
                resList[-loc-2].append(s[i])
        for i in resList:
            resStr += ''.join(i)
        return resStr