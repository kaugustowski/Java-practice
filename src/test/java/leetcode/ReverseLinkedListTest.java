package leetcode;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class ReverseLinkedListTest {
    private final ReverseLinkedList solution = new ReverseLinkedList();

    @Test
    void testReverseList_EmptyList() {
        assertThat(solution.reverseList(null)).isNull();
    }

    @Test
    void testReverseList_SingleNode() {
        ListNode head = new ListNode(1);
        ListNode result = solution.reverseList(head);
        assertThat(result.val).isEqualTo(1);
        assertThat(result.next).isNull();
    }

    @Test
    void testReverseList_MultipleNodes() {
        // Create list: 1->2->3->4->5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Reverse the list
        ListNode result = solution.reverseList(head);

        // Verify the reversed list: 5->4->3->2->1
        assertThat(result.val).isEqualTo(5);
        assertThat(result.next.val).isEqualTo(4);
        assertThat(result.next.next.val).isEqualTo(3);
        assertThat(result.next.next.next.val).isEqualTo(2);
        assertThat(result.next.next.next.next.val).isEqualTo(1);
        assertThat(result.next.next.next.next.next).isNull();
    }

    @Test
    void testReverseListRecursive_EmptyList() {
        assertThat(solution.reverseListRecursive(null)).isNull();
    }

    @Test
    void testReverseListRecursive_SingleNode() {
        ListNode head = new ListNode(1);
        ListNode result = solution.reverseListRecursive(head);
        assertThat(result.val).isEqualTo(1);
        assertThat(result.next).isNull();
    }

    @Test
    void testReverseListRecursive_MultipleNodes() {
        // Create list: 1->2->3->4->5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Reverse the list using recursive method
        ListNode result = solution.reverseListRecursive(head);

        // Verify the reversed list: 5->4->3->2->1
        assertThat(result.val).isEqualTo(5);
        assertThat(result.next.val).isEqualTo(4);
        assertThat(result.next.next.val).isEqualTo(3);
        assertThat(result.next.next.next.val).isEqualTo(2);
        assertThat(result.next.next.next.next.val).isEqualTo(1);
        assertThat(result.next.next.next.next.next).isNull();
    }

    @Test
    void testBothMethodsProduceSameResult() {
        // Create list: 1->2->3->4->5
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);

        // Create a copy for the second method
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(5);

        // Reverse using both methods
        ListNode result1 = solution.reverseList(head1);
        ListNode result2 = solution.reverseListRecursive(head2);

        // Verify both methods produce the same result
        assertThat(areListsEqual(result1, result2)).isTrue();
    }

    // Helper method to compare two linked lists
    private boolean areListsEqual(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1 == null && l2 == null;
    }
}
