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
 * @return {number[]}
 */
var findMode = function(root) {

    let maxCount = 0
    let count = 0
    let pre = null
    let res = []

    const searvhBST = (cur) => {
        if(!cur) return
        searvhBST(cur.left)

        if(!pre){
            count = 1
        } else if (pre.val === cur.val){
            count++
        } else {
            count = 1
        }

        pre = cur

        if(count === maxCount){
            res.push(cur.val)
        }

        if(count > maxCount){
            maxCount = count
            res = []
            res.push(cur.val)
        }

        searvhBST(cur.right)

        return res
    }

    return searvhBST(root)
};