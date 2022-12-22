/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */

/**
 * @param {TreeNode} root
 * @param {TreeNode} p
 * @param {TreeNode} q
 * @return {TreeNode}
 */
var lowestCommonAncestor = function(root, p, q) {
    // if(root === null) return root
    // if(root.val > p.val && root.val > q.val){
    //     const left = lowestCommonAncestor(root.left,p,q)
    //     if(left !== null){
    //         return left
    //     }
    // }
    // if(root.val < p.val && root.val < q.val){
    //     const right = lowestCommonAncestor(root.right,p,q)
    //     if(right !== null){
    //         return right
    //     }
    // }
    // return root

    if(root.val > p.val && root.val > q.val){
        return lowestCommonAncestor(root.left,p,q)
    } else if (root.val < p.val && root.val < q.val){
        return lowestCommonAncestor(root.right,p,q)
    } else {
        return root
    }
};