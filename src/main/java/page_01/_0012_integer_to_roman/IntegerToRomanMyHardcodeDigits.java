package page_01._0012_integer_to_roman;

public class IntegerToRomanMyHardcodeDigits implements IntegerToRoman {
    // Using Hardcode Digits
    // Time: O(1)
    // Space: O(1)
    @Override
    public String intToRoman(int num) {
        if(num < 1 || num > 3999) {
            return "";
        }
        return getThousands(num / 1000) + getHundreds((num /100) % 10) + getTens((num / 10) % 10)
                + getOnes(num % 10);
    }

    private String getOnes(int num) {
        return switch (num) {
            case 1 -> "I";
            case 2 -> "II";
            case 3 -> "III";
            case 4 -> "IV";
            case 5 -> "V";
            case 6 -> "VI";
            case 7 -> "VII";
            case 8 -> "VIII";
            case 9 -> "IX";
            default -> "";
        };
    }

    private String getTens(int num) {
        return switch (num) {
            case 1 -> "X";
            case 2 -> "XX";
            case 3 -> "XXX";
            case 4 -> "XL";
            case 5 -> "L";
            case 6 -> "LX";
            case 7 -> "LXX";
            case 8 -> "LXXX";
            case 9 -> "XC";
            default -> "";
        };
    }

    private String getHundreds(int num) {
        return switch (num) {
            case 1 -> "C";
            case 2 -> "CC";
            case 3 -> "CCC";
            case 4 -> "CD";
            case 5 -> "D";
            case 6 -> "DC";
            case 7 -> "DCC";
            case 8 -> "DCCC";
            case 9 -> "CM";
            default -> "";
        };
    }

    private String getThousands(int num) {
        return switch (num) {
            case 1 -> "M";
            case 2 -> "MM";
            case 3 -> "MMM";
            default -> "";
        };
    }

    public static void main(String[] args) {
        IntegerToRoman fud = new IntegerToRomanMyHardcodeDigits();
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
