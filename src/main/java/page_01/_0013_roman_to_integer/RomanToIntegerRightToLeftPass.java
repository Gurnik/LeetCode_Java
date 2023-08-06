package page_01._0013_roman_to_integer;

import java.util.HashMap;
import java.util.Map;

public class RomanToIntegerRightToLeftPass implements RomanToInteger {
    // Using: Right-to-Left Pass
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
        String lastSymbol = s.substring(s.length() - 1);
        int lastValue = values.get(lastSymbol);
        int total = lastValue;

        for (int i = s.length() - 2; i >= 0; i--) {
            String currentSymbol = s.substring(i, i + 1);
            int currentValue = values.get(currentSymbol);
            if (currentValue < lastValue) {
                total -= currentValue;
            } else {
                total += currentValue;
            }
            lastValue = currentValue;
        }
        return total;
    }

    public static void main(String[] args) {
        RomanToInteger fud = new RomanToIntegerRightToLeftPass();
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
