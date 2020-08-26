public class FizzBuzz {

    class Solution {

        private static final String FIZZ = "Fizz";
        private static final String BUZZ = "Buzz";
        private static final String FIZZBUZZ = "FizzBuzz";

        public List<String> fizzBuzz(int n) {

            List<String> result = new ArrayList<>();

            for (int i = 1; i <= n; i++) {

                if (i % 3 == 0 || i % 5 == 0) {

                    if (i % 3 == 0 && i % 5 == 0) result.add(FIZZBUZZ);
                    else if (i % 3 == 0) result.add(FIZZ);
                    else result.add(BUZZ);

                } else {

                    result.add(String.valueOf(i));

                }
            }

            return result;
        }
    }
}
