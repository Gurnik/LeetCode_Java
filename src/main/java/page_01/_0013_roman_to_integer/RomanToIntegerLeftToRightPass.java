package page_01._0013_roman_to_integer;

import java.util.HashMap;
import java.util.Map;

public class RomanToIntegerLeftToRightPass implements RomanToInteger {
    // Using Left-to-Right Pass
    // Time: O(1)
    // Space: O(1)

    static Map<String, Integer> values = new HashMap<>();

    static {
        values.put("M", 1000);
        values.put("D", 500);
        values.put("C", 100);
        values.put("L", 50);
        values.put("X", 10);
        values.put("V", 5);
        values.put("I", 1);
    }

    @Override
    public int romanToInt(String s) {
        int sum = 0;
        int i = 0;
        while (i < s.length()) {
            String currentSymbol = s.substring(i, i + 1);
            int currentValue = values.get(currentSymbol);
            int nextValue = 0;
            if (i + 1 < s.length()) {
                String nextSymbol = s.substring(i + 1, i + 2);
                nextValue = values.get(nextSymbol);
            }

            if (currentValue < nextValue) {
                sum += (nextValue - currentValue);
                i += 2;
            }
            else {
                sum += currentValue;
                i += 1;
            }

        }
        return sum;
    }

    public static void main(String[] args) {
        RomanToInteger fud = new RomanToIntegerLeftToRightPass();
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
