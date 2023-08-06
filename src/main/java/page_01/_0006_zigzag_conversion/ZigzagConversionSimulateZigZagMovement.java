package page_01._0006_zigzag_conversion;

import java.util.Arrays;

public class ZigzagConversionSimulateZigZagMovement implements ZigzagConversion {
    // Using Simulate Zig-Zag Movement
    // Time: O(numRows⋅n)
    // Space: O(numRows⋅n)
    @Override
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        int n = s.length();
        int sections = (int) Math.ceil(n / (2 * numRows - 2.0));
        int numCols = sections * (numRows - 1);

        char[][] matrix = new char[numRows][numCols];
        for (char[] row: matrix) {
            Arrays.fill(row, ' ');
        }

        int currRow = 0, currCol = 0;
        int currStringIndex = 0;

        // Iterate in zig-zag pattern on matrix and fill it with string characters.
        while (currStringIndex < n) {
            // Move down.
            while (currRow < numRows && currStringIndex < n) {
                matrix[currRow][currCol] = s.charAt(currStringIndex);
                currRow++;
                currStringIndex++;
            }

            currRow -= 2;
            currCol++;

            // Move up (with moving right also).
            while (currRow > 0 && currCol < numCols && currStringIndex < n) {
                matrix[currRow][currCol] = s.charAt(currStringIndex);
                currRow--;
                currCol++;
                currStringIndex++;
            }
        }

        StringBuilder answer = new StringBuilder();
        for (char[] row: matrix) {
            for (char character: row) {
                if (character != ' ') {
                    answer.append(character);
                }
            }
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        ZigzagConversion fud = new ZigzagConversionSimulateZigZagMovement();
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
