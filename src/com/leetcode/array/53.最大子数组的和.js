/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

 子数组 是数组中的一个连续部分。
 *
 * @param {number[]} nums
 * @return {number}
 */
var maxSubArray = function(nums) {
    const len = nums.length
    const dp = new Array(len)
    dp[0] = nums[0]

    for(let i=1;i<len;i++){
        if(dp[i-1] > 0){
            dp[i] = dp[i-1] + nums[i]
        } else {
            dp[i] = nums[i]
        }
    }

    let res = dp[0]
    for(let i=1;i<len;i++){
        res = Math.max(res,dp[i])
    }

    return res
};

// /**
//  * @param {number[]} nums
//  * @return {number}
//  */
// var maxSubArray = function(nums) {
//     let pre = 0,maxNum = nums[0]
//     nums.forEach(num => {
//         pre = Math.max(pre + num, num)
//         maxNum = Math.max(maxNum,pre)
//     })
//     return maxNum
// };