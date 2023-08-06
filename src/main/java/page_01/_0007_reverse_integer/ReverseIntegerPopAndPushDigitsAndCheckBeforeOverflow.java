package page_01._0007_reverse_integer;

public class ReverseIntegerPopAndPushDigitsAndCheckBeforeOverflow implements ReverseInteger {
    // Using Pop and Push Digits & Check before Overflow
    // Time: O(log(x))
    // Space: O(1)

    @Override
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String[] args) {
        ReverseInteger fud = new ReverseIntegerPopAndPushDigitsAndCheckBeforeOverflow();
        int x = 123;
        System.out.println(fud.reverse(x));
        x = -123;
        System.out.println(fud.reverse(x));
        x = 120;
        System.out.println(fud.reverse(x));
    }
}
