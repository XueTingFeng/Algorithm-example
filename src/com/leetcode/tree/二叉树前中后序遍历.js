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
    postRes.push(post)
}