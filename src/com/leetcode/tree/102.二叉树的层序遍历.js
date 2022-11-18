const levelOrder = (root) => {
    let res = [], queue = []
    queue.push(root)
    if(root === null){
        return res
    }
    while (queue.length !== 0){
        //记录当前层级节点数
        let length = queue.length
        //存放每一层的节点
        let curLevel = []
        for(let i=0;i<length;i++){
            let node = queue.shift()
            curLevel.push(node.val)
            node.left && queue.push(node.left)
            node.right && queue.push(node.right)
        }
        res.push(curLevel)
    }
    return res
}