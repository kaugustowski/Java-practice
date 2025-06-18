package leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SumOfNodesWithEvenValuedGrandparentTest {
    private final SumOfNodesWithEvenValuedGrandparent solution = new SumOfNodesWithEvenValuedGrandparent();

    @ParameterizedTest
    @MethodSource("testCases")
    void testSumEvenGrandparent(TreeNode root, int expectedSum) {
        // When
        int result = solution.sumEvenGrandparent(root);
        
        // Then
        assertThat(expectedSum).isEqualTo(result);
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
            // Example 1 from LeetCode 1315
            // Input: [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
            // Output: 18
            Arguments.of(
                new TreeNode(6,
                    new TreeNode(7,
                        new TreeNode(2,
                            new TreeNode(9),
                            null
                        ),
                        new TreeNode(7,
                            new TreeNode(1),
                            new TreeNode(4)
                        )
                    ),
                    new TreeNode(8,
                        new TreeNode(1),
                        new TreeNode(3,
                            null,
                            new TreeNode(5)
                        )
                    )
                ),
                18
            ),
            
            // Example 2 from LeetCode 1315
            // Input: [1]
            // Output: 0
            Arguments.of(new TreeNode(1), 0),
            
            // Additional test case: Empty tree
            Arguments.of(null, 0),
            
            // Test case: Single level with even value
            Arguments.of(
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                0
            ),
            
            // Test case: Two levels with even grandparent
            Arguments.of(
                new TreeNode(2,
                    new TreeNode(1, new TreeNode(5), null),
                    new TreeNode(3, null, new TreeNode(6))
                ),
                11  // 5 + 6
            ),

            // Test case: Deep tree with multiple even grandparents
            Arguments.of(
                new TreeNode(4,
                    new TreeNode(1,
                        new TreeNode(3,
                            new TreeNode(5),
                            new TreeNode(2)
                        ),
                        new TreeNode(7)
                    ),
                    new TreeNode(2,
                        new TreeNode(8),
                        new TreeNode(6,
                            new TreeNode(4),
                            null
                        )
                    )
                ),
                28  // 5 + 2 + 7 (from grandparent 1) + 4 + 8 + 2 (from grandparent 2)
            )
        );
    }

    
    @Test
    void testWithNullRoot() {
        assertEquals(0, solution.sumEvenGrandparent(null));
    }
}
