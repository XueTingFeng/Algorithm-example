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

const maxdepth2 = (root) => {
    let queue = []
    let count = 0
    queue.push(root)
    if(root === null){
        return 0
    }
    while (queue.length !== 0){
        //记录当前层级节点数
        let length = queue.length
        //存放每一层的节点
        count ++
        for(let i=0;i<length;i++) {
            let node = queue.shift()
            for (let item of node.children) {
                item && queue.push(item);
            }
        }
    }
    return count
}

//559 n叉树的最大深度
const maxdepth2 = (root) => {
    if(!root) return 0
    let depth = 0
    for(let node of root.children){
        depth = Math.max(depth,maxdepth2(node))
    }
    return depth + 1
}

const maxdepth3 = (root) => {
    let queue = []
    let count = 0
    queue.push(root)
    if(root === null){
        return 0
    }
    while (queue.length !== 0){
        //记录当前层级节点数
        let length = queue.length
        //存放每一层的节点
        count ++
        for(let i=0;i<length;i++) {
            let node = queue.shift()
            for (let item of node.children) {
                item && queue.push(item);
            }
        }
    }
    return count
}