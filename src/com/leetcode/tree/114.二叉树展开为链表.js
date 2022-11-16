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
 * @return {void} Do not return anything, modify root in-place instead.
 */
const flatten = function(root) {
    const list = []
    preorderTraversal(root,list)
    const size = list.length
    for(let i = 1; i < size; i++){
        const pre = list[i-1]
        const cur = list[i]
        pre.left = null
        pre.right = cur
    }
};

const preorderTraversal = function(root,list) {
    if(root === null){
        return
    }
    list.push(root)
    preorderTraversal(root.left,list)
    preorderTraversal(root.right,list)

};