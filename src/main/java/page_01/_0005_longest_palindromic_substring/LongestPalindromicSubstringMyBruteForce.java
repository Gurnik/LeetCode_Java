package page_01._0005_longest_palindromic_substring;

public class LongestPalindromicSubstringMyBruteForce implements LongestPalindromicSubstring {
    // Using Brute Force
    // Time: O(n^3)
    // Space: O(1)
    @Override
    public String longestPalindrome(String s) {
        int longestPalindromeSize = 0;
        int startOfLongestPalindrome = -1;
        int endOfLongestPalindrome = -1;

        for(int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if(isStringPalindrome(s, i, j)) {
                    if(longestPalindromeSize < (j - i) + 1) {
                        longestPalindromeSize = (j - i) + 1;
                        startOfLongestPalindrome = i;
                        endOfLongestPalindrome = j + 1;
                    }
                }
            }
        }
        return s.substring(startOfLongestPalindrome, endOfLongestPalindrome);
    }

    // Time: O(n)
    // Space: O(1)
    private boolean isStringPalindrome(String s, int start, int end) {
        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }

            start ++;
            end --;
        }
        return  true;
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring fud = new LongestPalindromicSubstringMyBruteForce();
        String s = "babad";
        System.out.println("Longest Palindromic Substring for: " + s + " is: " + fud.longestPalindrome(s));
        s = "cbbd";
        System.out.println("Longest Palindromic Substring for: " + s + " is: " + fud.longestPalindrome(s));
        s = "abacdfgdcaba";
        System.out.println("Longest Palindromic Substring for: " + s + " is: " + fud.longestPalindrome(s));
        s = "abacdgfdcaba";
        System.out.println("Longest Palindromic Substring for: " + s + " is: " + fud.longestPalindrome(s));
        // Time Limit Exceeded
        s = "\"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\"";
        System.out.println("Longest Palindromic Substring for: " + s + " is: " + fud.longestPalindrome(s));
        // Time Limit Exceeded
        s = "321012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210123210012321001232100123210123";
        System.out.println("Longest Palindromic Substring for: " + s + " is: " + fud.longestPalindrome(s));
    }
}
