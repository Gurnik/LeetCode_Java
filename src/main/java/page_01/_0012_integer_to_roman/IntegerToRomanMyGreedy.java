package page_01._0012_integer_to_roman;

public class IntegerToRomanMyGreedy implements IntegerToRoman {
    // Using Greedy Approach
    // Time: O(1)
    // Space: O(1)
    private final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private final String[] symbol = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    @Override
    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < values.length && (num > 0 || num < 4000); i++) {
            while(num >= values[i]) {
                result.append(symbol[i]);
                num = num - values[i];
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        IntegerToRoman fud = new IntegerToRomanMyGreedy();
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
