/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
var getMinimumDifference = function(root) {
    const arr = []
    const buildArr = (root) => {
        if(!root) return null
        buildArr(root.left)
        arr.push(root.val)
        buildArr(root.right)
    }
    buildArr(root)
    if(arr.length < 2) return 0
    let res = Number.MAX_SAFE_INTEGER
    for(let i=1;i<arr.length;i++){
        res = Math.min(res,arr[i] - arr[i-1])
    }
    return res
};