package leetcode;

/**
 * 141. Linked List Cycle
 * <p>
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * <p>
 * There is a cycle in a linked list if there is some node in the list that can be reached again by
 * continuously following the next pointer. Internally, pos is used to denote the index of the node
 * that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 * <p>
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 * <p>
 * Example 1: Input: head = [3,2,0,-4], pos = 1 Output: true Explanation: There is a cycle in the
 * linked list, where the tail connects to the 1st node (0-indexed).
 * <p>
 * Example 2: Input: head = [1,2], pos = 0 Output: true Explanation: There is a cycle in the linked
 * list, where the tail connects to the 0th node.
 * <p>
 * Example 3: Input: head = [1], pos = -1 Output: false Explanation: There is no cycle in the linked
 * list.
 * <p>
 * Constraints: - The number of nodes in the list is in the range [0, 10^4]. - -10^5 <= Node.val <=
 * 10^5 - pos is -1 or a valid index in the linked-list.
 */
public class LinkedListCycle {

  // Definition for singly-linked list
  static class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }


  public boolean hasCycle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (fast == slow) return true;
    }
    return false;
  }


  public static ListNode createLinkedList(int[] values, int pos) {
    if (values == null || values.length == 0) {
      return null;
    }

    ListNode[] nodes = new ListNode[values.length];
    for (int i = 0; i < values.length; i++) {
      nodes[i] = new ListNode(values[i]);
      if (i > 0) {
        nodes[i - 1].next = nodes[i];
      }
    }

    if (pos >= 0 && pos < values.length) {
      nodes[values.length - 1].next = nodes[pos];
    }

    return nodes[0];
  }
}
