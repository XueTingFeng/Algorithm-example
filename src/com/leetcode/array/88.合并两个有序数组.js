/**
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */
var merge = function(nums1, m, nums2, n) {
    // nums1.splice(m, nums1.length - m, ...nums2);
    // nums1.sort((a, b) => a - b);

    let i = 0, j = 0
    const tempArr = new Array(m + n).fill(0)
    let cur = 0

    while(i < m || j < n){
        if(i === m){
            cur = nums2[j++]
        }else if(j === n){
            cur = nums1[i++]
        }else if(nums1[i] < nums2[j]){
            cur = nums1[i++]
        }else{
            cur = nums2[j++]
        }
        tempArr[i + j - 1] = cur
    }

    for(let i=0;i < tempArr.length;i++){
        nums1[i] = tempArr[i]
    }
    return nums1
};
