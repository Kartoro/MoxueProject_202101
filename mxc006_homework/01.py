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
    print(s.split())
    return True