/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} val
 * @return {ListNode}
 */
var removeElements = function(head, val) {
    //迭代，虚拟头节点
    // let header = new ListNode(-1);
    // header.next = head
    // let cur = header
    // while(cur.next != null){
    //     if(cur.next.val == val){
    //         cur.next = cur.next.next
    //     } else {
    //         cur = cur.next
    //     }
    // }
    // return header.next

    //递归
    if(head === null){
        return head;
    }
    head.next = removeElements(head.next,val)
    return head.val === val ? head.next : head;
};
