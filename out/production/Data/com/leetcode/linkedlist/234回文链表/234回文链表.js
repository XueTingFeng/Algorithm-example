
 // Definition for singly-linked list.
  function ListNode(val, next) {
      this.val = (val===undefined ? 0 : val)
      this.next = (next===undefined ? null : next)
  }

/**
 * @param {ListNode} head
 * @return {boolean}
 */
var isPalindrome = function(head) {
    // let arr = []
    // while(head !== null){
    //     arr.push(head.val)
    //     head = head.next
    // }
    // for(let i=0,j=arr.length-1;i<j;i++,j--){
    //     if(arr[i] !== arr[j]){
    //         return false
    //     }
    // }
    // return true

    let slow = fast = head
    let prev

    while(fast && fast.next){
        fast = fast.next.next

        let next = slow.next
        slow.next = prev
        prev = slow
        slow = next // slow = slow.next
    }

    // 21321
    // slow在中间
    if(fast){
        slow = slow.next  //奇数个节点
    }
    while(prev && slow){
        if(prev.val!==slow.val){
            return false
        }
        prev = prev.next
        slow = slow.next
    }
    return true
};

 let head4 =new ListNode(1)
 let head3 =new ListNode(2,head4)
 let head2 =new ListNode(2,head3)
 let head = new ListNode(1,head2)




 let res = isPalindrome(head)
 console.log(res)