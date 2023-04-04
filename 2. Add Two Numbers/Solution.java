class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
 
class Solution {

    //link = https://leetcode.com/problems/add-two-numbers/description/

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        //We use two ListNode pointers to sum the numbers.
        ListNode left, right;
        left = l1; right = l2;

        //Sum will be recorded in the root linked list, starting from first index.
        ListNode root = new ListNode();
        int sumValue = 0;
        int carry = 0; //When we have carry
        ListNode currentPart = root;

        while (l1 != null && l2 != null)
        {
            sumValue = l1.val + l2.val + carry;
            carry = sumValue / 10;
            sumValue %= 10;
            currentPart.next = new ListNode(sumValue);
            //Shift the pointer after each loop.
            l1 = l1.next; l2 = l2.next;
            currentPart = currentPart.next;
        }

        while (l1 != null){
            sumValue = l1.val + carry;
            carry = sumValue / 10;
            sumValue %= 10;
            currentPart.next = new ListNode(sumValue);
            currentPart = currentPart.next;
            l1 = l1.next;
        }

        while (l2 != null){
            sumValue = l2.val + carry;
            carry = sumValue / 10;
            sumValue %= 10;
            currentPart.next = new ListNode(sumValue);
            currentPart = currentPart.next;
            l2 = l2.next;
        }        
        
        //At the end of numbers if we still have a carry, then we will have another digit.
        if (carry != 0)
            currentPart.next = new ListNode(carry);

        return root.next;
    }
}