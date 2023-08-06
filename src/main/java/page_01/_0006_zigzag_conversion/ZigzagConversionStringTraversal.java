package page_01._0006_zigzag_conversion;

public class ZigzagConversionStringTraversal implements ZigzagConversion {
    // Using String Traversal
    // Time: O(N)
    // Space: O(1)
    @Override
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        StringBuilder answer = new StringBuilder();
        int n = s.length();
        int charsInSection = 2 * (numRows - 1);

        for (int currRow = 0; currRow < numRows; ++currRow) {
            int index = currRow;

            while (index < n) {
                answer.append(s.charAt(index));

                // If currRow is not the first or last row
                // then we have to add one more character of current section.
                if (currRow != 0 && currRow != numRows - 1) {
                    int charsInBetween = charsInSection - 2 * currRow;
                    int secondIndex = index + charsInBetween;

                    if (secondIndex < n) {
                        answer.append(s.charAt(secondIndex));
                    }
                }
                // Jump to same row's first character of next section.
                index += charsInSection;
            }
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        ZigzagConversion fud = new ZigzagConversionStringTraversal();
        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(fud.convert(s, numRows));

        s = "PAYPALISHIRING";
        numRows = 4;
        System.out.println(fud.convert(s, numRows));

        s = "A";
        numRows = 1;
        System.out.println(fud.convert(s, numRows));
    }
}
