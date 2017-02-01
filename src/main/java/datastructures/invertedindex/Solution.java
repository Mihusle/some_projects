package datastructures.invertedindex;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MHSL on 31.01.2017.
 */
public class Solution {
    
    public static void main(String[] args) {
        InvertedIndex invertedIndex = new InvertedIndex();
        invertedIndex.add(new File("src/main/resources/files/first.txt"));
        List<File> files = new ArrayList<>();
        files.add(new File("src/main/resources/files/second.txt"));
        files.add(new File("src/main/resources/files/third.txt"));
        invertedIndex.addFiles(files);
        System.out.println(invertedIndex.toString());
    }
}
