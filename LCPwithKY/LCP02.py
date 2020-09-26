from typing import List


class Solution:
    def isMagic(self, target: List[int]) -> bool:
        nums = [i + 1 for i in range(len(target))]
        for k in range(1, len(target)):
            pre, post = [], nums
            while(target[:len(pre)] == pre):
                if post == []:
                    return True
                post = post[1::2] + post[0::2]
                pre, post = pre + post[:k], post[k:]

        return False

if __name__ == "__main__":
    LCP02 = Solution()
    print(LCP02.isMagic([2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,42,44,46,48,50,52,54,56,58,60,62,64,66,68,1,3,5,7,9,11,13,15,17,19,21,23,25,27,29,31,33,35,37,39,41,43,45,47,49,51,55,59,63,67,53,57,61,65,69]))