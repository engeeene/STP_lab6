package PrefixTree;

import java.util.List;

public class PrefixTree {
    private PrefixNode root = new PrefixNode();

    public PrefixTree(List<String> words) {
        for (String word : words){
            insert(word);
        }
    }

    private void insert(String word) {
        PrefixNode currentNode = root;
        for (int i = 0; i < word.length(); i++){
            if (currentNode.leters[charIndex(word.charAt(i))] == null) {
                currentNode = currentNode.leters[charIndex(word.charAt(i))] = new PrefixNode();
            } else {
                currentNode = currentNode.leters[charIndex(word.charAt(i))];
            }
        }
        currentNode.isEnd = true;
    }

    public boolean contains(String word){
        PrefixNode currentNode = findNodeByWord(word);
        if (currentNode != null && currentNode.isEnd) {
            return true;
        }
        return false;
    }

    private PrefixNode findNodeByWord(String word){
        PrefixNode currentNode = root;
        for (int i = 0; i < word.length(); i++){
            if (currentNode.leters[charIndex(word.charAt(i))] == null) {
                return null;
            } else {
                currentNode = currentNode.leters[charIndex(word.charAt(i))];
            }
        }
        return currentNode;
    }

    private int charIndex(char c) {
        return c - 'a';
    }
}
