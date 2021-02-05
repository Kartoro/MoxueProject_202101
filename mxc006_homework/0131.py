# LC 125 
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