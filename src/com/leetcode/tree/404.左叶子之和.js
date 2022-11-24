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
var sumOfLeftLeaves = function(root) {
    const nodesSum = (node) => {
        if(node === null){
            return 0
        }
        let leftVal = nodesSum(node.left)
        let rightVal = nodesSum(node.right)

        let midVal = 0
        if(node.left && node.left.left === null && node.left.right === null){
            midVal = node.left.val
        }
        let sum = midVal + leftVal + rightVal
        return sum
    }
    return nodesSum(root)
};

//层序遍历
const sumOfLeftLeaves2 = (root) => {
    if(root === null){
        return null
    }
    let queue = []
    let sum = 0
    queue.push(root)
    while (queue.length){
        let node = queue.shift()
        if(node.left && node.left.left === null && node.left.right === null){
            sum += node.left.val
        }
        node.left && queue.push(node.left)
        node.right && queue.push(node.right)
    }
    return sum
}