package page_01._0012_integer_to_roman;

public class IntegerToRomanGreedy implements IntegerToRoman {
    // Using Greedy Approach
    // Time: O(1)
    // Space: O(1)
    private static final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    @Override
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        // Loop through each symbol, stopping if num becomes 0.
        for (int i = 0; i < values.length && num > 0; i++) {
            // Repeat while the current symbol still fits into num.
            while (values[i] <= num) {
                num -= values[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        IntegerToRoman fud = new IntegerToRomanGreedy();
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
