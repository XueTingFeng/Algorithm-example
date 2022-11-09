/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    let obj = {}
    for(let i=0;i<nums.length;i++){
        let num = nums[i]
        let n = target - num
        if(num in obj){
            return [obj[num],i]
        } else {
            obj[n] = i
        }
    }
};
