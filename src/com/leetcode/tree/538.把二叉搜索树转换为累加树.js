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
 * @return {TreeNode}
 */
var convertBST = function(root) {
    let pre = 0
    const reverseInOrder = (root) => {
        if(!root) return null
        reverseInOrder(root.right)
        root.val += pre
        pre = root.val
        reverseInOrder(root.left)
    }
    reverseInOrder(root)
    return root
};