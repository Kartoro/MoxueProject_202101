def print_sxh():
    for i in range(100,1000):
        if i == pow(i%10, 3) + pow((int(i/10))%10, 3) + pow(int(i/100), 3):
            print(i)


def majorityElement(nums):
    dic = {}
    for i in nums:
        if i in dic:
            dic[i] += 1
        else:
            dic[i] = 1
    return list(dic.keys())[list(dic.values()).index (sorted(dic.values())[-1])]


def isValid( s: str) -> bool:
    dic = {')':'(', '}':'{',']':'['}
    stack = []
    if len(s)%2 != 0:
        return False
    for i in range(0, len(s)):
        if s[i:i+1] in dic.keys():
            if len(stack)==0 or stack[-1] != dic[s[i:i+1]]:
#                 print(stack)
                return False
            else:
                stack.pop()
#                 print(stack)
        else:
            stack.append(s[i:i+1])
#             print(stack)
            
#     print(stack)
    if len(stack)==0:
        return True
    else:
        return False
    