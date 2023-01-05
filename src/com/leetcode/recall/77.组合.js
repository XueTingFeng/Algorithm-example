/**
 * @param {number} n
 * @param {number} k
 * @return {number[][]}
 */
var combine = function(n, k) {
    let res = []
    let path = []
    const backtracking = (n,k,startIndex) => {
        if(path.length === k){
            res.push([...path])
            return
        }
        for(let i=startIndex;i<=n;i++){
            path.push(i)
            backtracking(n,k,i+1)
            path.pop()
        }
    }
    backtracking(n,k,1)
    return res
};

//剪枝优化
/**
 * @param {number} n
 * @param {number} k
 * @return {number[][]}
 */
var combine2 = function(n, k) {
    let res = []
    let path = []
    const backtracking = (n,k,startIndex) => {
        if(path.length === k){
            res.push([...path])
            return
        }
        for(let i=startIndex;i<=n - (k - path.length) + 1;i++){
            path.push(i)
            backtracking(n,k,i+1)
            path.pop()
        }
    }
    backtracking(n,k,1)
    return res
};