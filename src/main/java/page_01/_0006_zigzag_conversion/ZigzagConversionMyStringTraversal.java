package page_01._0006_zigzag_conversion;

public class ZigzagConversionMyStringTraversal implements ZigzagConversion {
    // Using String Traversal
    // Time: O(N)
    // Space: O(1)
    @Override
    public String convert(String s, int numRows) {
        if(s.length() < numRows) {
            numRows = s.length();
        }

        if(numRows == 1) {
            return s;
        }

        StringBuilder result = new StringBuilder();

        int total_increment = 2 * (numRows - 1);

        for(int row = 0; row < numRows; row++) {
            result.append(s.charAt(row));
            int even_increment = total_increment - row * 2;
            int odd_increment = total_increment - even_increment;

            for(int i = 0; i < s.length(); ) {


                // Even Increment
                if(s.length() > row + i + even_increment && even_increment != 0) {
                    result.append(s.charAt(row + i + even_increment));
                }
                i = i + even_increment;

                // Odd Increment
                if(s.length() > row + i + odd_increment && odd_increment != 0) {
                    result.append(s.charAt(row + i + odd_increment));
                }
                i = i + odd_increment;
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        ZigzagConversion fud = new ZigzagConversionMyStringTraversal();
        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(fud.convert(s, numRows));

        s = "PAYPALISHIRING";
        numRows = 4;
        System.out.println(fud.convert(s, numRows));

        s = "PAYPALISHIRING";
        numRows = 5;
        System.out.println(fud.convert(s, numRows));

        s = "A";
        numRows = 1;
        System.out.println(fud.convert(s, numRows));

        s = "A";
        numRows = 2;
        System.out.println(fud.convert(s, numRows));

        s = "ABC";
        numRows = 1;
        System.out.println(fud.convert(s, numRows));

        s = "ABC";
        numRows = 2;
        System.out.println(fud.convert(s, numRows));

        s = "ABC";
        numRows = 3;
        System.out.println(fud.convert(s, numRows));

        s = "ABC";
        numRows = 4;
        System.out.println(fud.convert(s, numRows));
    }
}
