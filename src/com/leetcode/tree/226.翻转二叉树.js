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
 * @return {TreeNode}
 */
var invertTree = function(root) {
    if(root === null){
        return null
    }

    const left = invertTree(root.left)
    const right = invertTree(root.right)

    root.left = right
    root.right = left

    return root

};

//交换节点
const invertNode = (root,left,right) =>{
    let temp = left
    left = right
    right = temp
    root.left = left
    root.right = right
}
//前序遍历迭代
const invertTree2 = function(root) {
    let stack = []
    if(root === null){
        return root
    }
    stack.push(root)
    while (stack.length){
        let node = stack.pop()
        if(node !== null){
            node.right && stack.push(node.right)
            node.left && stack.push(node.left)
            stack.push(node)
            stack.push(null)
        } else {
            node = stack.pop()
            invertNode(node,node.left,node.right)
        }
    }

    return root
};

//层序遍历
const invertTree3 = (root) => {
    let queue = []
    if(root === null){
        return root
    }
    queue.push(root)
    while (queue.length){
        let length = queue.length
        while (length--){
            let node = queue.shift()
            invertNode(node,node.left,node.right)
            node.left && queue.push(node.left)
            node.right && queue.push(node.right)
        }
    }
    return root
}