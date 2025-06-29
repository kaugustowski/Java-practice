package leetcode;

/**
 * 21. Merge Two Sorted Lists
 * <p>
 * You are given the heads of two sorted linked lists list1 and list2.
 * <p>
 * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes
 * of the first two lists.
 * <p>
 * Return the head of the merged linked list.
 * <p>
 * Example 1: Input: list1 = [1,2,4], list2 = [1,3,4] Output: [1,1,2,3,4,4]
 * <p>
 * Example 2: Input: list1 = [], list2 = [] Output: []
 * <p>
 * Example 3: Input: list1 = [], list2 = [0] Output: [0]
 * <p>
 * Constraints: - The number of nodes in both lists is in the range [0, 50]. - -100 <= Node.val <=
 * 100 - Both list1 and list2 are sorted in non-decreasing order.
 */
public class MergeTwoSortedLists {

  // Definition for singly-linked list
  public static class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
      this.val = val;
    }

    public ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder("[");
      ListNode current = this;
      while (current != null) {
        sb.append(current.val);
        if (current.next != null) {
          sb.append(", ");
        }
        current = current.next;
      }
      sb.append("]");
      return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ListNode)) {
            return false;
        }

      ListNode other = (ListNode) obj;
      ListNode current = this;

      while (current != null && other != null) {
        if (current.val != other.val) {
          return false;
        }
        current = current.next;
        other = other.next;
      }

      return current == null && other == null;
    }
  }

  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

    var dummy = new ListNode(0);
    var node = dummy;

    while (list1 != null && list2 !=null) {

      if(list1.val <= list2.val) {
        node.next = list1;
        list1 = list1.next;
      } else {
        node.next = list2;
        list2 = list2.next;
      }

      node = node.next;
    }

    if (list1 != null) {
      node.next = list1;
    } else if (list2 != null) {
      node.next = list2;
    }

    return dummy.next;
  }

  public static ListNode createList(int[] values) {
    if (values == null || values.length == 0) {
      return null;
    }

    ListNode dummy = new ListNode();
    ListNode current = dummy;

    for (int val : values) {
      current.next = new ListNode(val);
      current = current.next;
    }

    return dummy.next;
  }
}
