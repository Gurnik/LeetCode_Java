package page_01._0005_longest_palindromic_substring;

public class LongestPalindromicSubstringMyExpandAroundCenter implements LongestPalindromicSubstring {
    // Using Expand Around Center
    // Time: O(n^2)
    // Space: O(1)
    @Override
    public String longestPalindrome(String s) {

        if(s == null || s.length() == 0) {
            return "";
        }

        int longestPalindromeSize = 0;
        int longestPalindromeStart = -1;
        int longestPalindromeEnd = -1;

        for(int center = 0; center < s.length(); center++) {
            int left = center;
            int right = center;

            // Odd Case:
            while(left >= 0 && right < s.length()) {
                if(s.charAt(left) == s.charAt(right)) {
                    if(longestPalindromeSize < (right - left) + 1) {
                        longestPalindromeSize = (right - left) + 1;
                        longestPalindromeStart = left;
                        longestPalindromeEnd = right;
                    }
                    left --;
                    right ++;
                }
                else {
                    break;
                }
            }
            left = center;
            right = center + 1;
            // Even Case:
            while(left >= 0 && right < s.length()) {
                if(s.charAt(left) == s.charAt(right)) {
                    if(longestPalindromeSize < (right - left) + 1) {
                        longestPalindromeSize = (right - left) + 1;
                        longestPalindromeStart = left;
                        longestPalindromeEnd = right;
                    }
                    left --;
                    right ++;
                }
                else {
                    break;
                }
            }
        }

        return s.substring(longestPalindromeStart, longestPalindromeEnd + 1);
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring fud = new LongestPalindromicSubstringMyExpandAroundCenter();
        String s = "b";
        System.out.println("Longest Palindromic Substring for: " + s + " is: " + fud.longestPalindrome(s));
        s = "bb";
        System.out.println("Longest Palindromic Substring for: " + s + " is: " + fud.longestPalindrome(s));
        s = "bbb";
        System.out.println("Longest Palindromic Substring for: " + s + " is: " + fud.longestPalindrome(s));
        s = "bbbb";
        System.out.println("Longest Palindromic Substring for: " + s + " is: " + fud.longestPalindrome(s));
        s = "bbbbb";
        System.out.println("Longest Palindromic Substring for: " + s + " is: " + fud.longestPalindrome(s));
        s = "bbbbbb";
        System.out.println("Longest Palindromic Substring for: " + s + " is: " + fud.longestPalindrome(s));
        s = "baab";
        System.out.println("Longest Palindromic Substring for: " + s + " is: " + fud.longestPalindrome(s));
        s = "babad";
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
