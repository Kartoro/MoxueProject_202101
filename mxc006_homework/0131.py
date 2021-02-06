# LC 125 
# 自己
def isPalindrome( s: str) -> bool:
    s = s.lower()
    # print(s)
    if len(s) == 0:
        return True
    if not s:
        return False

    j = len(s) - 1
    for i in range(len(s)):
        
        if not s[i].isalnum():
            i += 1
            continue
        while not s[j].isalnum():
            j -=1
#         if i == j or i > j:
#             return True 
        # print(i,j)
        # print(s[i],s[j])
        if s[i] != s[j]:
            return False
        i += 1
        j -= 1
        # print(i,j)
        if i == j or i > j:
            return True 

    return True

#LC 387

# 自己解题 暴力 遍历两遍加额外存储数组 O(n^2)
class Solution:
    def firstUniqChar(self, s: str) -> int:
        if len(s)== 1:
            return 0 
        duplicate = []
        for target in range(len(s)):
            if target == len(s) -1 and s[target] not in duplicate:
                return len(s) -1
            if s[target] in duplicate:
                continue
            for move in range(target + 1,len(s)):
                if s[target] == s[move]:
                    duplicate.append(s[target])
                    break
                elif s[target] != s[move] and s[target] not in duplicate and move == len(s)-1:
                    return target
                else:
                    continue
        return -1

# 解题 哈希表存索引 O(n)
class Solution:
    def firstUniqChar(self, s: str) -> int:
        if len(s)== 1:
                return 0 
        dic = {}
        for i in range(len(s)):
            if s[i] in dic:
                dic[s[i]] = -1
            else:
                dic[s[i]] = i
        # print(dic)
        first = len(s)
        # print(first)
        for key in dic:
            # print(key)
            # print(dic[key])
            if dic[key] < first and dic[key] != -1:
                first = dic[key]
        # print(first)
        if first == len(s):
            first = -1
        return first

# LC 17
# 自己 算是个队列
def letterCombinations(digits: str):
    dic = {'2':['a','b','c'],
          '3':['d','e','f'],
          '4':['g','h','i'],
          '5':['j','k','l'],
          '6':['m','n','o'],
          '7':['p','q','r','s'],
          '8':['t','u','v'],
          '9':['w','x','y','z'],
          }
    target = []
    if len(digits) == 0:
        return target
    for i in digits:
        if len(target) == 0:
            for j in dic[i]:
                target.append(j)
        else:
            now_target = len(target)
            for j in range(now_target):
                repeat = target.pop(0)
                for k in dic[i]:
                    target.append(repeat+k)

    return target

# LC 22 
# 暴力 每个左和右括号的左右都加一个（），判断是否符合
class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        def insert_p(l):
            final_return = []
            num_target = len(l)
            # print(l,num_target)
            for i in range(num_target):
                # print('i',i)
                now = list(l.pop(0))
                # print("now",now)
                for j in range(len(now)+1):
                    # print("j",j)
                    now.insert(j,'()')
                    targetList = now
                    # print("now",now)
                    target = ''.join(targetList)
                    now.pop(j)
                    # print("now",now)
                    # print('target',target)
                    if target not in final_return:
                        final_return.append(target)
                        # print("fr",final_return,"\d")
            return final_return
        
        target = ["()"]
        if n == 1:
            return target 
        else:
            for i in range(1,n):
                target = insert_p(target)
            return target