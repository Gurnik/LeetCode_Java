package page_01._0008_string_to_integer_atoi;

public class StringToIntegerATOIMyFollowTheRules implements StringToIntegerATOI{
    // Using Follow the Rules
    // Time: O(N) - N: string size
    // Space: O(1)
    @Override
    public int myAtoi(String s) {
        int number = 0;
        boolean isSignApplied = false;
        boolean isLeadingWhiteSpaceFinished = false;
        int sign = 1;

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if((ch == '-' || ch == '+') && isSignApplied == false) {
                isSignApplied = true;
                isLeadingWhiteSpaceFinished = true;
                sign = ch == '-'? -1 : 1;
            } else if((ch == '-' || ch == '+') && isSignApplied == true) {
                return sign * number;
            } else if(ch < '0' || ch > '9') {
                if(ch == ' ' && isLeadingWhiteSpaceFinished == true)
                    return sign * number;
                else if(ch == ' ')
                    continue;
                return sign * number;
            } else if(ch >= '0' && ch <= '9') {
                if(isSignApplied == false) {
                    isSignApplied = true; // Default sign is '+'
                }
                isLeadingWhiteSpaceFinished = true;

                if(number > Integer.MAX_VALUE / 10 ||
                        (number == Integer.MAX_VALUE / 10 && (ch - '0') > Integer.MAX_VALUE % 10)) {
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }

                number = number * 10 + ch - '0';
            }
        }
        return sign * number;
    }

    public static void main(String[] args) {
        StringToIntegerATOI fut = new StringToIntegerATOIMyFollowTheRules();
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
