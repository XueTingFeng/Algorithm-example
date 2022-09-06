/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var middleNode = function(head) {
    // let length = 0
    // let temp = head
    // while(temp && temp !== null){
    //     temp = temp.next
    //     length++
    // }
    // temp = head
    // let k = 0
    // while(k<Math.trunc(length/2)){
    //     temp = temp.next
    //     k++
    // }
    // return temp

    let slow = head
    let fast = head
    while(fast && fast.next){
        slow = slow.next
        fast = fast.next.next
    }
    return slow
};