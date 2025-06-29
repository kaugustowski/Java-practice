package leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LinkedListCycleTest {

    private final LinkedListCycle solution = new LinkedListCycle();

    @ParameterizedTest(name = "Test {index}: hasCycle({0}, {1}) = {2}")
    @MethodSource("provideTestCases")
    void testHasCycle(int[] values, int pos, boolean expected) {
        // Given
        LinkedListCycle.ListNode head = LinkedListCycle.createLinkedList(values, pos);
        
        // When
        boolean result = solution.hasCycle(head);
        
        // Then
        assertThat(result)
            .as("Expected %s for list %s with cycle at position %d", 
                expected, arrayToString(values), pos)
            .isEqualTo(expected);
    }

    @Test
    void testEmptyList() {
        assertThat(solution.hasCycle(null)).isFalse();
    }

    @Test
    void testSingleNodeNoCycle() {
        LinkedListCycle.ListNode node = new LinkedListCycle.ListNode(1);
        assertThat(solution.hasCycle(node)).isFalse();
    }

    @Test
    void testSingleNodeWithCycle() {
        LinkedListCycle.ListNode node = new LinkedListCycle.ListNode(1);
        node.next = node; // Create a self-cycle
        assertThat(solution.hasCycle(node)).isTrue();
    }

    @Test
    void testLargeListWithCycle() {
        // Create a large list with 10000 nodes
        int size = 10000;
        int[] values = new int[size];
        for (int i = 0; i < size; i++) {
            values[i] = i;
        }
        
        // Create a cycle from last node to the middle
        LinkedListCycle.ListNode head = LinkedListCycle.createLinkedList(values, size / 2);
        assertThat(solution.hasCycle(head)).isTrue();
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            // Test cases from problem description
            Arguments.of(new int[]{3, 2, 0, -4}, 1, true),
            Arguments.of(new int[]{1, 2}, 0, true),
            Arguments.of(new int[]{1}, -1, false),
            
            // Additional test cases
            Arguments.of(new int[]{1, 2, 3, 4, 5}, -1, false),  // No cycle
            Arguments.of(new int[]{1, 2, 3, 4, 5}, 0, true),    // Cycle to head
            Arguments.of(new int[]{1, 2, 3, 4, 5}, 4, true),    // Cycle to last node (self-loop)
            Arguments.of(new int[]{1, 2, 3, 4, 5}, 2, true),    // Cycle to middle
            Arguments.of(new int[]{}, -1, false),                // Empty list
            Arguments.of(new int[]{1, 1, 1, 1}, 1, true),       // All same values with cycle
            Arguments.of(new int[]{-21, 10, 17, 8, 4, 26, 5, 35, 33, -7, -16, 27, -12, 6, 29, -12, 5, 9, 20, 14, 14, 2, 13, -24, 21, 23, -21, 5}, -1, false) // No cycle, long list
        );
    }

    private String arrayToString(int[] arr) {
        if (arr == null) return "null";
        if (arr.length == 0) return "[]";
        
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < Math.min(10, arr.length); i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) sb.append(", ");
        }
        if (arr.length > 10) sb.append(", ...");
        sb.append("]");
        return sb.toString();
    }
}
