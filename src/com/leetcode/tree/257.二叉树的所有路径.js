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
 * @return {string[]}
 */
var binaryTreePaths = function(root) {
    let res = []
    const traversal = (cur,curPath) => {
        if(cur.left === null && cur.right === null){
            curPath += cur.val
            res.push(curPath)
            return
        }
        curPath+=cur.val+'->'
        if(cur.left){
            traversal(cur.left,curPath)
        }
        if(cur.right){
            traversal(cur.right,curPath)
        }
    }
    traversal(root,'')
    return res
};