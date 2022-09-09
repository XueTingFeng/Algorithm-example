/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var detectCycle = function(head) {
    // let temp = head
    // let set = new Set()
    // while(temp !== null){
    //     if(set.has(temp)){
    //         return temp
    //     }
    //     set.add(temp)
    //     temp = temp.next
    // }
    // return null

    //快慢指针
    if(!head || !head.next) return null

    let slow = head.next,fast = head.next.next
    while(fast && fast.next && fast !==slow){
        slow = slow.next
        fast = fast.next.next
    }
    if(!fast || !fast.next ) return null
    slow = head
    while(slow !== fast){
        slow = slow.next
        fast = fast.next
    }
    return slow
};