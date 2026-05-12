class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode temp = head;
        ListNode newHead = head.next;
        ListNode prev = null;

        while(temp != null && temp.next != null){
            ListNode tTemp = temp.next;
            temp.next = tTemp.next;
            tTemp.next = temp;
            if(prev != null){
                prev.next = tTemp;
            }
            prev = temp;
            temp = temp.next;
        }
        return newHead;
    }
}