package page_01._0002_add_two_numbers;

import common.ListNode;

public class AddTwoNumbersMyElementaryMath implements AddTwoNumbers {
    // Using Elementary Math
    // Time: O(max(m, n)) ; m = length of l1, n = length of l2
    // Space: O(max(m, n)) But it is not counted as part of complexity --> O(1)
    @Override
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode resultHead = result;
        int carry = 0;
        int sum = 0;

        while(l1 != null || l2 != null || carry != 0) {
            int l1Value = (l1 != null) ? l1.val : 0;
            int l2Value = (l2 != null) ? l2.val : 0;

            sum = l1Value + l2Value + carry;

            // result.val = sum % 10; ---> Produces a leading zero
            carry = sum / 10;

            // result.next = new ListNode(); ---> Produces a leading zero
            result.next = new ListNode(sum % 10); // Fix: result.next.val = sum % 10;
            result = result.next;

            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }

        return resultHead.next;
    }

    public static void main(String[] args) {
        AddTwoNumbersMyElementaryMath addTwoNumbers = new AddTwoNumbersMyElementaryMath();

        // Example 1:
        ListNode e1l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode e1l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode result1 = addTwoNumbers.addTwoNumbers(e1l1, e1l2); // Output: [7,0,8]

        // Example 2;
        ListNode e2l1 = new ListNode(0);
        ListNode e2l2 = new ListNode(0);
        ListNode result2 = addTwoNumbers.addTwoNumbers(e2l1, e2l2); // Output: [0]

        // Example 3:
        ListNode e3l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9,
                new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode e3l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        ListNode result3 = addTwoNumbers.addTwoNumbers(e3l1, e3l2); // Output: [8,9,9,9,0,0,0,1]
        System.out.println();
    }
}
