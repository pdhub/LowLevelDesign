package linkedIn.code.array;

import java.util.*;

/**
 * Created by pdeb on 11/15/2017.
 */
public class UserMainCode {

    public class Result{
        public final int output1;
        public final int output2;

        public Result(int output1, int output2) {
            this.output1 = output1;
            this.output2 = output2;
        }
    }

    class Country{
        private int[] ratings;

        public Country(int[] ratings) {
            this.ratings = ratings;
        }
    }

    class CountryComparator implements Comparator<Country> {

        public int compare(Country c1, Country c2) {
            int[] c1Ratings = c1.ratings.clone();
            int[] c2Ratings = c2.ratings.clone();

            Arrays.sort(c1Ratings);
            Arrays.sort(c2Ratings);

            for (int i = 0; i <c1.ratings.length ; i++) {
                if(c1Ratings[i]==c2Ratings[i])
                    continue;
                if(c1Ratings[i] < c2Ratings[i])
                    return -1;
                else
                    return 1;
            }
            return 0;
        }
    }

    public Result Survey(int input1, int input2, int input3, int input4[]){

        int totalNumberOfStates = input1;
        int numStatesPerCountry = input2;
        int monthOnWhichToDetermineLocation = input3;
        int[] allStatesRating = input4;

        List<Country> countries = new ArrayList<Country>();
        for (int i = 0; i < allStatesRating.length;) {
            int ratings[] = new int[numStatesPerCountry];
            for (int j = 0; j < numStatesPerCountry; j++) {
                ratings[j] = allStatesRating[i];
                i++;
            }
            Country country = new Country(ratings);
            countries.add(country);
        }

        Collections.sort(countries, new CountryComparator());

        /*int countryIndex = monthOnWhichToDetermineLocation%2==0?monthOnWhichToDetermineLocation/numStatesPerCountry-1:
                monthOnWhichToDetermineLocation/numStatesPerCountry;*/

        int countryIndex = monthOnWhichToDetermineLocation/numStatesPerCountry-1;
        Country country = countries.get(countryIndex);

        System.out.println(String.format("Country : %s" , countryIndex+1));
        /*System.out.println(String.format("State with Rating : %s",
                country.ratings[(monthOnWhichToDetermineLocation - ((countryIndex-1)*numStatesPerCountry))-1]));*/
        System.out.println(String.format("State with Rating : %s",
                country.ratings[(country.ratings.length-1)-monthOnWhichToDetermineLocation%numStatesPerCountry]));
        //throw new UnsupportedOperationException();
        return null;
    }

    public static void main(String[] args) {
        int s[] = {2,1,9,3,1,4};
        new UserMainCode().Survey(6, 3, 6, s);

        int s2[] = {4,5,7,9,3,2,5,1,3,2,4,1};
        new UserMainCode().Survey(12, 3, 7, s2);

        if(2==2){

        }else if(2==3){

        }else if(3==3){

        }
    }
}
