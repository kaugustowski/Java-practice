package leetcode;

/**
 * 206. Reverse Linked List
 * <p>
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 * <p>
 * Example: Input: 1->2->3->4->5->NULL Output: 5->4->3->2->1->NULL
 */
public class ReverseLinkedList {

  // Iterative solution - O(n) time, O(1) space
  public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;

    while (curr != null) {
      var tempNxt = curr.next;
      curr.next = prev;
      prev = curr;
      curr = tempNxt;
    }

    return prev;
  }


  public ListNode reverseListRecursive(ListNode head) {

    if (head == null) {
      return null;
    }

    var newHead = head;

    if (head.next != null) {
      newHead = reverseListRecursive(head.next);
      head.next.next = head;
    }
    head.next = null;

    return newHead;
  }
}
