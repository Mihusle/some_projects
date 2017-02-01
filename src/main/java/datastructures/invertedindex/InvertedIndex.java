package datastructures.invertedindex;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by MHSL on 31.01.2017.
 *
 * Inverted index - An Inverted Index is a data structure used to create full text search. Given a set of text files,
 * implement a program to create an inverted index. Also create a user interface to do a search using that inverted
 * index which returns a list of files that contain the query term / terms. The search index can be in memory.
 *
 * I don't want to create GUI right now, because I wanted to work out with only algorithm.
 * Maybe one of these days, when I'll study Swing, I'll delete this comment and create it, but not today.
 */
public class InvertedIndex {
    
    private Map<String, Set<Integer>> map;
    private int nextFileIndex = 0;

    public InvertedIndex() {
        map = new HashMap<>();
    }
    
    public void add(File file) {
        String[] words = readFile(file).split(" |\\.|,|!|\\?|\\s");
        for (String word : words) {
            word = makeWordClean(word);
            if (!word.equals("")) {
                if (!map.containsKey(word)) {
                    Set<Integer> filesNumbers = new TreeSet<>();
                    filesNumbers.add(nextFileIndex);
                    map.put(word, filesNumbers);
                } else if (!map.get(word).contains(nextFileIndex)) {
                    map.get(word).add(nextFileIndex);
                }
            }
        }
        nextFileIndex++;
    }
    
    public void addFiles(Collection<File> files) {
        files.forEach(this::add);
    }
    
    public void clear() {
        map.clear();
    }
    
    public Set<Integer> get(String word) {
        return map.get(word);
    }
    
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner("", "{", "}");
        for (Map.Entry<String, Set<Integer>> pair : map.entrySet()) {
            joiner.add(pair.getKey() + " = " + pair.getValue().toString() + "\n");
        }
        return joiner.toString();
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
    
    private static String makeWordClean(String word) {
        /*
        * If a word contains only numbers, spaces or strange symbols then it isn't a word.
        * In case when these symbols are contained in the middle of a word then it can be HTML tag for example
        * or something like this.
        */
        Pattern numberPattern = Pattern.compile("(\\d+)|(\\s+)|(\\W+)");
        Matcher numberMatcher = numberPattern.matcher(word);
        if (!numberMatcher.matches()) {
            Pattern pattern = Pattern.compile(".*\\W.*"); //If word contains strange symbols then replace them with nothing.
            Matcher matcher = pattern.matcher(word);
            if (matcher.matches()) {
                word = word.replaceAll("\\W", "");
            }
            return word;
        }
        return "";
    }
}
