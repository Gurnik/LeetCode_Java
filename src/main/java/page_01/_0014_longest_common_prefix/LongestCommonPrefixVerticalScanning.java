package page_01._0014_longest_common_prefix;

public class LongestCommonPrefixVerticalScanning implements LongestCommonPrefix {
    // Using Vertical Scanning
    // Time: O(S) : S is the sum of all characters in all strings.
    // Space: O(1)
    @Override
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length() ; i++){
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j ++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        LongestCommonPrefix fud = new LongestCommonPrefixVerticalScanning();
        String[] strs = {"flower","flow","flight"};
        System.out.println(fud.longestCommonPrefix(strs));
        String[] strs2 = {"dog","racecar","car"};
        System.out.println(fud.longestCommonPrefix(strs2));
        String[] strs3 = {"ab", "a"};
        System.out.println(fud.longestCommonPrefix(strs3));
    }
}
