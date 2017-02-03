package text.words.counter;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by MHSL on 03.02.2017.
 *
 * Count Words in a String - Counts the number of individual words in a string.
 * For added complexity read these strings in from a text file and generate a summary.
 */
public class WordsCounter {
    
    public static void main(String[] args) {
        String line = readFile(new File("src/main/resources/files/first.txt"));
        System.out.println(countWords(line));
    }
    
    public static Map<String, Integer> countWords(String line) {
        Map<String, Integer> report = new HashMap<>();
        for (String word : line.split(" |,|\\.|!|\\?|:|;")) {
            if (!word.equals("")) {
                word = word.toLowerCase();
                if (report.containsKey(word)) {
                    report.replace(word, report.get(word) + 1);
                } else {
                    report.put(word, 1);
                }
            }
        }
        return report;
    }
    
    private static String readFile(File file) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
    
    
}
