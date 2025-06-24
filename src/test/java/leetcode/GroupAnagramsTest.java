package leetcode;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.*;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class GroupAnagramsTest {
    private final GroupAnagrams solution = new GroupAnagrams();

    @ParameterizedTest
    @MethodSource("testCases")
    void testGroupAnagrams(String[] input, List<List<String>> expected) {
        List<List<String>> result = solution.groupAnagrams(input);
        
        // Convert both expected and result to a Set of Sets for comparison
        Set<Set<String>> expectedSet = convertToSet(expected);
        Set<Set<String>> resultSet = convertToSet(result);
        
        assertTrue(areEqualIgnoringOrder(expectedSet, resultSet),
            String.format("Expected groups: %s%nBut got: %s%n", expected, result));
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
            // Test case 1: Basic example with multiple anagrams
            Arguments.of(
                new String[]{"eat","tea","tan","ate","nat","bat"},
                Arrays.asList(
                    List.of("bat"),
                    Arrays.asList("nat","tan"),
                    Arrays.asList("ate","eat","tea")
                )
            ),
            
            // Test case 2: Empty string input
            Arguments.of(
                new String[]{""},
                Collections.singletonList(Collections.singletonList(""))
            ),
            
            // Test case 3: Single character
            Arguments.of(
                new String[]{"a"},
                Collections.singletonList(Collections.singletonList("a"))
            ),
            
            // Test case 4: All empty strings
            Arguments.of(
                new String[]{"", "", ""},
                Collections.singletonList(Arrays.asList("", "", ""))
            ),
            
            // Test case 5: No anagrams
            Arguments.of(
                new String[]{"abc", "def", "ghi"},
                Arrays.asList(
                    Collections.singletonList("abc"),
                    Collections.singletonList("def"),
                    Collections.singletonList("ghi")
                )
            )
        );
    }

    private Set<Set<String>> convertToSet(List<List<String>> listOfLists) {
        Set<Set<String>> result = new HashSet<>();
        for (List<String> list : listOfLists) {
            result.add(new HashSet<>(list));
        }
        return result;
    }

    private boolean areEqualIgnoringOrder(Set<Set<String>> first, Set<Set<String>> second) {
        if (first.size() != second.size()) {
            return false;
        }
        
        for (Set<String> set : first) {
            boolean found = false;
            for (Set<String> otherSet : second) {
                if (set.equals(otherSet)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }
}
