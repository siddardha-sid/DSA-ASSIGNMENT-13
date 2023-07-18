package problems;

class ListNode1 {
    int val;
    ListNode1 next;

    ListNode1(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Q2 {
    public static ListNode1 removeDuplicates(ListNode1 list) {
        if (list == null || list.next == null) {
            return list;
        }

        ListNode1 current = list;

        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return list;
    }

    public static void printList(ListNode1 newList) {
        ListNode1 current = newList;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode1 list = new ListNode1(11);
        list.next = new ListNode1(11);
        list.next.next = new ListNode1(11);
        list.next.next.next = new ListNode1(21);
        list.next.next.next.next = new ListNode1(43);
        list.next.next.next.next.next = new ListNode1(43);
        list.next.next.next.next.next.next = new ListNode1(60);

        ListNode1 newList = removeDuplicates(list);
        System.out.print("Output: ");
        printList(newList);
        // Output: 11 -> 21 -> 43 -> 60 -> null
    }
}
