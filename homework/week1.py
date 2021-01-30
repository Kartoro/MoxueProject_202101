#q1 lc35

def recInsert(nums, target):
    if len(nums) == 0:
        return  0
    elif len(nums) == 1:
        if target > nums[0]:
            return 1
        else:
            return 0

    mid = len(nums) // 2
    if target == nums[mid]:
        return mid
    elif target > nums[mid]:
        return mid + recInsert(nums[mid:], target)
    else:
        return recInsert(nums[:mid], target)


def searchInsert(nums, target):
    return recInsert(nums,target)



#q2 lc64
import sys
max = sys.maxint

def buildNewGrid(aList):
    global max
    i = len(aList)
    j = len(aList[0])
    newList = []
    for n in range(0,i):
        sublist = [max for m in range(0, j)]
        newList.append(sublist)
    
    for myi in range(0, i):
        for myj in range(0, j):
            if myi == 0 and myj == 0:
                newList[myi][myj] = aList[myi][myj]
            elif myi == 0 and myj != 0:
                newList[myi][myj] = aList[myi][myj] + newList[myi][myj-1]
            elif myi != 0 and myj == 0:
                newList[myi][myj] = aList[myi][myj] + newList[myi-1][myj]
            else:
                newList[myi][myj] = aList[myi][myj] + min(newList[myi][myj-1],  newList[myi-1][myj])

    return newList[-1][-1]

#print(buildNewGrid([[1,3,1],[1,5,1],[4,2,1]]))

#q3 
def fixZeros(matrix):
    i = len(matrix)
    j = len(matrix[0])

    zeroIndex = []

    for m in range(0,i):
        for n in range(0,j):
            if matrix[m][n] == 0:
                zeroIndex.append([m,n])

    for zeros in zeroIndex:
        for n in range(0,j):
            matrix[zeros[0]][n] = 0
        for m in range(0,i):
            matrix[m][zeros[1]] = 0
    
    print(matrix)

'''
fixZeros([
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
])
'''
