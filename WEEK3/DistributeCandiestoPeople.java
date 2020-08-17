public class DistributeCandiestoPeople {

    /**
     * Video : https://www.youtube.com/watch?v=zQvjTsW74Y8
     */
    class Solution {
        public int[] distributeCandies(int candies, int num_people) {
            int[] people = new int[num_people];

            int i = 0, candy = 1;

            while (candies >= candy) {
                if (i == num_people) i = 0;
                people[i] += candy;
                candies -= candy;
                candy += 1;
                i++;
            }

            if (candies > 0) {
                if (i == num_people) i = 0;
                people[i] += candies;
            }

            return people;
        }
    }
}
