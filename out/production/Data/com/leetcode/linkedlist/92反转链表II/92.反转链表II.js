/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} left
 * @param {number} right
 * @return {ListNode}
 */
var reverseBetween = function(head, left, right) {
    const newHead = new ListNode(-1)
    newHead.next = head

    let pre = newHead
    for(let i=0;i<left-1;i++){
        pre = pre.next
    }

    let rightNode = pre
    for(let i=0;i<right-left+1;i++){
        rightNode = rightNode.next
    }

    let leftNode = pre.next
    let nextNode = rightNode.next

    pre.next = null
    rightNode.next = null

    reverseLinkedList(leftNode)

    pre.next = rightNode
    leftNode.next = nextNode

    return newHead.next
};

const reverseLinkedList = (head) => {
    let pre = null
    let cur = head

    while(cur !== null){
        const next = cur.next
        cur.next = pre
        pre = cur
        cur = next
    }
}
