package page_01._0014_longest_common_prefix;

public class LongestCommonPrefixDivideAndConquer implements LongestCommonPrefix {
    // Using Divide and Conquer
    // Time: O(S) : S is the number of all characters in the array.
    // Space: O(m⋅log(n))
    @Override
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefix(strs, 0 , strs.length - 1);
    }

    private String longestCommonPrefix(String[] strs, int l, int r) {
        if (l == r) {
            return strs[l];
        }
        else {
            int mid = (l + r)/2;
            String lcpLeft =   longestCommonPrefix(strs, l , mid);
            String lcpRight =  longestCommonPrefix(strs, mid + 1,r);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    String commonPrefix(String left,String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if ( left.charAt(i) != right.charAt(i) )
                return left.substring(0, i);
        }
        return left.substring(0, min);
    }



    public static void main(String[] args) {
        LongestCommonPrefix fud = new LongestCommonPrefixDivideAndConquer();
        String[] strs = {"flower","flow","flight"};
        System.out.println(fud.longestCommonPrefix(strs));
        String[] strs2 = {"dog","racecar","car"};
        System.out.println(fud.longestCommonPrefix(strs2));
        String[] strs3 = {"ab", "a"};
        System.out.println(fud.longestCommonPrefix(strs3));
    }
}
