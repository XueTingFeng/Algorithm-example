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
 * @param {number} targetSum
 * @return {boolean}
 */
var hasPathSum = function(root, targetSum) {
    const getPathSum = (root,count) => {
        if(!root.left && !root.right && count === 0){
            return true
        }

        if(!root.left && !root.right){
            return false
        }

        if(root.left && getPathSum(root.left,count - root.left.val)){
            return true
        }
        if(root.right && getPathSum(root.right,count - root.right.val)){
            return true
        }

        return false
    }

    if(!root) return false
    return getPathSum(root,targetSum - root.val)
};

const hasPathSu2 = function(root, targetSum){
    if(!root) return false
    if(!root.left && !root.right && count === 0) return true
    return hasPathSu2(root.left,targetSum - root.val) || hasPathSu2(root.right,targetSum - root.val)
}

//113.路径总和ii
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
 * @param {number} targetSum
 * @return {number[][]}
 */
let pathSum = function (root,targetSum){
    const res = []
    const travelsal = (node,cnt,path) => {
        if(!node.left && !node.right && cnt === 0){
            res.push([...path])
            return
        }
        if(!node.left && !node.right) return

        if(node.left){
            path.push(node.left.val)
            travelsal(node.left,cnt - node.left.val, path)
            path.pop()
        }

        if(node.right){
            path.push(node.right.val)
            travelsal(node.right,cnt - node.right.val, path)
            path.pop()
        }
    }

    if(!root) return res
    travelsal(root, targetSum - root.val, [root.val])
    return res
}

//精简版本
const pathsum2 = function(root, targetSum){
    let res = [],curPath = []
    const travelTree = function(node,count){
        curPath.push(node.val)
        count -= node.val
        if(!node.left && !node.right && count === 0){
            res.push([...curPath])
        }
        node.left && travelTree(node.left,count)
        node.right && travelTree(node.right,count)
        let cur = curPath.pop()
        count -= cur
    }

    if(root===null){
        return res;
    }
    travelTree(root,targetSum);
    return res;
}