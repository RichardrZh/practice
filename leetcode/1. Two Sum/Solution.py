class Solution:
    
    # Returns the indicies of two distinct numbers in nums[] that add up to target
    # assumes a solution exists
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        
        # init store: a map of previously accessed numbers (of nums[])
        store = {}
        
        # for each number (nums[i]) in nums[] check if it's complement (target-nums[i]) exists in the store
        for i in range(len(nums)):
            
            # if the complement exists, return num[i] and the complement
            if target-nums[i] in store:
                return [i, store[target-nums[i]]] 
            
            # else add num[i] to the store
            store[nums[i]] = i
        
        # if no solution exists, return empty list
        # should never get here if assumption is met (that a sol exists)
        return []