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
var minDepth = function(root) {
    if(root === null){
        return 0
    }
    if(root.left === null && root.right === null){
        return 1
    }

    let minVal = Number.MAX_VALUE

    if(root.left !== null){
        minVal = Math.min(minDepth(root.left),minVal)
    }


    if(root.right !== null){
        minVal = Math.min(minDepth(root.right),minVal)
    }

    return minVal + 1
};