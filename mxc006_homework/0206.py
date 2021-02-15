# LC643 
# 自己 暴力 超出时间
def findMaxAverage( nums, k) -> float:
    sumNums = -100000
    for i in range(len(nums)-k+1):
        tempSum = 0
        for j in range(k):
            tempSum += nums[i+j]
        if tempSum > sumNums:
            sumNums = tempSum
    return sumNums/k
        

# 解题 滑动窗口
def findMaxAverage1( nums, k) -> float:
    total = maxTotal = sum(nums[:k])
   
    for i in range(k, len(nums)):
        total = total + nums[i] - nums[i-k]
        maxTotal = max(total,maxTotal)
    return maxTotal/k

#  LC424
# 解题 没想出来 滑动窗口
def characterReplacement(s: str, k: int) -> int:
    count = [0] * 26
    n = len(s)
    change, left, right = 0, 0, 0
    
    while right < n:
        count[ord(s[right])-ord('A')] += 1
        print(count)
        change = max(change, count[ord(s[right]) - ord("A")])
        print(change)
        if right - left + 1 - change > k:
            print("")
            count[ord(s[left]) - ord("A")] -= 1
            left += 1
        right += 1

    return right - left

    
# LC1590
# 滑动窗口 暴力 遍历全部子链 超出时间
def minSubarray( nums , p: int) -> int:
    total = sum(nums)
    print('total',total)
    minSub = 1000000
    
    if total % p == 0:
        return 0
    
    left, right = 0, 0
    n = len(nums)
    for left in range(n):
        print("")
        print('left',left)
        
        right = left
        while right < n:
            print('right',right)
            
            subSum = sum(nums[left:right+1])
            print('subSum',subSum)
            if subSum == total:
                break
            print('total - subSum',total - subSum)
            if (total - subSum)% p == 0:
                if right-left+1 == 1:
                    return 1
                minSub = min(right-left+1, minSub)
            right += 1
        
    if minSub != 1000000:
        return minSub
    return -1
    