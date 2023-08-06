package page_01._0009_palindrome_number;

public class PalindromeNumberMyRevertHalfOfTheNumber implements PalindromeNumber{
    // Using Revert Half Of TheNumber
    // Time: O(log10(N)) - base of log = 10
    // Space: O(1)
    @Override
    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        int reversedNumber = 0;

        int temp = x;
        while(temp / 10 != 0) {
            reversedNumber = (reversedNumber * 10) + temp % 10;
            temp = temp / 10;
        }

        reversedNumber = (reversedNumber * 10) + temp % 10;

        if(reversedNumber == x) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        PalindromeNumber fud = new PalindromeNumberMyRevertHalfOfTheNumber();
        int x = 121;
        System.out.println(fud.isPalindrome(x));
        x = -121;
        System.out.println(fud.isPalindrome(x));
        x = 10;
        System.out.println(fud.isPalindrome(x));
    }
}
