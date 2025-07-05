package leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

class ValidateBinarySearchTreeTest {
    private final ValidateBinarySearchTree solution = new ValidateBinarySearchTree();
    private final TestTreeBuilder treeBuilder = new TestTreeBuilder();

    @ParameterizedTest
    @MethodSource("testCases")
    void testIsValidBST(String tree, boolean expected) {
        TreeNode root = treeBuilder.build(tree);
        assertEquals(expected, solution.isValidBST(root));
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
            // Example 1: Valid BST
            //     2
            //    / \
            //   1   3
            Arguments.of("[2,1,3]", true),
            
            // Example 2: Invalid BST
            //     5
            //    / \
            //   1   4
            //      / \
            //     3   6
            Arguments.of("[5,1,4,null,null,3,6]", false),
            
            // Single node tree (valid BST)
            Arguments.of("[1]", true),
            
            // Empty tree (valid BST)
            Arguments.of("[]", true),
            
            // Left-skewed valid BST
            //       4
            //      /
            //     2
            //    /
            //   1
            Arguments.of("[4,2,null,1]", true),
            
            // Right-skewed valid BST
            // 1
            //  \
            //   3
            //    \
            //     4
            Arguments.of("[1,null,3,null,null,null,4]", true),
            
            // Invalid BST with right child smaller than root
            //   5
            //  / \
            // 4   6
            //    / \
            //   3   7
            Arguments.of("[5,4,6,null,null,3,7]", false),
            
            // Valid BST with negative numbers
            //   0
            //  / \
            //-1   2
            Arguments.of("[0,-1,2]", true),
            
            // Invalid BST with equal values
            //   1
            //  / \
            // 1   
            Arguments.of("[1,1]", false),
            
            // Large valid BST
            //          10
            //        /    \
            //       5      15
            //      / \    /  \
            //     3   7  12   18
            //    /   /
            //   1   6
            Arguments.of("[10,5,15,3,7,12,18,1,null,6]", true),
            
            // Invalid BST with right subtree having value equal to root
            //   2
            //  / \
            // 1   2
            Arguments.of("[2,1,2]", false)
        );
    }

    @Test
    void testNullRoot() {
        assertTrue(solution.isValidBST(null), "Null tree should be considered a valid BST");
    }
}
