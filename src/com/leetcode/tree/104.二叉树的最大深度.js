//递归遍历
const maxdepth = (root) => {
    const getDepth = (node) => {
        if(node === null){
            return 0
        }

        let leftDepth = getDepth(node.left)
        let rightDepth = getDepth(node.right)

        let depth = 1 + Math.max(leftDepth,rightDepth)
        return depth
    }

    return getDepth(root)
}