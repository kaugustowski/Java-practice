package leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MergeTwoSortedListsTest {

    private final MergeTwoSortedLists solution = new MergeTwoSortedLists();

    @ParameterizedTest(name = "Test {index}: merge({0}, {1}) = {2}")
    @MethodSource("provideTestCases")
    void testMergeTwoLists(int[] list1, int[] list2, int[] expected) {
        // Given
        MergeTwoSortedLists.ListNode l1 = MergeTwoSortedLists.createList(list1);
        MergeTwoSortedLists.ListNode l2 = MergeTwoSortedLists.createList(list2);
        MergeTwoSortedLists.ListNode expectedList = MergeTwoSortedLists.createList(expected);
        
        // When
        MergeTwoSortedLists.ListNode result = solution.mergeTwoLists(l1, l2);
        
        // Then
        assertThat(result)
            .as("Expected %s when merging %s and %s", 
                arrayToString(expected), arrayToString(list1), arrayToString(list2))
            .isEqualTo(expectedList);
    }

    @Test
    void testBothListsNull() {
        assertThat(solution.mergeTwoLists(null, null)).isNull();
    }

    @Test
    void testFirstListNull() {
        int[] list2 = {1, 2, 3};
        MergeTwoSortedLists.ListNode expected = MergeTwoSortedLists.createList(list2);
        assertThat(solution.mergeTwoLists(null, expected)).isEqualTo(expected);
    }

    @Test
    void testSecondListNull() {
        int[] list1 = {1, 2, 3};
        MergeTwoSortedLists.ListNode expected = MergeTwoSortedLists.createList(list1);
        assertThat(solution.mergeTwoLists(expected, null)).isEqualTo(expected);
    }

    @Test
    void testSingleElementLists() {
        MergeTwoSortedLists.ListNode l1 = new MergeTwoSortedLists.ListNode(1);
        MergeTwoSortedLists.ListNode l2 = new MergeTwoSortedLists.ListNode(2);
        
        MergeTwoSortedLists.ListNode expected = new MergeTwoSortedLists.ListNode(1);
        expected.next = new MergeTwoSortedLists.ListNode(2);
        
        assertThat(solution.mergeTwoLists(l1, l2)).isEqualTo(expected);
    }

    @Test
    void testLargeLists() {
        int[] list1 = new int[1000];
        int[] list2 = new int[1000];
        int[] expected = new int[2000];
        
        for (int i = 0; i < 1000; i++) {
            list1[i] = 2 * i;       // Even numbers
            list2[i] = 2 * i + 1;   // Odd numbers
            expected[2 * i] = 2 * i;
            expected[2 * i + 1] = 2 * i + 1;
        }
        
        MergeTwoSortedLists.ListNode l1 = MergeTwoSortedLists.createList(list1);
        MergeTwoSortedLists.ListNode l2 = MergeTwoSortedLists.createList(list2);
        MergeTwoSortedLists.ListNode expectedList = MergeTwoSortedLists.createList(expected);
        
        assertThat(solution.mergeTwoLists(l1, l2)).isEqualTo(expectedList);
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            // Test cases from problem description
            Arguments.of(
                new int[]{1, 2, 4}, 
                new int[]{1, 3, 4}, 
                new int[]{1, 1, 2, 3, 4, 4}
            ),
            Arguments.of(
                new int[]{}, 
                new int[]{}, 
                new int[]{}
            ),
            Arguments.of(
                new int[]{}, 
                new int[]{0}, 
                new int[]{0}
            ),
            
            // Additional test cases
            Arguments.of(
                new int[]{1, 3, 5}, 
                new int[]{2, 4, 6}, 
                new int[]{1, 2, 3, 4, 5, 6}
            ),
            Arguments.of(
                new int[]{1, 2, 3}, 
                new int[]{1, 2, 3}, 
                new int[]{1, 1, 2, 2, 3, 3}
            ),
            Arguments.of(
                new int[]{1, 2, 3, 7, 8}, 
                new int[]{4, 5, 6, 9, 10}, 
                new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
            ),
            Arguments.of(
                new int[]{-5, -3, 0}, 
                new int[]{-4, -2, 1}, 
                new int[]{-5, -4, -3, -2, 0, 1}
            ),
            Arguments.of(
                new int[]{1, 5, 9}, 
                new int[]{2, 3, 4, 6, 7, 8}, 
                new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}
            )
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
