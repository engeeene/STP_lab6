import PrefixTree.PrefixTree;

import java.io.*;
import java.util.ArrayList;

class Words {
    private String path;
    private BufferedReader reader;
    private ArrayList<String> allWords;
    private PrefixTree prefixTree;
    private int simpleWords = 0;
    private int concatenatedWords = 0;
    private int partiallyConcatenatedWords = 0;
    private String max = "";
    private String maxSecond = "";


    Words(String path) throws FileNotFoundException {
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

    void start() {

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
//                if (concatenationLevel == 0) {
//                    System.out.println("Tree does not have word " + word);
//                    return;
//                } else
                if (concatenationLevel == 1) {
                    simpleWords++;
                    if (prefixTree.isContained(word)) {
                        partiallyConcatenatedWords++;
                    }
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
            if (prefixTree.startsWith(word.substring(0, i))) {
                if (i == word.length()) {
                    return 1;
                } else if (isConcatenated(word.substring(i)) > 0) {
                    return isConcatenated(word.substring(i)) + 1;
                }
            }
        }
        return 0;
    }

    int getSimpleWords() {
        return simpleWords;
    }

    int getConcatenatedWords() {
        return concatenatedWords;
    }

    public int getPartiallyConcatenatedWords() {
        return partiallyConcatenatedWords;
    }

    String getMaxFirst() {
        return max;
    }

    String getMaxSecond() {
        return maxSecond;
    }

    int getMaxFirstLength() {
        return max.length();
    }

    int getMaxSecondLength() {
        return maxSecond.length();
    }
}