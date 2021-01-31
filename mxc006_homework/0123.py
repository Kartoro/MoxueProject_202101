# LC 35

# 自己
def searchInsert( nums, target: int) -> int:
	for i in range(len(nums)):
	    if nums[i] == target:
	        return i
	    elif nums[i] > target:
	        return 0
	    elif nums[i] < target:
	        if(i + 1 == len(nums)):
	            return len(nums)
	        elif(i + 1 < len(nums) and nums[i + 1] > target):
	            return i + 1

# 解析 二分查找

def searchInsert2( nums, target: int) -> int:    
    left = 0
    right = len(nums) - 1
    
    while left <= right:
        mid = int((left + right)/2)
        if (nums[mid] == target):
            return mid
        elif(nums[mid] < target):
            left = mid + 1
        else:
            right = mid - 1
            
    return left
            

# LC 64
# 没写出来 开始想用暴力 写不出来

# 看了官方解析
def minPathSum(self, grid: List[List[int]]) -> int:
    if not grid or len(grid) == 0 or len(grid[0]) == 0:
        return 0

    row = len(grid)
    column = len(grid[0])
    dp = [[0 for i in range(column)] for j in range(row)]
    dp[0][0] = grid[0][0]
    for i in range(row):
        for j in range(column):
            if i == 0 and j > 0:
                dp[0][j] = dp[0][j-1] + grid[0][j]
            
            if i > 0 and j == 0:
                dp[i][0] = dp[i-1][0] + grid[i][0]
            if i > 0 and j > 0:
                dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + grid[i][j]
                       
    return dp[-1][-1]

# 另一个解析
def minPathSum2(grid) -> int:
    if not grid or len(grid) == 0 or len(grid[0]) == 0:
        return 0
    row = len(grid)
    column = len(grid[0])
    for i in range(row):
        for j in range(column):
            if i == 0 and j > 0:
                grid[0][j] += grid[0][j-1]
                
            if i > 0 and j == 0:
                grid[i][0] += grid[i-1][0]
            if i > 0 and j > 0:
                grid[i][j] += min(grid[i-1][j], grid[i][j-1])
                           
    return grid[-1][-1]

# LC 73
# 自己的 暴力
def setZeroes( matrix) -> None:
    row = len(matrix)
    column = len(matrix[0])
    zero = []
    for i in range(row):
        for j in range(column):
            if matrix[i][j] == 0:
                zero.append((i,j))
    for i in zero:
        matrix[i[0]] = [0]*column
        for j in range(row):
            matrix[j][i[1]] = 0


