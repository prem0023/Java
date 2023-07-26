/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    for(x in nums){
        let sum = nums[x];
        for(y in nums){
            if(x !== y && nums[x] + nums[y] === target){
                return [x, y];
            }
        }
    }
};