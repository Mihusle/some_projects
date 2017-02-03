package text.pig.latin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

/**
 * Created by MHSL on 03.02.2017.
 *
 * Pig Latin - Pig Latin is a game of alterations played on the English language game. To create the Pig Latin form of
 * an English word the initial consonant sound is transposed to the end of the word and an ay is affixed
 * (Ex.: "banana" would yield anana-bay).
 */
public class PigLatin {
    
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String line = reader.readLine();
            StringBuilder builder = new StringBuilder();
            for (String word : line.split(" ")) {
                builder.append(makeWordPigLatins(word)).append(" ");
            }
            System.out.println(builder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static String makeWordPigLatins(String word) {
        Pattern pattern = Pattern.compile("(?i:[qwrtpsdfghjklzxcvbnm])");
        int i = 0;
        StringBuilder builder = new StringBuilder("-");
        String symbol = String.valueOf(word.charAt(i));
        while (pattern.matcher(symbol).matches()) {
            builder.append(symbol);
            symbol = String.valueOf(word.charAt(++i));
        }
        builder.append("ay");
        return word.substring(i, word.length()) + builder.toString();
    }
}
