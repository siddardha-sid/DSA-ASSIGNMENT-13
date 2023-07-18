package problems;

public class Q5 {

	 public static ListNode deleteLastOccurrence(ListNode head, int key) {
	        if (head == null) {
	            return null;
	        }

	        ListNode lastOccurrence = null;
	        ListNode prev = null;
	        ListNode current = head;
	        ListNode prevLastOccurrence = null;

	        while (current != null) {
	            if (current.val == key) {
	                prevLastOccurrence = prev;
	                lastOccurrence = current;
	            }
	            prev = current;
	            current = current.next;
	        }

	        // If lastOccurrence is null, key not found, return head
	        if (lastOccurrence == null) {
	            return head;
	        }

	        // If lastOccurrence is head, update head
	        if (lastOccurrence == head) {
	            head = head.next;
	        } else {
	            prevLastOccurrence.next = lastOccurrence.next;
	        }

	        return head;
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
	        list.next.next.next = new ListNode(5);
	        list.next.next.next.next = new ListNode(2);
	        list.next.next.next.next.next = new ListNode(10);

	        int key = 2;
	        ListNode newList = deleteLastOccurrence(list, key);

	        System.out.print("Output: ");
	        printList(newList);
	        // Output: 1 -> 2 -> 3 -> 5 -> 10 -> null
	    }

}
