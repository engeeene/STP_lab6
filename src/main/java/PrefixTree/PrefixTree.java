package PrefixTree;

import java.util.List;

public class PrefixTree {
    private PrefixNode root = new PrefixNode();

    public PrefixTree(List<String> words) {
        for (String word : words) {
            insert(word);
        }
    }

    private void insert(String word) {
        PrefixNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            if (currentNode.leters[charIndex(word.charAt(i))] == null) {
                currentNode = currentNode.leters[charIndex(word.charAt(i))] = new PrefixNode();
            } else {
                currentNode = currentNode.leters[charIndex(word.charAt(i))];
            }
        }
        currentNode.isEnd = true;
    }

    public boolean startsWith(String word) {
        PrefixNode currentNode = findNodeByWord(word);
        if (currentNode != null && currentNode.isEnd) {
            return true;
        }
        return false;
    }

    private PrefixNode findNodeByWord(String word) {
        PrefixNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            if (currentNode.leters[charIndex(word.charAt(i))] == null) {
                return null;
            } else {
                currentNode = currentNode.leters[charIndex(word.charAt(i))];
            }
        }
        return currentNode;
    }

    public boolean isContained(String inputWord) {
        PrefixNode currentNode;
        String word;
        for (int i = 0; i < inputWord.length(); i++) {
            word = inputWord.substring(i);
            currentNode = root;
            for (int j = 0; j < word.length(); j++) {
                if (i == 0 && j == word.length() - 1) {
                    continue;
                }
                if (currentNode.leters[charIndex(word.charAt(j))] == null) {
                    return false;
                } else {
                    currentNode = currentNode.leters[charIndex(word.charAt(j))];
                    if (currentNode.isEnd) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    private int charIndex(char c) {
        return c - 'a';
    }
}
