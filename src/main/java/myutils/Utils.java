package myutils;

import java.util.Random;

public class Utils {

    public static String generatePersonId() {

        int leftLimit = 65;
        int rightLimit = 122;
        int targetStringLength = 13;
        Random random = new Random();
        StringBuilder builder = new StringBuilder(targetStringLength);
        for(int i = 0 ; i < targetStringLength; i++){
            int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
            builder.append((char) randomLimitedInt);
        }
        String generatedString = builder.toString();
        return generatedString;
    }
}
