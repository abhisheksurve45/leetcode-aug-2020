public class PowerofFour {

    /**
     * Conditions :
     * 1. Number should be greater than 0
     * 2. Only 1 bit must be set in order to be power of 4, Example : 4 = 100, 16 = 10000, hence num & (num - 1) == 0, gives if only 1 bit is set
     * 3. The set bit must be present only in odd position, Example : 4 = 100, 16 = 10000, 64 = 1000000, Explanation : https://leetcode.com/problems/power-of-four/discuss/80456/O(1)-one-line-solution-without-loops/85042
     */
    class Solution {
        public boolean isPowerOfFour(int num) {
            return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
        }
    }


    /**
     * Conditions :
     * 1. Number should be greater than 0
     * 2. Only 1 bit must be set in order to be power of 4, Example : 4 = 100, 16 = 10000, hence num & (num - 1) == 0, gives if only 1 bit is set
     * 3. Subtract 1 from num, and check whether divisible by 3 (subtract 1 to handle cases where num = 1)
     */
    class Solution {
        public boolean isPowerOfFour(int num) {
            return num > 0 && (num & (num - 1)) == 0 && (num - 1) % 3 == 0;
        }
    }


    /**
     * Naive iterative approach
     */
    class Solution {
        public boolean isPowerOfFour(int num) {
            while (num > 1) {
                if (num % 4 != 0) return false;
                num /= 4;
            }
            return num == 1;
        }
    }


    /**
     * Bit manipulation tricks :
     *
     * 1. https://leetcode.com/problems/sum-of-two-integers/discuss/84278/A-summary%3A-how-to-use-bit-manipulation-to-solve-problems-easily-and-efficiently
     * 2. http://graphics.stanford.edu/~seander/bithacks.html
     * 3. https://leetcode.com/problems/sum-of-two-integers/discuss/84290/Java-simple-easy-understand-solution-with-explanation
     */
}
