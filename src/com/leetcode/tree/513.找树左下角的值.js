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
var findBottomLeftValue = function(root) {
    //记录最大深度
    let maxDepth = 0
    //最大深度左节点的值
    let res = null

    //确定递归参数及返回值
    const dfsTree = (root,depth) => {
        //确定终止条件
        if(!root.left && !root.right){
            if(depth > maxDepth){
                maxDepth = depth
                res = root.val
            }
        }

        //单层递归逻辑
        root.left && dfsTree(root.left,depth + 1)
        root.right && dfsTree(root.right,depth + 1)
    }

    dfsTree(root,1)
    return res
};

const findBottomLeftValue2 = (root) => {
    let queue = []
    if(root === null){
        return null
    }
    queue.push(root)
    let resNode
    while (queue.length){
        let length = queue.length
        for(let i=0;i<length;i++){
            let node = queue.shift()
            if(i===0){
                resNode = node.val
            }
            node.left && queue.push(node.left)
            node.right && queue.push(node.right)
        }
    }
    return resNode
}