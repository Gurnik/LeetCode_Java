package page_01._0013_roman_to_integer;

import java.util.HashMap;
import java.util.Map;

public class RomanToIntegerLeftToRightPassImproved implements RomanToInteger {
    // Using: Right-to-Left Pass Improved
    // Time: O(1)
    // Space: O(1)
    static Map<String, Integer> values = new HashMap<>();

    static {
        values.put("I", 1);
        values.put("V", 5);
        values.put("X", 10);
        values.put("L", 50);
        values.put("C", 100);
        values.put("D", 500);
        values.put("M", 1000);
        values.put("IV", 4);
        values.put("IX", 9);
        values.put("XL", 40);
        values.put("XC", 90);
        values.put("CD", 400);
        values.put("CM", 900);
    }
    @Override
    public int romanToInt(String s) {
        int sum = 0;
        int i = 0;
        while (i < s.length()) {
            if (i < s.length() - 1) {
                String doubleSymbol = s.substring(i, i + 2);
                // Check if this is the length-2 symbol case.
                if (values.containsKey(doubleSymbol)) {
                    sum += values.get(doubleSymbol);
                    i += 2;
                    continue;
                }
            }
            // Otherwise, it must be the length-1 symbol case.
            String singleSymbol = s.substring(i, i + 1);
            sum += values.get(singleSymbol);
            i += 1;
        }
        return sum;
    }

    public static void main(String[] args) {
        RomanToInteger fud = new RomanToIntegerLeftToRightPassImproved();
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
