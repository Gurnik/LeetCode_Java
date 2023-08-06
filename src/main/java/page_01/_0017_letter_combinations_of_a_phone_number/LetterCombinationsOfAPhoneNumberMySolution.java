package page_01._0017_letter_combinations_of_a_phone_number;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumberMySolution implements LetterCombinationsOfAPhoneNumber {
    @Override
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        char[] digitsArray = new char[digits.length()];

        int inputLength = digits.length();
/*
        if(digits.length() == 0) {
            return result;
        }

        char[][] chars = new char[digits.length()][4];

        for(int i = 0; i < digits.length(); i++) {
            char digit = digits.charAt(i);
            String letter = letters.get(digit);
            for(int j = 0; j < letter.length(); j++) {
                chars[i][j] = letter.charAt(j);
            }
        }

        for(int i = 0; i < chars[0].length; i++) {


        }
*/
        return result;
    }

    private static Map<Character, String> letters = Map.of('2', "abc", '3', "def", '4', "ghi",
            '5', "jkl", '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");

    private static char getCharachterFromLettersAt(String letters, int index) {
        if(letters == null || letters.isEmpty() || index < 0 || index > letters.length() - 1)
            return '!';

        return letters.charAt(index);
    }

    private static String getStringOfLettersOfDigit(char digit) {
        return letters.get(digit);
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber fud = new LetterCombinationsOfAPhoneNumberMySolution();
        String digits = "2345";
        System.out.println(fud.letterCombinations(digits));
        digits = "23";
        System.out.println(fud.letterCombinations(digits));
        digits = "";
        System.out.println(fud.letterCombinations(digits));
        digits = "2";
        System.out.println(fud.letterCombinations(digits));
    }
}
