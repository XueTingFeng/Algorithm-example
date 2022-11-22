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
//后序遍历，类似二叉树最大深度
const countNodes = function(root) {
    if(!root) return 0
    let leftNum = countNodes(root.left)
    let rightNum = countNodes(root.right)
    let treeNum = 1 + leftNum + rightNum
    return treeNum
};

//精简代码
const countNodes2 = function(root) {
    if(!root) return 0
    return 1 + countNodes2(root.left) + countNodes2(root.right)
};

//完全二叉树特性
const countNodes3 = function(root) {
    if(!root) return 0
    let left = root.left
    let right = root.right
    let leftDepth = 0, rightDepth = 0

    while (left){
        left = left.left
        leftDepth++
    }

    while (right){
        right = right.right
        rightDepth++
    }

    if(leftDepth === rightDepth){
        return Math.pow(2,leftDepth+1)-1
    }

    return countNodes3(root.left) + countNodes3(root.right) + 1
}