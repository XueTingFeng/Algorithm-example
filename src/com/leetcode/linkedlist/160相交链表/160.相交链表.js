/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

/**
 * @param {ListNode} headA
 * @param {ListNode} headB
 * @return {ListNode}
 */
var getIntersectionNode = function(headA, headB) {
    // let set = new Set()
    // let temp = headA
    //
    // while(temp !== null){
    //     set.add(temp)
    //     temp = temp.next
    // }
    //
    // temp = headB
    // while(temp !== null){
    //     if(set.has(temp)){
    //         return temp
    //     }
    //     temp = temp.next
    // }
    // return null

    //双指针 查看最后一个节点是否相同
    if(headA === null && headB === null){
        return null
    }

    let pA = headA,pB = headB

    while(pA !== pB){
        pA = pA === null ? headB : pA.next
        pB = pB === null ? headA : pB.next
    }
    return pA
};