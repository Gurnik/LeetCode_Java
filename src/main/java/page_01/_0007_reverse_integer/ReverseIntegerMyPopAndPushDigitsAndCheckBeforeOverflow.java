package page_01._0007_reverse_integer;

public class ReverseIntegerMyPopAndPushDigitsAndCheckBeforeOverflow implements ReverseInteger {
    // Using Pop and Push Digits & Check before Overflow
    // Time: O(log(x))
    // Space: O(1)

    @Override
    public int reverse(int x) {
        // Max.int = 2^31 - 1 =  2,147,483,647
        // Min.int = -2^31    = -2,147,483,648
        int reversedNumber = 0;
        int temp = x;

        while(temp / 10 != 0) {
            reversedNumber = (reversedNumber * 10) + (temp % 10);
            temp = temp / 10;
        }

        if(Math.abs(reversedNumber) / 214748364 >= 1) {
            // Positive case
            if(x > 0 && ( reversedNumber > Integer.MAX_VALUE / 10 ||
                    reversedNumber == Integer.MAX_VALUE && temp % 10 > 7)) {
                return 0;
            } else // Negative Case
            if(x < 0 && ( reversedNumber < Integer.MIN_VALUE / 10 ||
                    reversedNumber == Integer.MIN_VALUE && temp % 10 > 8)) {
                return 0;
            }

        }

        reversedNumber = (reversedNumber * 10) + (temp % 10);

        return reversedNumber;
    }

    public static void main(String[] args) {
        ReverseInteger fud = new ReverseIntegerMyPopAndPushDigitsAndCheckBeforeOverflow();
        int x = 1534236469;
        // Expected: 0
        // Output: 1056389759
        System.out.println(fud.reverse(x));
        x = 123;
        System.out.println(fud.reverse(x));
        x = -123;
        System.out.println(fud.reverse(x));
        x = 120;
        System.out.println(fud.reverse(x));
    }
}