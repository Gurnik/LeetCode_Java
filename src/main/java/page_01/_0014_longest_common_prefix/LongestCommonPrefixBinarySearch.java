package page_01._0014_longest_common_prefix;

public class LongestCommonPrefixBinarySearch implements LongestCommonPrefix {
    // Using Binary Search
    // Time: O(S * log(m)) - S: sum of all strings
    // Space: O(1)
    @Override
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        int minLen = Integer.MAX_VALUE;
        for (String str : strs)
            minLen = Math.min(minLen, str.length());
        int low = 1;
        int high = minLen;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (isCommonPrefix(strs, middle))
                low = middle + 1;
            else
                high = middle - 1;
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    private boolean isCommonPrefix(String[] strs, int len) {
        String str1 = strs[0].substring(0, len);
        for (int i = 1; i < strs.length; i++)
            if (!strs[i].startsWith(str1))
                return false;
        return true;
    }

    public static void main(String[] args) {
        LongestCommonPrefix fud = new LongestCommonPrefixBinarySearch();
        String[] strs = {"flower","flow","flight"};
        System.out.println(fud.longestCommonPrefix(strs));
        String[] strs2 = {"dog","racecar","car"};
        System.out.println(fud.longestCommonPrefix(strs2));
        String[] strs3 = {"ab", "a"};
        System.out.println(fud.longestCommonPrefix(strs3));
    }
}
