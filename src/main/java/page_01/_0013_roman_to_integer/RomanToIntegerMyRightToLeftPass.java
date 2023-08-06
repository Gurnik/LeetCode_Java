package page_01._0013_roman_to_integer;

public class RomanToIntegerMyRightToLeftPass implements RomanToInteger {
    // Using: Right-to-Left Pass
    // Time: O(1)
    // Space: O(1)
    private static final char[] oneSymbols = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
    private static final int[] oneSymbolsvalues = {1, 5, 10, 50, 100, 500, 1000};
    private static final String[] twoSymbols = {"IV", "IX", "XL", "XC", "CD", "CM"};
    private static final int[] twoSymbolsvalues = {4, 9, 40, 90, 400, 900};
    @Override
    public int romanToInt(String s) {
        if(s.length() > 15 || s.length() < 1) {
            return 0;
        }
        int number = 0;
        int right = s.length() - 1;

        while(right >= 0) {
            char symbol = s.charAt(right);
            StringBuilder symbols = new StringBuilder();
            int temp = 0;

            if(right - 1 >= 0) {
                symbols.append(s.charAt(right - 1));
                symbols.append(symbol);
                temp = getTwoSymbolsNumber(symbols.toString());
                if(temp != 0) {
                    // Read two symbols
                    number = number + temp;
                    right = right - 2;
                }
            }

            if(temp == 0) {
                // Read only one symbol
                temp = getOneSymbolNumber(symbol);
                number = number + temp;
                right = right - 1;
            }
        }
        return number;
    }

    private int getTwoSymbolsNumber(String symbols) {
        for(int i = 0; i < twoSymbols.length; i++) {
            if(twoSymbols[i].equals(symbols)) {
                return twoSymbolsvalues[i];
            }
        }
        return  0;
    }

    private int getOneSymbolNumber(char symbol) {
        for(int i = 0; i < oneSymbols.length; i++) {
            if(oneSymbols[i] == symbol) {
                return oneSymbolsvalues[i];
            }
        }
        return  0;
    }

    public static void main(String[] args) {
        RomanToInteger fud = new RomanToIntegerMyRightToLeftPass();
        String s = "IV";
        System.out.println(fud.romanToInt(s)); // Expected 4 - Output 6
        s = "III";
        System.out.println(fud.romanToInt(s));
        s = "LVIII";
        System.out.println(fud.romanToInt(s));
        s = "MCMXCIV";
        System.out.println(fud.romanToInt(s));
    }
}
