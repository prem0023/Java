class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        ptr=0
        summ=0
        ans=nums[0]
        while(ptr<len(nums)):
            if summ+nums[ptr]<=0:
                summ=0
                ans=max(ans,nums[ptr])
            else:
                summ+=nums[ptr]
                ans=max(ans,summ)
            ptr+=1
        return ans
        