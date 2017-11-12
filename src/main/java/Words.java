import PrefixTree.PrefixTree;

import java.io.*;
import java.util.ArrayList;

public class Words {
    private String path;
    private BufferedReader reader;
    private ArrayList<String> allWords;
    private PrefixTree prefixTree;
    private int simpleWords = 0;
    private int concatenatedWords = 0;
    private String max = "";
    private String maxSecond = "";


    public Words(String path) throws FileNotFoundException {
        setPath(path);
        allWords = new ArrayList<String>();
    }

    private void setPath(String path) throws FileNotFoundException {
        if (new File(path).exists()) {
            this.path = path;
        } else {
            throw new FileNotFoundException("File doesn't exist");
        }
    }

    public void start() {

        try {
            String newWord;
            reader = new BufferedReader(new FileReader(path));
            while ((newWord = reader.readLine()) != null) {
                allWords.add(newWord.trim());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (allWords.size() > 0) {
            prefixTree = new PrefixTree(allWords);
            int concatenationLevel;
            for (String word : allWords) {
                concatenationLevel = isConcatenated(word);
                if (concatenationLevel == 0) {
                    System.out.println("Tree does not have word " + word);
                    return;
                } else if (concatenationLevel == 1) {
                    simpleWords++;
                } else {
                    concatenatedWords++;
                    if (word.length() > max.length()) {
                        maxSecond = max;
                        max = word;
                    }
                }
            }
        } else {
            System.out.println("Nothing in list");
        }
    }

    private int isConcatenated(String word) {
        for (int i = 1; i <= word.length(); i++) {
            if (prefixTree.contains(word.substring(0, i))) {
                if (i == word.length()) {
                    return 1;
                } else if (isConcatenated(word.substring(i)) > 0) {
                    return isConcatenated(word.substring(i)) + 1;
                }
            }
        }
        return 0;
    }

    public int getSimpleWords() {
        return simpleWords;
    }

    public int getConcatenatedWords() {
        return concatenatedWords;
    }

    public String getMaxFirst() {
        return max;
    }

    public String getMaxSecond() {
        return maxSecond;
    }

    public int getMaxFirstLength() {
        return max.length();
    }

    public int getMaxSecondLength() {
        return maxSecond.length();
    }
}