var buildTree = function(inorder, postorder) {
    if(!inorder.length) return null
    const rootVal = postorder.pop()
    let rootIndex = inorder.indexOf(rootVal)
    const root = new TreeNode(rootVal)
    root.left = buildTree(inorder.slice(0, rootIndex), postorder.slice(0, rootIndex))
    root.right = buildTree(inorder.slice(rootIndex + 1), postorder.slice(rootIndex))
    return root;
}

var buildTree2 = function(inorder, postorder) {
    if(inorder.length === 0 || postorder.length === 0) return null
    return traversal(inorder, postorder)
};

const traversal = (inorder, postorder) => {
    if(postorder.length === 0) return null
    let rootVal = postorder[postorder.length - 1]
    let root = new TreeNode(rootVal)
    if(postorder.length === 1) return root

    let delimiterIndex = 0
    for(delimiterIndex;delimiterIndex < inorder.length;delimiterIndex++){
        if(inorder[delimiterIndex] === rootVal) break
    }

    const leftInorder = inorder.slice(0,delimiterIndex)
    const leftPostorder = postorder.slice(0,delimiterIndex)

    postorder.pop()

    const rightInorder = inorder.slice(delimiterIndex+1)
    const rightPostorder = postorder.slice(delimiterIndex)


    root.left = traversal(leftInorder,leftPostorder)
    root.right = traversal(rightInorder,rightPostorder)

    return root
}
