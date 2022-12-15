/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {number[]} nums
 * @return {TreeNode}
 */
var constructMaximumBinaryTree = function(nums) {
    const node = new TreeNode()

    if (nums.length === 1) {
        node.val = nums[0]
        return node
    }

    let maxVal = 0
    let maxIdx = 0
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] > maxVal) {
            maxVal = nums[i]
            maxIdx = i
        }
    }
    node.val = maxVal

    if (maxIdx > 0) {
        const left = nums.slice(0, maxIdx)
        node.left = constructMaximumBinaryTree(left)
    }

    if (maxIdx < nums.length - 1) {
        const right = nums.slice(maxIdx + 1, nums.length)
        node.right = constructMaximumBinaryTree(right)
    }
}

//简洁代码
const constructMaximumBinaryTree2 = function(nums) {
    return buildTree(nums,0,nums.length)
}

const buildTree = (nums,left,right) => {
    if(left >= right) return null

    let maxIdx = left
    for(let i = left;i < right;i++){
        if(nums[i] >nums[maxIdx]) maxIdx = i
    }

    const root = new TreeNode(nums[maxIdx])

    root.left = buildTree(nums,left,maxIdx)
    root.right = buildTree(nums,maxIdx + 1,right)

    return root
}

