package text.vowel.counter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.regex.Pattern;
import java.util.Map;

/**
 * Created by MHSL on 03.02.2017.
 *
 * Count Vowels - Enter a string and the program counts the number of vowels in the text.
 * For added complexity have it report a sum of each vowel found.
 */
public class VowelCounter {
    
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String line = reader.readLine();
            System.out.println(countVowels(line));
            System.out.println(countVowelsWithStatistic(line));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static int countVowels(String line) {
        Pattern pattern = Pattern.compile("(?i:[aeyuio])");
        int count = 0;
        for (String word : line.split(" ")) {
            for (int i = 0; i < word.length(); i++) {
                String symbol = String.valueOf(word.charAt(i));
                if (pattern.matcher(symbol).matches()) {
                    count++;
                }
            }
        }
        return count;
    }
    
    public static Map<String, Integer> countVowelsWithStatistic(String line) {
        Map<String, Integer> vowelsMap = new HashMap<>();
        String[] vowels = new String[] {"a", "e", "y", "u", "i", "o"};
        for (String vowel : vowels) {
            vowelsMap.put(vowel, 0);
        }
        for (String word : line.split(" ")) {
            for (int i = 0; i < word.length(); i++) {
                String symbol = String.valueOf(word.charAt(i)).toLowerCase();
                if (vowelsMap.containsKey(symbol)) {
                    vowelsMap.replace(symbol, vowelsMap.get(symbol) + 1);
                }
            }
        }
        return vowelsMap;
    }
}
