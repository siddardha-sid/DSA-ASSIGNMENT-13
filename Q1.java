package problems;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Q1 {
    public static ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return null;
        }

        ListNode newHead = null;
        ListNode newTail = null;

        while (list1 != null && list2 != null) {
            ListNode newNode;
            if (list1.val >= list2.val) {
                newNode = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                newNode = new ListNode(list2.val);
                list2 = list2.next;
            }

            if (newHead == null) {
                newHead = newNode;
                newTail = newNode;
            } else {
                newTail.next = newNode;
                newTail = newNode;
            }
        }

        // If list1 has remaining nodes, add them to the new list
        while (list1 != null) {
            ListNode newNode = new ListNode(list1.val);
            list1 = list1.next;
            newTail.next = newNode;
            newTail = newNode;
        }

        // If list2 has remaining nodes, add them to the new list
        while (list2 != null) {
            ListNode newNode = new ListNode(list2.val);
            list2 = list2.next;
            newTail.next = newNode;
            newTail = newNode;
        }

        return newHead;
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
        ListNode list1 = new ListNode(5);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);
        list1.next.next.next = new ListNode(8);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(7);
        list2.next.next = new ListNode(4);
        list2.next.next.next = new ListNode(5);

        ListNode newList = merge(list1, list2);
        System.out.print("Output: ");
        printList(newList);
        // Output: 5 -> 7 -> 4 -> 8 -> null
    }
}
