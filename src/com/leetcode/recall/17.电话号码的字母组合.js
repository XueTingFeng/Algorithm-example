const string = [
    [""],// 0
    [""],// 1
    ["abc"],// 2
    ["def"],// 3
    ["ghi"],// 4
    ["jkl"],// 5
    ["mno"],// 6
    ["pqrs"],// 7
    ["tuv"],// 8
    ["wxyz"],// 9
]

const letterCombinations = (digits) => {
    const k = digits.length
    const map = ["","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"]
    if(!k) return []
    if(k === 1) return map[digits].split("")

    const res = []
    const path = []
    backtracking(digits,k,0)
    return res

    function backtracking(n,k,a){
        if(path.length === k){
            res.push(path.join(""))
            return
        }
        for(const v of map[n[a]]){
            path.push(v)
            backtracking(n,k,a+1)
            path.pop()
        }
    }
}