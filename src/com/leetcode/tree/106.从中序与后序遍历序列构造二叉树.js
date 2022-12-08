var buildTree = function(inorder, postorder) {
    if(!inorder.length) return null
    const rootVal = postorder.pop()
    let rootIndex = inorder.indexOf(rootVal)
    const root = new TreeNode(rootVal)
    root.left = buildTree(inorder.slice(0, rootIndex), postorder.slice(0, rootIndex))
    root.right = buildTree(inorder.slice(rootIndex + 1), postorder.slice(rootIndex))
    return root;
}
