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
 * @return {boolean}
 */
var isSymmetric = function(root) {
    return isMirror(root,root)
};

const isMirror = (p,q) => {

    if(p === null && q === null){
        return true
    }

    if(p === null || q === null){
        return false
    }

    return p.val === q.val && isMirror(p.left,q.right) && isMirror(p.right,q.left)
}