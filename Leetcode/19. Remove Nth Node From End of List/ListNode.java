public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode temp = head;
        while(temp!=null){
            temp = temp.next;
            size++;
        }
        if(n == size){
            head = head.next;
            return head;
        }

        int idx = 1;
        temp = head;
        while(idx < (size-n)){
            temp = temp.next;
            idx++;
        }
        temp.next = temp.next.next;
        return head;
    }
}