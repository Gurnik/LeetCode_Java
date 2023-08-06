package page_01._0012_integer_to_roman;

public class IntegerToRomanHardcodeDigits implements IntegerToRoman {
    // Using Hardcode Digits
    // Time: O(1)
    // Space: O(1)
    private static final String[] thousands = {"", "M", "MM", "MMM"};
    private static final String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    private static final String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    private static final String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    @Override
    public String intToRoman(int num) {
        return thousands[num / 1000] + hundreds[num % 1000 / 100] + tens[num % 100 / 10] + ones[num % 10];
    }

    public static void main(String[] args) {
        IntegerToRoman fud = new IntegerToRomanHardcodeDigits();
        int num = 3;
        System.out.println(fud.intToRoman(num));
        num = 58;
        System.out.println(fud.intToRoman(num));
        num = 1994;
        System.out.println(fud.intToRoman(num));
        num = 3999;
        System.out.println(fud.intToRoman(num));
    }
}
