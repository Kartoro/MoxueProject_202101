# LC844
class Solution:
    def backspaceCompare(self, S: str, T: str) -> bool:
        sstack= []
        tstack = []
        for i in S:
            if i != '#':
                sstack.append(i)
            elif len(sstack) == 0:
                continue
            else:
                sstack.pop()

        for i in T:
            if i != '#':
                tstack.append(i)
            elif len(tstack) == 0:
                continue
            else:
                tstack.pop()

        return sstack == tstack
    
# LC1021
# 自己解 
class Solution:
    def removeOuterParentheses(self, S: str) -> str:
        q = []
        count = [0,0]
        target = ''
        for i in S:
            q.append(i)
            if i == '(':
                count[0] += 1
            else:
                count[1] += 1
            if count[0] == count[1]:
                q.pop(0)
                q.pop()

                target += ''.join(q)

                q.clear()

        return target
        
# 题解双指针
def removeOuterParentheses( S: str) -> str:
    n = len(S)
    res = ''
    left,count = 0,0
    for i in range(n):
        if S[i] == '(':
            count += 1
        else:
            count -= 1
        if count == 0:
            res += S[left+1:i]
            left = i+1
    return res
    
# LC 933
# 自己 
class RecentCounter:

    def __init__(self):
        self.requests = []
        self.n = 0
        self.help = 0

    def ping(self, t: int) -> int:        
        self.requests.append(t)
        self.n += 1
        res = 0
        for i in range(self.help, self.n):
            if  self.requests[i] >= t - 3000:
                res += 1
            else:
                self.help = i

        return res
        
# 题解 队列
class RecentCounter:

    def __init__(self):
        self.requests = []

    def ping(self, t: int) -> int:        
        self.requests.append(t)
        while self.requests[0] < t - 3000:
            self.requests.pop(0)
        return len(self.requests)
        
# LC394
# 自己想递归 没写出来
# 题解 辅助栈
def decodeString(s: str) -> str:
    stack = []
    multi = ''
    res = ''
    for i in s:
        if i.isnumeric():
            multi += i
        elif i.isalpha():
            res += i
        elif i == '[':
            stack.append([multi,res])
            multi = ''
            res = ''
        else:
            last_multi,last_res = stack.pop()
            res = last_res + res * int(last_multi)
            
    return res

# LC994
# 自己解 队列def orangesRotting(grid) -> int:
    hang = len(grid)
    lie = len(grid[0])
    good = []
    bad = []
    baded = []
    res = 0
    for i in range(hang):
        for j in range(lie):
            if grid[i][j] == 2:
                bad.append([i,j])
            elif grid[i][j] == 1:
                good.append([i,j])
            else:
                continue
    if len(good) == 0:
        return 0
    print('bad',bad)
    print('good',good)
    print('')
    while len(bad) != 0 and len(good) != 0:
        
        for i in range(len(bad)):
            cur_bad = bad.pop(0)
            will_bad = [[cur_bad[0]+1,cur_bad[1]],[cur_bad[0]-1,cur_bad[1]],
                        [cur_bad[0],cur_bad[1]+1],[cur_bad[0],cur_bad[1]-1]]
            for i in will_bad:
                if i in baded:
                    continue
                if i in good:
                    good.remove(i)
                    bad.append(i)
                    baded.append(cur_bad)
        res +=1
        print('bad',bad)
        print(res,good)
        print('')
        
    print('')
    print('good',good)
    if len(good) != 0:
        return -1
    return res
    
# LC42
# 自己 正反遍历两遍
class Solution:
    def trap(self, height: List[int]) -> int:
        stack = []
        cur_height = 0
        left = 0
        n = len(height)
        res = 0
        for i in range(n):
            if height[i] < cur_height:
                stack.append(height[i])
            else:
                res = res + cur_height * (i - left - 1)
                while len(stack) != 0 :
                    res -= stack.pop()
                cur_height = height[i]
                left = i
        
        stack = []
        cur_height = 0
        right = n-1
        while n-1 >= left:
            if height[n-1] < cur_height:
                stack.append(height[n-1])
            else:
                res = res + cur_height * (right - (n-1) - 1)
                while len(stack) != 0 :
                    res -= stack.pop()
                cur_height = height[n-1]
                right = n-1
            n -= 1
        return res
                
# LC 6
# 自己 遍历一遍 指定位置
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