package page_01._0014_longest_common_prefix;

public class LongestCommonPrefixMyIterativeTraversal implements LongestCommonPrefix {
    // Using Iterative Traversal from left to right
    // Time: O(S) - S: sum of all strings
    // Space: O(1)
    @Override
    public String longestCommonPrefix(String[] strs) {
        int numOfStrings = strs.length;

        if(numOfStrings <= 0) {
            return "";
        }

        if(numOfStrings == 1) {
            return strs[0];
        }

        int maxCommonPrefixIndex = Integer.MAX_VALUE;

        for(int str = 1; str < numOfStrings; str++) {
            int length = strs[0].length() < strs[str].length()? strs[0].length() : strs[str].length();

            int i;
            for(i = 0; i < length; i++) {
                if(strs[0].charAt(i) != strs[str].charAt(i)) {
                    if(maxCommonPrefixIndex > i) {
                        maxCommonPrefixIndex = i;
                    }
                    break;
                }
            }
            // Check if reached end of loop
            if(i == length && maxCommonPrefixIndex > i) {
                maxCommonPrefixIndex = i;
            }
        }

        if(maxCommonPrefixIndex == Integer.MAX_VALUE) {
            return "";
        } else {
            return strs[0].substring(0, maxCommonPrefixIndex);
        }
    }

    public static void main(String[] args) {
        LongestCommonPrefix fud = new LongestCommonPrefixMyIterativeTraversal();
        String[] strs = {"flower","flow","flight"};
        System.out.println(fud.longestCommonPrefix(strs));
        String[] strs2 = {"dog","racecar","car"};
        System.out.println(fud.longestCommonPrefix(strs2));
        String[] strs3 = {"ab", "a"};
        System.out.println(fud.longestCommonPrefix(strs3));
    }
}
