function TreeNode(val, left, right) {
    this.val = (val===undefined ? 0 : val)
    this.left = (left===undefined ? null : left)
    this.right = (right===undefined ? null : right)
}

let preRes = []
const preOrder = (root) =>{
    if(root === null){
        return
    }
    preRes.push(root)
    preOrder(root.left)
    preOrder(root.right)
}

let infixRes = []
const infixOrder = (root) => {
    if(root === null){
        return
    }
    infixOrder(root.left)
    infixRes.push(root)
    infixOrder(root.right)
}

let postRes = []
const postOrder = (root) => {
    if(root === null){
        return
    }
    postOrder(root.left)
    postOrder(root.right)
    postRes.push(root)
}

//前序遍历迭代
const preorderTraversal = (root, res = []) =>{
    if(!root){
        return res
    }
    const stack = [root]
    let cur = null
    while (stack.length){
        cur = stack.pop()
        res.push(cur.val)
        cur.right && stack.push(cur.right)
        cur.left && stack.push(cur.left)
    }
    return res
}

//中序遍历迭代
const inorderTraversal = (root, res = []) => {
    const stack = []
    let cur = root
    while (stack.length || cur){
        if(cur){
            stack.push(cur)
            cur = cur.left
        } else {
            cur = stack.pop()
            res.push(cur.val)
            cur = cur.right
        }
    }
    return res
}

//后序遍历迭代
const postorderTraversal = (root) => {
    if(!root){
        return res
    }
    const stack = [root]
    let cur = null
    while (stack.length){
        cur = stack.pop()
        res.push(cur.val)
        cur.left && stack.push(cur.left)
        cur.right && stack.push(cur.right)
    }
    res.reverse()
    return res
}
