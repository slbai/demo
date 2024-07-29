package a20230227;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    static class Node {
        Map<Character, Node> data = new HashMap<>();
        boolean isEnd;
    }

    Node root = new Node();

    public void add(String string) {
        Node currentNode = root;
        for (char c : string.toCharArray()) {
            currentNode = currentNode.data.computeIfAbsent(c, a->new Node());
        }
        currentNode.isEnd = true;
    }

    public boolean has(String string) {
        Node currentNode = root;
        for (char c : string.toCharArray()) {
            currentNode = currentNode.data.get(c);
            if (currentNode == null) {
                return false;
            }
        }
        return currentNode.isEnd;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.add("apple");
        trie.add("append");
        trie.add("cool");
        trie.add("cold");
        trie.add("cold");

        System.out.println(trie.has("apple"));
        System.out.println(trie.has("append"));
        System.out.println(trie.has("cool"));
        System.out.println(trie.has("cold"));
        System.out.println(trie.has("cold"));

        System.out.println("-----------");
        System.out.println(trie.has("col"));
        System.out.println(trie.has("colding"));
        System.out.println(trie.has("banana"));

    }
}
