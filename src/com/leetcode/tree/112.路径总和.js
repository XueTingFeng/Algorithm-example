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
 * @param {number} targetSum
 * @return {boolean}
 */
var hasPathSum = function(root, targetSum) {
    const getPathSum = (root,count) => {
        if(!root.left && !root.right && count === 0){
            return true
        }

        if(!root.left && !root.right){
            return false
        }

        if(root.left && getPathSum(root.left,count - root.left.val)){
            return true
        }
        if(root.right && getPathSum(root.right,count - root.right.val)){
            return true
        }

        return false
    }

    if(!root) return false
    return getPathSum(root,targetSum - root.val)
};

const hasPathSu2 = function(root, targetSum){
    if(!root) return false
    if(!root.left && !root.right && count === 0) return true
    return hasPathSu2(root.left,targetSum - root.val) || hasPathSu2(root.right,targetSum - root.val)
}