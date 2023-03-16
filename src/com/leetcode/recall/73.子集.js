/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsets = function(nums) {

    const res = []
    const path = []

    recall(nums,0)

    return res

    function recall(nums,startIndex){

        res.push([...path])

        if(startIndex >= nums.length){
            return
        }

        for(let i=startIndex;i < nums.length;i++){
            path.push(nums[i])
            recall(nums,i + 1)
            path.pop()
        }
    }
};