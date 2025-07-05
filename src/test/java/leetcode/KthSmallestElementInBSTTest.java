package leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

class KthSmallestElementInBSTTest {
    private final KthSmallestElementInBST solution = new KthSmallestElementInBST();
    private final TestTreeBuilder treeBuilder = new TestTreeBuilder();

    @ParameterizedTest
    @MethodSource("testCases")
    void testKthSmallest(String tree, int k, int expected) {
        TreeNode root = treeBuilder.build(tree);
        assertEquals(expected, solution.kthSmallest(root, k));
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
            // Example 1
            Arguments.of("[3,1,4,null,2]", 1, 1),
            
            // Example 2
            Arguments.of("[5,3,6,2,4,null,null,1]", 3, 3),
            
            // Additional test cases
            Arguments.of("[1]", 1, 1),  // Single node tree
            
            Arguments.of("[5,3,7,2,4,6,8]", 1, 2),  // First smallest
            Arguments.of("[5,3,7,2,4,6,8]", 4, 5),  // Middle element
            Arguments.of("[5,3,7,2,4,6,8]", 7, 8),  // Last element
            
            // Left-skewed tree
            Arguments.of("[4,3,null,2,null,1]", 2, 2),
            
            // Right-skewed tree
            Arguments.of("[1,null,2,null,3,null,4]", 3, 3),
            
            // Large k value
            Arguments.of("[10,5,15,3,7,12,20,1,4,6,8,11,13,17,25]", 10, 12)
        );
    }

    @Test
    void testKthSmallestWithNullRoot() {
        assertThrows(IllegalArgumentException.class, 
            () -> solution.kthSmallest(null, 1));
    }

    @Test
    void testKthSmallestWithInvalidK() {
        TreeNode root = treeBuilder.build("[1,2,3]");
        assertThrows(IllegalArgumentException.class, 
            () -> solution.kthSmallest(root, 0));
        assertThrows(IllegalArgumentException.class, 
            () -> solution.kthSmallest(root, 4));
    }
}
