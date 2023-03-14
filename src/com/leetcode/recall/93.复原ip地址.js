/**
 * @param {string} s
 * @return {string[]}
 */
var restoreIpAddresses = function(s) {

    const res = [] , path = []

    recall(0)
    
    return res

    function recall(i){
        const len = path.length

        if(len > 4) return
        if(len === 4 && i === s.length){
            res.push(path.join("."))
            return
        }

        for(let j=i;j<s.length;j++){
            const str = s.slice(i,j + 1)
            if(str.length > 3 || +str > 255) break
            if(str.length > 1 && str[0] === "0") break
            path.push(str)
            recall(j + 1)
            path.pop()
        }
    }
};