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
var isValidBST = function(root) {
    let arr = []
    const buildArr = (root) => {
        if(!root) return null
        buildArr(root.left)
        arr.push(root.val)
        buildArr(root.right)
    }
    buildArr(root)

    for(let i=1;i<arr.length;i++){
        if(arr[i - 1] >= arr[i]){
            return false
        }
    }

    return true
};