## q1
def flower(num):
    tempNum = num
    sum = 0
    while tempNum / 10 != 0:
        digit = (tempNum % 10)
        sum += (digit**3)
        tempNum = tempNum / 10
    sum += tempNum ** 3
    return num == sum    

#print(flower(153))

##q2
l = [3,2,3]
def majorityElement(ls):
    majority = len(ls) // 2
    maxindex = 0

    dic = {}
    for num in ls:
        if num in dic.keys():
            dic[num] += 1
        else:
            dic[num] = 1

    for k in dic.keys():
        if dic[k] >= majority:
            majority = dic[k]
            maxindex = k

    return k

#print(majorityElement(l))

##q3
def correctPar(myString):
    #dic = {'(':')', '{':'}', '[':']'}
    dic = {')':'(', '}':'{', ']':'['}
    stack = []

    for char in myString:
        if char not in dic.keys():
            stack.append(char)
        else:
            last = stack[-1]
            if dic[char] == last:
                stack.pop(-1)
    
    return len(stack) == 0

#print(correctPar('([)]'))
#print(correctPar('()[]{}'))

#4 greedy
nums = [3,30,34,5,9]
#nums = [91,93,92]
def greedyIndex(ls):
    tempLs = []
    maxindex = 0
    maxFirstDight = 0
    max = 0
    index = 0
    for num in ls:
        firstDigit = int(str(num)[0])
        if firstDigit > maxFirstDight:
            maxindex = index
            maxFirstDight = firstDigit
            max = num
        elif firstDigit == maxFirstDight:
            if num > max:
                maxindex = index
                maxFirstDight = firstDigit
                max = num
        index += 1
    
    return maxindex

print(greedyIndex(nums))

def maxNumber(ls):
    listLen = len(ls)
    tempLs = ls
    i = 0
    finalString = ''
    while i < listLen:
        index = greedyIndex(tempLs)
        finalString += str(ls[index])
        tempLs[index] = 0
        i += 1
    return finalString


##4 cus sort 
    
class Mysort(str):
    def __lt__(self,a):
        return self + a > a + self

def maxNumber2(numlist):
    strlist = []
    for num in numlist:
        strlist.append(str(num))
    strlist.sort(key=Mysort)
    finalString = ''
    for s in strlist:
        finalString += s
    return finalString

print(maxNumber2(nums))