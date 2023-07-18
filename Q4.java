package problems;

public class Q4 {

	public static ListNode reverseAlternateKNodes(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }

        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;

        // Reverse the first k nodes
        int count = 0;
        while (count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        // Skip the next k nodes
        count = 0;
        while (count < k && current != null) {
            current = current.next;
            count++;
        }

        // Recursively reverse the next k nodes and connect it to the current group
        if (current != null) {
            head.next = reverseAlternateKNodes(current, k);
        }

        // prev will be the new head of the current group
        return prev;
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);
        list.next.next.next.next.next = new ListNode(6);
        list.next.next.next.next.next.next = new ListNode(7);
        list.next.next.next.next.next.next.next = new ListNode(8);
        list.next.next.next.next.next.next.next.next = new ListNode(9);

        int k = 3;
        ListNode newList = reverseAlternateKNodes(list, k);

        System.out.print("Output: ");
        printList(newList);
        // Output: 3 -> 2 -> 1 -> 4 -> 5 -> 6 -> 9 -> 8 -> 7 -> null
    }

}
