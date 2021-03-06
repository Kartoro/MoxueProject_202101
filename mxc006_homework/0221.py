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
    
