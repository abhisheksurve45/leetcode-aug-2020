public class ExcelSheetColumnNumber {

    class Solution {

        public int titleToNumber(String s) {
            int column = 0;
            if (s == null || s.isEmpty()) return column;
            char[] charArray = s.toCharArray();
            for (int i = 0; i < s.length(); i++) {
                column = (column * 26) + charArray[i] - 'A' + 1;
            }
            return column;
        }

    }
}
