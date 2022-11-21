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

//递归判断是否为对称二叉树
const isSymmetric2 = (root) => {
    const compareNode = (left,right) => {
        if(left === null && right !== null || left !== null && right === null){
            return false
        } else if (left === null && right === null){
            return true
        } else if (left.val !== right.val){
            return false
        }

        let outSide = compareNode(left.left,right.right)
        let inSide = compareNode(left.right,right.left)

        return outSide && inSide
    }

    if(root === null){
        return true
    }

    return compareNode(root.left,root.right)
}