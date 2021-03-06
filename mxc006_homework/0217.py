# LC155
class MinStack:

    def __init__(self):
        self.stack = []
        self.minStack = []
        self.minNum = 0


    def push(self, x: int) -> None:
        if len(self.stack) == 0:
            self.minNum = x
        else:
            self.minNum = min(x, self.minNum)

        self.stack.append(x)
        self.minStack.append(self.minNum)
 
    def pop(self) -> None:
        self.stack.pop()
        self.minStack.pop()


    def top(self) -> int:
        
        return self.stack.pop()
    def getMin(self) -> int:
        return self.minStack[-1]
        
# LC232 没想明白两个栈是啥意思 看解题原来是要捯饬
class MyQueue:

    def __init__(self):
        self.stack = []
        self.help = []


    def push(self, x: int) -> None:
        self.stack.append(x)


    def pop(self) -> int:
        for i in range(len(self.stack)):
            self.help.append(self.stack.pop())
        target = self.help.pop()
        for i in range(len(self.help)):
            self.stack.append(self.help.pop())

        return target

    def peek(self) -> int:
        for i in range(len(self.stack)):
            self.help.append(self.stack.pop())
        target = self.help[-1]
        for i in range(len(self.help)):
            self.stack.append(self.help.pop())

        return target

    def empty(self) -> bool:
        if len(self.stack) == 0:
            return True
        else:
            return False

# LC503
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        n = len(nums)
        stack = []
        target = [0] * n
        i = 2*n -1
        while i >= 0:

            while len(stack) != 0 and nums[i%n] >= stack[-1]:
                stack.pop()

            if len(stack) == 0:
                target[i%n] = -1
            else:
                target[i%n] = stack[-1]
            stack.append(nums[i%n])
            i -= 1
        return target