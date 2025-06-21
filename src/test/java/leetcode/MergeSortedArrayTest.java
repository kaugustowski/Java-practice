package leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MergeSortedArrayTest {
    private final MergeSortedArray solution = new MergeSortedArray();

    @ParameterizedTest
    @MethodSource("testCases")
    void testMerge(int[] nums1, int m, int[] nums2, int n, int[] expected) {
        // When
        solution.merge(nums1, m, nums2, n);
        
        // Then
        assertThat(nums1).isEqualTo(expected);
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
            // Test case 1: Merge with non-overlapping ranges
            arguments(
                new int[]{1, 2, 3, 0, 0, 0}, 3,
                new int[]{4, 5, 6}, 3,
                new int[]{1, 2, 3, 4, 5, 6}
            ),
            
            // Test case 2: Merge with overlapping ranges
            arguments(
                new int[]{1, 2, 3, 0, 0, 0}, 3,
                new int[]{2, 5, 6}, 3,
                new int[]{1, 2, 2, 3, 5, 6}
            ),
            
            // Test case 3: nums1 is empty
            arguments(
                new int[]{0, 0, 0}, 0,
                new int[]{1, 2, 3}, 3,
                new int[]{1, 2, 3}
            ),
            
            // Test case 4: nums2 is empty
            arguments(
                new int[]{1, 2, 3}, 3,
                new int[]{}, 0,
                new int[]{1, 2, 3}
            ),
            
            // Test case 5: Both arrays have one element
            arguments(
                new int[]{2, 0}, 1,
                new int[]{1}, 1,
                new int[]{1, 2}
            ),
            
            // Test case 6: nums1 has one element, nums2 has multiple
            arguments(
                new int[]{4, 0, 0, 0}, 1,
                new int[]{1, 2, 3}, 3,
                new int[]{1, 2, 3, 4}
            ),
            
            // Test case 7: nums2 has one element, nums1 has multiple
            arguments(
                new int[]{1, 3, 5, 0}, 3,
                new int[]{4}, 1,
                new int[]{1, 3, 4, 5}
            ),
            
            // Test case 8: All elements in nums1 are greater than nums2
            arguments(
                new int[]{4, 5, 6, 0, 0, 0}, 3,
                new int[]{1, 2, 3}, 3,
                new int[]{1, 2, 3, 4, 5, 6}
            ),
            
            // Test case 9: Arrays with negative numbers
            arguments(
                new int[]{-5, -3, 0, 0, 0}, 2,
                new int[]{-4, -2, 0}, 3,
                new int[]{-5, -4, -3, -2, 0}
            )
        );
    }

    
    @Test
    void testMergeWithSingleElementArrays() {
        // Given
        int[] nums1 = {0};
        int[] nums2 = {1};
        
        // When
        solution.merge(nums1, 0, nums2, 1);
        
        // Then
        assertThat(nums1).containsExactly(1);
    }
    
    @Test
    void testMergeWithLargeArrays() {
        // Given
        int[] nums1 = new int[200];
        int[] nums2 = new int[100];
        int[] expected = new int[200];
        
        // Fill nums1 with even numbers
        for (int i = 0; i < 100; i++) {
            nums1[i] = i * 2;
            expected[i] = i * 2;
        }
        
        // Fill nums2 with odd numbers
        for (int i = 0; i < 100; i++) {
            nums2[i] = i * 2 + 1;
        }
        
        // Expected is all numbers from 0 to 199
        for (int i = 0; i < 200; i++) {
            expected[i] = i;
        }
        
        // When
        solution.merge(nums1, 100, nums2, 100);
        
        // Then
        assertThat(nums1).isSorted().containsExactly(expected);
    }
}
