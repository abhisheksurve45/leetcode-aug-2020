public class FindAllDuplicatesinArray {

    /**
     * Since 1 ≤ a[i] ≤ n, we can negate the element at index a[i], and if it is already negative, thats repeating!
     */
    class Solution {
        public List<Integer> findDuplicates(int[] nums) {
            List<Integer> dup = new ArrayList<>();

            for (int i = 0; i < nums.length; i++) {

                if (nums[Math.abs(nums[i]) - 1] > 0)
                    nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
                else
                    dup.add(Math.abs(nums[i]));
            }

            return dup;
        }
    }
}
