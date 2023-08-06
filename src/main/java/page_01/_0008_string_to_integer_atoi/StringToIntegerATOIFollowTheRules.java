package page_01._0008_string_to_integer_atoi;

public class StringToIntegerATOIFollowTheRules implements StringToIntegerATOI {
    // Using Follow the Rules
    // Time: O(N) - N: string size
    // Space: O(1)
    @Override
    public int myAtoi(String input) {
        int sign = 1;
        int result = 0;
        int index = 0;
        int n = input.length();

        // Discard all spaces from the beginning of the input string.
        while (index < n && input.charAt(index) == ' ') {
            index++;
        }

        // sign = +1, if it's positive number, otherwise sign = -1.
        if (index < n && input.charAt(index) == '+') {
            sign = 1;
            index++;
        } else if (index < n && input.charAt(index) == '-') {
            sign = -1;
            index++;
        }

        // Traverse next digits of input and stop if it is not a digit
        while (index < n && Character.isDigit(input.charAt(index))) {
            int digit = input.charAt(index) - '0';

            // Check overflow and underflow conditions.
            if ((result > Integer.MAX_VALUE / 10) ||
                    (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                // If integer overflowed return 2^31-1, otherwise if underflowed return -2^31.
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            // Append current digit to the result.
            result = 10 * result + digit;
            index++;
        }

        // We have formed a valid number without any overflow/underflow.
        // Return it after multiplying it with its sign.
        return sign * result;
    }

    public static void main(String[] args) {
        StringToIntegerATOI fut = new StringToIntegerATOIFollowTheRules();
        String s = "42";
        System.out.println(fut.myAtoi(s));
        s = "   -42";
        System.out.println(fut.myAtoi(s));
        s = "4193 with words";
        System.out.println(fut.myAtoi(s));
        s = "only words";
        System.out.println(fut.myAtoi(s));
        s = "words and 987";
        System.out.println(fut.myAtoi(s));
        s = "-91283472332";
        // Output:   -1089159116
        // Expected: -2147483648
        System.out.println(fut.myAtoi(s));
        s = "2147483648";
        // Output:   -2147483648
        // Expected: 2147483647
        System.out.println(fut.myAtoi(s));
    }
}
